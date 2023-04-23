package com.usa.reto_3.service;

import com.usa.reto_3.model.CarModel;
import com.usa.reto_3.model.ClientModel;
import com.usa.reto_3.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<CarModel> obtener(){
        return carRepository.findAll();
    }

    public void crear(CarModel car){
        if(!carRepository.existsById(car.getIdCar())){
            carRepository.save(car);
        }
    }

    public void actualizar(CarModel car){
        if (carRepository.existsById(car.getIdCar())) {
            CarModel carActual = carRepository.findById(car.getIdCar()).get();
            carActual.setName(car.getName());
            carActual.setBrand(car.getBrand());
            carActual.setYear(car.getYear());
            carActual.setDescription(car.getDescription());
            carRepository.save(car);
        }
    }

    public void eliminar(int id) {
        carRepository.deleteById(id);
    }

}
