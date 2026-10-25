package com.example.kotlinpractice.application.service

import com.example.kotlinpractice.application.model.*
import com.example.kotlinpractice.application.repository.StudyRecordRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

class InvalidStudyTitle : RuntimeException("title must not be blank after trimming")

private val StudyRequest.normalizedTitle: String
    get() = title.trim().takeIf { it.isNotEmpty() } ?: throw InvalidStudyTitle()

class RecordNotFound(id: Long) : RuntimeException("Study record $id was not found")

@Service
@Transactional(readOnly = true)
class StudyRecordService(private val repository: StudyRecordRepository) {
    fun list(status: StudyStatus?): List<StudyRecord> =
        status?.let(repository::findByStatusOrderByIdAsc) ?: repository.findAllByOrderByIdAsc()

    fun get(id: Long): StudyRecord = repository.findByIdOrNull(id) ?: throw RecordNotFound(id)

    @Transactional
    fun create(request: StudyRequest): StudyRecord =
        repository.save(
            StudyRecord(title = request.normalizedTitle, description = request.description),
        )

    @Transactional
    fun update(id: Long, request: StudyRequest): StudyRecord =
        repository.save(
            get(id).copy(title = request.normalizedTitle, description = request.description),
        )

    @Transactional
    fun changeStatus(id: Long, status: StudyStatus): StudyRecord =
        repository.save(get(id).copy(status = status))

    @Transactional
    fun delete(id: Long) {
        repository.delete(get(id))
    }
}
