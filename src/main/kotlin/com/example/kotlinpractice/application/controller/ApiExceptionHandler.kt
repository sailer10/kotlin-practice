package com.example.kotlinpractice.application.controller

import com.example.kotlinpractice.application.service.InvalidStudyTitle
import com.example.kotlinpractice.application.service.RecordNotFound
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiExceptionHandler {
    @ExceptionHandler(InvalidStudyTitle::class)
    fun invalidTitle(exception: InvalidStudyTitle): ProblemDetail =
        ProblemDetail.forStatusAndDetail(
            HttpStatus.BAD_REQUEST,
            exception.message ?: "Invalid title",
        )

    @ExceptionHandler(RecordNotFound::class)
    fun notFound(exception: RecordNotFound): ProblemDetail =
        ProblemDetail.forStatusAndDetail(
            HttpStatus.NOT_FOUND,
            exception.message ?: "Record not found",
        )
}
