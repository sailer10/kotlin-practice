package com.example.kotlinpractice.application

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc
import org.springframework.http.MediaType
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import tools.jackson.databind.ObjectMapper

@SpringBootTest
@AutoConfigureMockMvc
class StudyRecordApiTest
@Autowired
constructor(
    private val mvc: MockMvc,
    private val jdbc: JdbcTemplate,
    private val mapper: ObjectMapper,
) {
    @BeforeEach
    fun cleanDatabase() {
        jdbc.update("DELETE FROM study_records")
    }

    private fun create(title: String = "Kotlin"): Long {
        val body = mapper.writeValueAsString(mapOf("title" to title, "description" to "문법 연습"))
        val result =
            mvc.perform(
                    post("/api/study-records")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body),
                )
                .andExpect(status().isCreated)
                .andExpect(header().exists("Location"))
                .andExpect(jsonPath("$.title").value(title.trim()))
                .andExpect(jsonPath("$.status").value("TODO"))
                .andReturn()
        return mapper.readTree(result.response.contentAsString).get("id").asLong()
    }

    @Test
    fun `create persists normalized title and nullable description`() {
        val id = create("  Kotlin  ")
        mvc.perform(get("/api/study-records/$id"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.title").value("Kotlin"))
            .andExpect(jsonPath("$.description").value("문법 연습"))
        mvc.perform(
                post("/api/study-records")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"title":"No description"}"""),
            )
            .andExpect(status().isCreated)
            .andExpect(jsonPath("$.description").isEmpty)
    }

    @Test
    fun `list returns saved records in id order`() {
        create("First")
        create("Second")
        mvc.perform(get("/api/study-records"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.length()").value(2))
            .andExpect(jsonPath("$[0].title").value("First"))
            .andExpect(jsonPath("$[1].title").value("Second"))
    }

    @Test
    fun `update replaces fields and preserves status`() {
        val id = create()
        mvc.perform(
                patch("/api/study-records/$id/status")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"status":"IN_PROGRESS"}"""),
            )
            .andExpect(status().isOk)
        mvc.perform(
                put("/api/study-records/$id")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"title":"  Functions  ","description":null}"""),
            )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.title").value("Functions"))
            .andExpect(jsonPath("$.description").isEmpty)
            .andExpect(jsonPath("$.status").value("IN_PROGRESS"))
        mvc.perform(get("/api/study-records/$id")).andExpect(jsonPath("$.title").value("Functions"))
    }

    @Test
    fun `status change is persisted and list filter is applied`() {
        val id = create()
        create("Other")
        mvc.perform(
                patch("/api/study-records/$id/status")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"status":"COMPLETED"}"""),
            )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.status").value("COMPLETED"))
        mvc.perform(get("/api/study-records").param("status", "COMPLETED"))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.length()").value(1))
            .andExpect(jsonPath("$[0].id").value(id))
    }

    @Test
    fun `delete removes record and subsequent lookup returns 404`() {
        val id = create()
        mvc.perform(delete("/api/study-records/$id")).andExpect(status().isNoContent)
        mvc.perform(get("/api/study-records/$id")).andExpect(status().isNotFound)
        mvc.perform(get("/api/study-records")).andExpect(jsonPath("$.length()").value(0))
    }

    @Test
    fun `all missing record mutations return 404`() {
        mvc.perform(get("/api/study-records/999999"))
            .andExpect(status().isNotFound)
            .andExpect(jsonPath("$.status").value(404))
        mvc.perform(delete("/api/study-records/999999")).andExpect(status().isNotFound)
        mvc.perform(
                put("/api/study-records/999999")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"title":"Missing"}"""),
            )
            .andExpect(status().isNotFound)
        mvc.perform(
                patch("/api/study-records/999999/status")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"status":"COMPLETED"}"""),
            )
            .andExpect(status().isNotFound)
    }

    @Test
    fun `invalid titles and long descriptions are rejected`() {
        for (title in listOf("", "   ", "x".repeat(121))) {
            mvc.perform(
                    post("/api/study-records")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(mapOf("title" to title))),
                )
                .andExpect(status().isBadRequest)
        }
        mvc.perform(
                post("/api/study-records")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(
                        mapper.writeValueAsString(
                            mapOf("title" to "Valid", "description" to "x".repeat(2001)),
                        ),
                    ),
            )
            .andExpect(status().isBadRequest)
        mvc.perform(get("/api/study-records")).andExpect(jsonPath("$.length()").value(0))
    }

    @Test
    fun `malformed payload and invalid enum values return 400`() {
        for (body in listOf("{", "{}", """{"title":null}""")) {
            mvc.perform(
                    post("/api/study-records")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body),
                )
                .andExpect(status().isBadRequest)
        }
        val id = create()
        for (body in listOf("{}", """{"status":null}""", """{"status":"UNKNOWN"}""")) {
            mvc.perform(
                    patch("/api/study-records/$id/status")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body),
                )
                .andExpect(status().isBadRequest)
        }
        mvc.perform(get("/api/study-records").param("status", "UNKNOWN"))
            .andExpect(status().isBadRequest)
    }

    @Test
    fun `update validation leaves saved record unchanged`() {
        val id = create()
        mvc.perform(
                put("/api/study-records/$id")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("""{"title":" "}"""),
            )
            .andExpect(status().isBadRequest)
        mvc.perform(get("/api/study-records/$id")).andExpect(jsonPath("$.title").value("Kotlin"))
    }

    @Test
    fun `empty database returns empty list`() {
        mvc.perform(get("/api/study-records"))
            .andExpect(status().isOk)
            .andExpect(content().json("[]"))
    }

    @Test
    fun `unicode whitespace titles return 400 and preserve saved records`() {
        val id = create()
        for (title in listOf("\u00a0", "\u2007", "\u202f")) {
            val body = mapper.writeValueAsString(mapOf("title" to title))
            mvc.perform(
                    post("/api/study-records")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body),
                )
                .andExpect(status().isBadRequest)
            mvc.perform(
                    put("/api/study-records/$id")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body),
                )
                .andExpect(status().isBadRequest)
        }
        mvc.perform(get("/api/study-records/$id")).andExpect(jsonPath("$.title").value("Kotlin"))
        mvc.perform(get("/api/study-records")).andExpect(jsonPath("$.length()").value(1))
    }
}
