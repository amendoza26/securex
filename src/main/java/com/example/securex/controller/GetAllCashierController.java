package com.example.securex.controller;

import com.example.securex.models.Cashier;
import com.example.securex.services.GetAllCashierService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class GetAllCashierController {

    private GetAllCashierService getAllCashierService;

    public GetAllCashierController(GetAllCashierService getAllCashierService) {
        this.getAllCashierService = getAllCashierService;
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/cashier")
    public List<Cashier> getCashiers(){
        return getAllCashierService.run();
    }

}
