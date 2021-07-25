package com.example.securex.controller;

import com.example.securex.models.Cashier;
import com.example.securex.services.GetAllCashierService;
import com.example.securex.services.UpdateCashierService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UpdateCashierController {
    private UpdateCashierService updateCashierService;

    public UpdateCashierController(UpdateCashierService updateCashierService) {
        this.updateCashierService = updateCashierService;
    }

    @PutMapping("/cashier")
    public List<Cashier> updateCashier(@RequestBody Cashier cashier){
        return updateCashierService.run(cashier);
    }


}
