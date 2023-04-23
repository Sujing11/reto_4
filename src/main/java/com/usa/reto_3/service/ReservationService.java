package com.usa.reto_3.service;

import com.usa.reto_3.model.ReservationModel;
import com.usa.reto_3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<ReservationModel> obtener(){
        return reservationRepository.findAll();
    }

    public void crear(ReservationModel reservation) {
        if (!reservationRepository.existsById(reservation.getIdReservation())) {
            reservationRepository.save(reservation);
        }
    }
    public void actualizar(ReservationModel reservation){
        if (reservationRepository.existsById(reservation.getIdReservation())) {
            ReservationModel message = reservationRepository.findById(reservation.getIdReservation()).get();
            message.setStartDate(reservation.getStartDate());
            message.setDevolutionDate(reservation.getDevolutionDate());
            message.setStatus("upgated");
            reservationRepository.save(reservation);
        }
    }
    public void eliminar(int id) {
        reservationRepository.deleteById(id);
    }
}
