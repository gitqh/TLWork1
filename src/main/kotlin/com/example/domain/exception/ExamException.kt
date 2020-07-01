package com.example.domain.exception

open class ExamException : Exception()
class ExamNotExistException : ExamException()
class ExamStudentNotMatch : ExamException()
class ExamNotStartException : ExamException()
class ExamIsEndException : ExamException()