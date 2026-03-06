package com.example.API_Revendendor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Item_Pedido")
@AllArgsConstructor
@NoArgsConstructor
public class Itens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Pedido")
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Produto")
    private Produto produto;

    @Column(name = "Quantidade")
    private int Quantidade;

    @Column(name = "Preco_Unitario")
    private Double Preco_Unitario;
}
