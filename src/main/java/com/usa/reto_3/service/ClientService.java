package com.usa.reto_3.service;

import com.usa.reto_3.model.ClientModel;
import com.usa.reto_3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<ClientModel> obtener(){
        return clientRepository.findAll();
    }

    public void crear(ClientModel client) {
        if (!clientRepository.existsById(client.getIdClient())) {
            clientRepository.save(client);
        }
    }

    public void actualizar(ClientModel client){
        if (clientRepository.existsById(client.getIdClient())) {
            ClientModel clientActual = clientRepository.findById(client.getIdClient()).get();
            clientActual.setAge(client.getAge());
            clientActual.setEmail(client.getEmail());
            clientActual.setName(client.getName());
            clientActual.setPassword(client.getPassword());
            clientRepository.save(client);
        }
    }

    public void eliminar(int id) {
        clientRepository.deleteById(id);
    }
}
