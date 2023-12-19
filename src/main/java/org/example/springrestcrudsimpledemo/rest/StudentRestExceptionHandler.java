package org.example.springrestcrudsimpledemo.rest;

import com.fasterxml.jackson.annotation.JacksonInject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentRestExceptionHandler {
    // catch student not found exception
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handlerIDNotFoundException(StudentNotFoundException ex) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // catch for other exception can happen
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handlerOtherException(Exception ex) {
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
