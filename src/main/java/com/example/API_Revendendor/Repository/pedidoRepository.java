package com.example.API_Revendendor.Repository;

import com.example.API_Revendendor.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pedidoRepository extends JpaRepository<Pedido, Integer> {
}
