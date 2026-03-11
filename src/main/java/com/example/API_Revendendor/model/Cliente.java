package com.example.API_Revendendor.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Cliente;
    @Column(name = "Nome")
    private String Nome;
    @Column(name = "Celular")
    private String Celular;
    @Column(name = "Data_Cadastro")
    private Date data_Cadastro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Perfil")
    private Perfil Perfil;
}
