package com.usa.reto_3.controller;

import com.usa.reto_3.model.ClientModel;
import com.usa.reto_3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(value = "*")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/all")
    public List<ClientModel> obtener(){
        return clientService.obtener();
    }

    @GetMapping("/{id}")
    public Optional<ClientModel> obtenerPorId(@PathVariable int id) {
        return clientService.obtenerPorId(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ClientModel client){
        clientService.crear(client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void actualizar(@RequestBody ClientModel client){
        clientService.actualizar(client);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable("id")int id){
        clientService. eliminar(id);
    }

}
