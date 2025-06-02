package com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.handler;

import com.postechfiap_group130.techchallenge_fastfood.adapters.in.rest.dto.response.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDto> handleValidationExceptions(MethodArgumentNotValidException ex) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                HttpStatus.BAD_REQUEST.value(),
                String.format("%s, %s", ex.getBindingResult().getFieldErrors().getFirst().getField(),
                        ex.getBindingResult().getFieldErrors().getFirst().getDefaultMessage()
        ));

        return ResponseEntity.badRequest().body(errorResponseDto);
    }
}
