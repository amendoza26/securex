package com.example.securex.repository;

import com.example.securex.models.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Repository
public class QueueRepository {
    private List<Client> clientList = new ArrayList<>();

    public void addClient (Client client){
        clientList.add(client);
    }

    public Client getClient (List<Integer> categories){
        for (Client client:clientList){
            if (categories.contains(client.getClientCategory())){
                return client;

            }
        }

        return null;
    }

    public void deleteClient(Client client){
        clientList.removeIf(client1 -> client1.getId().equalsIgnoreCase(client.getId()));
    }


}
