package org.example.service;

import org.example.dao.ClientDao;
import org.example.model.Client;

public class ClientCrudService {

    private ClientDao clientDao = new ClientDao();

    public void saveClient(Client client){
        clientDao.save(client);
    }

    public Client findClientById(Long id){
        return clientDao.findById(id);
    }

    public void updateClient(Long id, Client client){
        clientDao.update(id, client);
    }

    public void deleteClient(Long id){
        clientDao.delete(id);
    }

}
