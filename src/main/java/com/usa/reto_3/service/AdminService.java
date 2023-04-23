package com.usa.reto_3.service;

import com.usa.reto_3.model.AdminModel;
import com.usa.reto_3.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public List<AdminModel> obtener(){
        return adminRepository.findAll();
    }

    public String crear(AdminModel admin){
        if (!adminRepository.existsById(admin.getIdAdmin())){
            return "El usuario ya existe";
        }else{
            adminRepository.save(admin);
            return "La usuario se creo";
        }
    }

    public void actualizar(AdminModel admin){
        if (adminRepository.existsById(admin.getIdAdmin())) {
            adminRepository.save(admin);
        }
    }

    public void eliminar(int id) {
        adminRepository.deleteById(id);
    }
}
