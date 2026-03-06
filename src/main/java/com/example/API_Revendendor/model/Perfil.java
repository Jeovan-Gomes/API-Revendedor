package com.example.API_Revendendor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "perfil")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Perfil;
    @Column(name = "Nome")
    private String Nome;
    @Column(name = "Celular")
    private String Celular;
    @Column(name = "Email")
    private String Email;
    @Column(name = "Senha")
    private String Senha;
    @Column(name = "CPF")
    private String CPF;
}
