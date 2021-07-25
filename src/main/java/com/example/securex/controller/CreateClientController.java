package com.example.securex.controller;

import com.example.securex.models.Cashier;
import com.example.securex.services.CreateClientService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreateClientController {
    private CreateClientService createClientService;

    public CreateClientController(CreateClientService createClientService) {
        this.createClientService = createClientService;
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping ("/client")
    public void createClient(){
        this.createClientService.run();
    }
}
