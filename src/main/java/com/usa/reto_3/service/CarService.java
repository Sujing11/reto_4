package com.usa.reto_3.service;

import com.usa.reto_3.model.CarModel;
import com.usa.reto_3.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<CarModel> obtener(){
        return carRepository.findAll();
    }

    public Optional<CarModel> obtenerPorId(int id) {
        return carRepository.findById(id);
    }

    public void crear(CarModel car){
        if(!carRepository.existsById(car.getIdCar())){carRepository.save(car);}}

    public CarModel actualizar(CarModel car) {
        if( carRepository.existsById(car.getIdCar())) {
            Optional<CarModel> e= carRepository.findById(car.getIdCar());
            if(e.isPresent()) {
                if(car.getName()!=null) {
                    e.get().setName(car.getName());
                }
                if(car.getBrand()!=null) {
                    e.get().setBrand(car.getBrand());
                }
                if(Long.valueOf(car.getYear()) == null) {
                    e.get().setYear(car.getYear());
                }
                carRepository. save(e.get());
                return e.get();
            }else{
                return car;
            }
        }else{
            return car;
        }
    }

    public void eliminar(int id) {
        carRepository.deleteById(id);
    }

}
