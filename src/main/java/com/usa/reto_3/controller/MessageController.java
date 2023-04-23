package com.usa.reto_3.controller;

import com.usa.reto_3.model.MessageModel;
import com.usa.reto_3.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping("/all")
    public List<MessageModel> obtener(){
        return messageService.obtener();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody MessageModel message){
        messageService.crear(message);
    }

    @PutMapping("/update")
    public void actualizar(@RequestBody MessageModel message){
        messageService.actualizar(message);}

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")int id){
        messageService. eliminar(id);
    }

}
