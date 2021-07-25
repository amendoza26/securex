package com.example.securex.services;

import com.example.securex.models.Cashier;
import com.example.securex.models.Client;
import com.example.securex.repository.CashierRepository;
import com.example.securex.repository.QueueRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateClientService {
    private CashierRepository cashierRepository;
    private QueueRepository queueRepository;

    public CreateClientService(CashierRepository cashierRepository, QueueRepository queueRepository) {
        this.cashierRepository = cashierRepository;
        this.queueRepository = queueRepository;
    }


    public void run(){
        Client client = new Client("Gote");
        System.out.println("client category: "+client.getClientCategory());
        this.queueRepository.addClient(client);
        attendClient();
    }

    public static void setTimeout(Runnable runnable, int delay){
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            }
            catch (Exception e){
                System.err.println(e);
            }
        }).start();
    }

    public void releaseCashier(Cashier cashier){
        cashier.setClient(null);
        attendClient();
    }

    public void attendClient(){
        for (Cashier cashier:cashierRepository.getCashierDTOList()){
            Client client = queueRepository.getClient(cashier.categoriesToAttend());
            if (client != null){
                cashier.setClient(client);
                this.queueRepository.deleteClient(client);
                setTimeout(() -> releaseCashier(cashier), 15000);
            }
        }
    }

}
