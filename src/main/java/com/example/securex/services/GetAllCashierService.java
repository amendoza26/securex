package com.example.securex.services;

import com.example.securex.models.Cashier;
import com.example.securex.repository.CashierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCashierService {
    private CashierRepository cashierRepository;

    public GetAllCashierService(CashierRepository cashierRepository) {
        this.cashierRepository = cashierRepository;
    }

    public List<Cashier> run(){
        return cashierRepository.getCashierDTOList();
    }
}
