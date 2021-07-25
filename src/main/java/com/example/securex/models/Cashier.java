package com.example.securex.models;

import java.util.ArrayList;
import java.util.List;

public class Cashier {

    private String id;
    private String name;
    private boolean isNormal;
    private boolean isExclusive;
    private boolean isPreference;
    private Client client;

    public Cashier(String id, String name, boolean isNormal, boolean isExclusive, boolean isPreference) {
        this.id = id;
        this.name = name;
        this.isNormal = isNormal;
        this.isExclusive = isExclusive;
        this.isPreference = isPreference;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNormal() {
        return isNormal;
    }

    public void setNormal(boolean normal) {
        isNormal = normal;
    }

    public boolean isExclusive() {
        return isExclusive;
    }

    public void setExclusive(boolean exclusive) {
        isExclusive = exclusive;
    }

    public boolean isPreference() {
        return isPreference;
    }

    public void setPreference(boolean preference) {
        isPreference = preference;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public boolean isBusy(){
        if (client == null){
            return false;
        }
        return true;
    }

    public List<Integer> categoriesToAttend(){
        List<Integer> categoriesToAttend = new ArrayList<>();
        if (isBusy()){
            return categoriesToAttend;
        }
        if (isExclusive){
            categoriesToAttend.add(1);
        }
        if (isNormal){
            categoriesToAttend.add(2);
        }
        if (isPreference){
            categoriesToAttend.add(3);
        }
        return categoriesToAttend;
    }

    public Client getClient() {
        return client;
    }
}
