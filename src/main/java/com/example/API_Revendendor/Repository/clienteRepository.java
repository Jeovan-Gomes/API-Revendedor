package com.example.API_Revendendor.Repository;

import com.example.API_Revendendor.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface clienteRepository extends JpaRepository<Cliente, Integer> {
}
