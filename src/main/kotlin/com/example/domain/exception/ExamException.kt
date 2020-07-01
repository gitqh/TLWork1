package com.example.domain.exception

open class ExamException : Exception()
class ExamNotExistException:ExamException()
class ExamStudentNotMatch:ExamException()