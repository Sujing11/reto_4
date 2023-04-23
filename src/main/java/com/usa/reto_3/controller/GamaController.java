package com.usa.reto_3.controller;

import com.usa.reto_3.model.GamaModel;
import com.usa.reto_3.service.GamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Gama")
public class GamaController {

    @Autowired
    GamaService gamaService;

    @GetMapping("/all")
    public List<GamaModel> obtener(){
        return gamaService.obtener();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody GamaModel gama){
        gamaService.crear(gama);
    }

    @PutMapping("/update")
    public void actualizar(@RequestBody GamaModel gama){
        gamaService.actualizar(gama);}

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")int id){
        gamaService. eliminar(id);
    }

}
