package com.usa.reto_3.controller;

import com.usa.reto_3.model.ReservationModel;
import com.usa.reto_3.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/all")
    public List<ReservationModel> obtener(){
        return reservationService.obtener();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody ReservationModel reservation){
        reservationService.crear(reservation);
    }

    @PutMapping("/update")
    public void actualizar(@RequestBody ReservationModel reservation){
        reservationService. actualizar(reservation);}

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id")int id){
        reservationService. eliminar(id);
    }

}
