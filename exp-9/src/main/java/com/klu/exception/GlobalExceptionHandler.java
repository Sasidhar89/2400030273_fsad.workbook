package com.klu.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import com.klu.model.ErrorResponse;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFound(StudentNotFoundException ex){

        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now().toString(),
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponse> handleInvalidInput(InvalidInputException ex){

        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now().toString(),
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}