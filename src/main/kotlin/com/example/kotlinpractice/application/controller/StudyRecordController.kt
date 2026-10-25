package com.example.kotlinpractice.application.controller

import com.example.kotlinpractice.application.model.*
import com.example.kotlinpractice.application.service.StudyRecordService
import jakarta.validation.Valid
import java.net.URI
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/study-records")
class StudyRecordController(private val service: StudyRecordService) {
    @GetMapping
    fun list(@RequestParam(required = false) status: StudyStatus?): List<StudyRecord> =
        service.list(status)

    @GetMapping("/{id}") fun get(@PathVariable id: Long): StudyRecord = service.get(id)

    @PostMapping
    fun create(@Valid @RequestBody request: StudyRequest): ResponseEntity<StudyRecord> {
        val saved = service.create(request)
        return ResponseEntity.created(URI.create("/api/study-records/${saved.id}")).body(saved)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Valid @RequestBody request: StudyRequest): StudyRecord =
        service.update(id, request)

    @PatchMapping("/{id}/status")
    fun changeStatus(@PathVariable id: Long, @RequestBody request: StatusRequest): StudyRecord =
        service.changeStatus(id, request.status)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        service.delete(id)
        return ResponseEntity.noContent().build()
    }
}
