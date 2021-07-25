package com.example.securex.models;

import java.rmi.server.UID;
import java.util.Random;
import java.util.UUID;

public class Client {

    private String id;
    private String name;
    private int age;
    private int clientCategory;

    public Client(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.setAge();
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

    public int getAge() {
        return age;
    }

    private void setAge() {
        Random randomAge = new Random();
        int clientAge = randomAge.nextInt(53) + 17;
        this.age = clientAge;
        this.setCategory();
    }

    private void setCategory() {
        int category = 3;
        //exclusive
        if ((this.age % 3 == 0) && (this.age < 60)) {
            category = 1;
        }
        //normal
        if ((this.age % 3 != 0) && (this.age < 60)) {
            category = 2;
        }
        this.clientCategory = category;
    }

    public int getClientCategory() {
        return clientCategory;
    }


}
