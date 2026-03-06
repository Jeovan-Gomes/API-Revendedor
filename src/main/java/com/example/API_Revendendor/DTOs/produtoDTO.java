package com.example.API_Revendendor.DTOs;

import com.example.API_Revendendor.model.Perfil;

public record produtoDTO(String nome, String descricao, Double preco, Double lucro, Perfil id_P) {
}
