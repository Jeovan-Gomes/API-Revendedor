package com.example.API_Revendendor.DTOs;

import com.example.API_Revendendor.model.Cliente;
import com.example.API_Revendendor.model.Status;

import java.util.Date;

public record pedidoDTO(Date Data, Double Valor_Total, Status Status, Integer Cliente) {
}
