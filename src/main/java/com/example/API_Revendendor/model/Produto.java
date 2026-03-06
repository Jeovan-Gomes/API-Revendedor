package com.example.API_Revendendor.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Pronto_Entrega")
@AllArgsConstructor
@NoArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Produto;
    @Column(name = "Nome")
    private String Nome;
    @Column(name = "Descricao")
    private String Descricao;
    @Column(name = "Preco")
    private Double Preco;
    @Column(name = "Lucro")
    private Double Lucro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Perfil")
    private Perfil id_Perfil;
}
