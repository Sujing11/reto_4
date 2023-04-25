package com.usa.reto_3.service;

import com.usa.reto_3.model.ClientModel;
import com.usa.reto_3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<ClientModel> obtener(){
        return clientRepository.findAll();
    }

    public Optional<ClientModel> obtenerPorId(int id) {
        return clientRepository. findById(id);
    }

    public void crear(ClientModel client) {
        if (!clientRepository.existsById(client.getIdClient())) {
            clientRepository.save(client);
        }
    }

    public ClientModel actualizar(ClientModel client) {
        if( clientRepository.existsById(client.getIdClient())) {
            Optional<ClientModel> e= clientRepository.findById(client.getIdClient());
            if(e.isPresent()) {
                if(client.getName()!=null) {
                    e.get().setName(client.getName());
                }
                if(Byte.valueOf(client.getAge())!=null) {
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null) {
                    e.get().setPassword(client.getPassword());
                }
                clientRepository. save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public void eliminar(int id) {
        clientRepository.deleteById(id);
    }

}
