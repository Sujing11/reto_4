package com.usa.reto_3.controller;

import com.usa.reto_3.model.ClientModel;
import com.usa.reto_3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/all")
    public List<ClientModel> obtener(){
        return clientService.obtener();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ClientModel client){
        clientService.crear(client);
    }

    @PutMapping("/update")
    public void actualizar(@RequestBody ClientModel client){
        clientService.actualizar(client);}

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")int id){
        clientService. eliminar(id);
    }

}
