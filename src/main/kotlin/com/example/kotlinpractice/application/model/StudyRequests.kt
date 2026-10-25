package com.example.kotlinpractice.application.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class StudyRequest(
    @field:NotBlank @field:Size(max = 120) val title: String,
    @field:Size(max = 2000) val description: String? = null,
)

data class StatusRequest(val status: StudyStatus)
