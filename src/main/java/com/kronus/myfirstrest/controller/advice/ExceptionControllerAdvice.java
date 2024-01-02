package com.kronus.myfirstrest.controller.advice;

import com.kronus.myfirstrest.exception.NotMoneyEnoughException;
import com.kronus.myfirstrest.model.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(NotMoneyEnoughException.class)
    public ResponseEntity<ErrorDetails> exceptionNotMoneyEnough() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Not enough money to make the payment");
        return ResponseEntity
                .badRequest()
                .body(errorDetails);
    }
}
