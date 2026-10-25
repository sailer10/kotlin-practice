package com.example.kotlinpractice.application.repository

import com.example.kotlinpractice.application.model.StudyRecord
import com.example.kotlinpractice.application.model.StudyStatus
import org.springframework.data.repository.CrudRepository

interface StudyRecordRepository : CrudRepository<StudyRecord, Long> {
    fun findAllByOrderByIdAsc(): List<StudyRecord>

    fun findByStatusOrderByIdAsc(status: StudyStatus): List<StudyRecord>
}
