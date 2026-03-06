package com.example.API_Revendendor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Pedido_Fazer")
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Pedido;
    @Column(name = "Data")
    private Date Data;
    @Column(name = "Valor_Total")
    private Double Valor_Total;
    @Column(name = "Status")
    private Status Status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Cliente")
    private Cliente Cliente;
}
