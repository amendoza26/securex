package com.example.securex.repository;

import com.example.securex.models.Cashier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CashierRepository {
    private List<Cashier> cashierList = new ArrayList<>();

    public CashierRepository() {
        cashierList.add(new Cashier("1","gote",true,false,false));
//        cashierList.add(new Cashier("2","gote",true,false,false));
//        cashierList.add(new Cashier("3","gote",true,false,false));
//        cashierList.add(new Cashier("4","gote",true,false,false));
//        cashierList.add(new Cashier("5","gote",true,false,false));
        cashierList.add(new Cashier("6","gote",false,false,true));
//        cashierList.add(new Cashier("7","gote",false,true,false));
        cashierList.add(new Cashier("8","gote",false,true,false));

    }

    public List<Cashier> getCashierDTOList() {
        return cashierList;
    }

    public List<Cashier> updateCashier(Cashier cashier){
        for (Cashier currentCashier:cashierList){
            if (currentCashier.getId().equalsIgnoreCase(cashier.getId())){
                currentCashier.setNormal(cashier.isNormal());
                currentCashier.setExclusive(cashier.isExclusive());
                currentCashier.setPreference(cashier.isPreference());
                currentCashier.setClient(cashier.getClient());
            }
        }
        return cashierList;
    }
}
