package com.usa.reto_3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    private int idAdmin;
    @Column(length = 45)
    private String email;
    @Column(length = 45)
    private String password;
    @Column(length = 3)
    private byte age;
    @Column(length = 250)
    private String name;
}
