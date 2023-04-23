package com.usa.reto_3.controller;

import com.usa.reto_3.model.AdminModel;
import com.usa.reto_3.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/all")
    public List<AdminModel> obtener(){
        return adminService.obtener();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void crear(@RequestBody AdminModel admin){
        adminService.crear(admin);
    }

    @PutMapping("/update")
    public void actualizar(@RequestBody AdminModel admin){
        adminService.actualizar(admin);}

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable int id){
        adminService. eliminar(id);
    }


}
