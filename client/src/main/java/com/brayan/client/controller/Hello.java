package com.brayan.client.controller;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.sentry.Sentry;

@RestController
@RequestMapping("/sender")
public class Hello {

    private final RestTemplate restTemplate;

    public Hello(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        String url = "http://clienttwo:8081/receiver/receive"; // Nombre del servicio en Docker Compose
        ResponseEntity<String> response = restTemplate.postForEntity(url, message, String.class);
        return ResponseEntity.ok("Message sent! Response: " + response.getBody());
    }

    @GetMapping("/error")
    public ResponseEntity<String> Message(){
        
        try {
            // Generar un error intencional
            throw new RuntimeException("¡Error intencional para probar Sentry!");
        } catch (Exception e) {
            // Capturar y reportar el error a Sentry
            Sentry.captureException(e);
            return ResponseEntity.status(500).body("Error capturado y enviado a Sentry");
        }

    }





}
