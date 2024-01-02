package com.kronus.myfirstrest.controller;

import com.kronus.myfirstrest.DTO.Country;
import com.kronus.myfirstrest.model.PaymentDetails;
import com.kronus.myfirstrest.services.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestControllerDemo {
    private final PaymentService paymentService;

    public RestControllerDemo(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

    @GetMapping("/chao")
    public String chao() {
        return "Chao!";
    }

    @GetMapping("/Ukraine")
    public Country ukraine() {
        return Country.of("Ukraine", 50);
    }

    @GetMapping("/ListOfCountries")
    public List<Country> countries() {
        Country country1 = Country.of("Ukraine", 50);
        Country country2 = Country.of("France", 67);

        return List.of(country1, country2);
    }

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> makePayment() {
        PaymentDetails paymentDetails = paymentService.processPayment();
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(paymentDetails);
    }
}