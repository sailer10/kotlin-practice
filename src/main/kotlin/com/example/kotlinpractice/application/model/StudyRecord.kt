package com.example.kotlinpractice.application.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

enum class StudyStatus {
    TODO,
    IN_PROGRESS,
    COMPLETED,
}

@Table("STUDY_RECORDS")
data class StudyRecord(
    val title: String,
    val description: String? = null,
    val status: StudyStatus = StudyStatus.TODO,
    @Id val id: Long? = null,
)
