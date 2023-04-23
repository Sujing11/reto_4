package com.usa.reto_3.service;

import com.usa.reto_3.model.MessageModel;
import com.usa.reto_3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public List<MessageModel> obtener(){
        return messageRepository.findAll();
    }


    public void crear(MessageModel message){
        if(!messageRepository.existsById(message.getIdMessage())) {
            messageRepository.save(message);
        }
    }

    public void actualizar(MessageModel message){
        if (messageRepository.existsById(message.getIdMessage())) {
            MessageModel messageActual = messageRepository.findById(message.getIdMessage()).get();
            messageActual.setMessageText(message.getMessageText());
            messageRepository.save(message);
        }
    }

    public void eliminar(int id) {
        messageRepository.deleteById(id);
    }
}
