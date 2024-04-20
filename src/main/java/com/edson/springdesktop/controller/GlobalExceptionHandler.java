package com.edson.springdesktop.controller;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.StringUtils;

@ControllerAdvice
public class GlobalExceptionHandler {
 
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        String errorMessage = "O corpo da requisição contém um formato inválido.";
        if (ex.getCause() != null && !StringUtils.isEmpty(ex.getCause().getMessage())) {
            errorMessage += " Detalhes: " + ex.getCause().getMessage();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationExceptions(ConstraintViolationException ex) {
        StringBuilder errorMessage = new StringBuilder();
        ex.getConstraintViolations().forEach(violation -> {
            errorMessage.append(violation.getMessage()).append("; ");
        });
        return ResponseEntity.badRequest().body(errorMessage.toString());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body("MethodArgumentNotValidException::: "+ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleGenericExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro interno no servidor.");
    }
}
