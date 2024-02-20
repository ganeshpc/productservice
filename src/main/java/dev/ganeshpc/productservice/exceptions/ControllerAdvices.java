package dev.ganeshpc.productservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import dev.ganeshpc.productservice.dtos.ExceptionDto;

@ControllerAdvice
public class ControllerAdvices {

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ExceptionDto> handleProductNotFoundException(
            ProductNotFoundException productNotFoundException) {
        return new ResponseEntity<>(
                new ExceptionDto(HttpStatus.NOT_FOUND, productNotFoundException.getMessage()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductCreationFailedException.class)
    private ResponseEntity<ExceptionDto> handleProductCreationFailedException(
            ProductNotFoundException productNotFoundException) {
        return new ResponseEntity<>(
                new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR, productNotFoundException.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
