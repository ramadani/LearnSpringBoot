package id.ramadani.learn.handler

import id.ramadani.learn.handler.exceptions.NotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(request: HttpServletRequest, throwable: Throwable): ResponseEntity<CustomError> {
        return ResponseEntity(
                CustomError(throwable.message ?: "", HttpStatus.NOT_FOUND.value()),
                HttpStatus.NOT_FOUND
        )
    }

    data class CustomError(val message: String, val status: Int)
}