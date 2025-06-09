package com.brayan.clienttwo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receiver")
public class Hello {
    @PostMapping("/receive")
    public ResponseEntity<String> receiveMessage(@RequestBody String message) {
        System.out.println("Received message:" + message);
        return ResponseEntity.ok("Message received: " + message);
    }
}
