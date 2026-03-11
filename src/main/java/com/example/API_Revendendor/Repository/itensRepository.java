package com.example.API_Revendendor.Repository;

import com.example.API_Revendendor.model.Itens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface itensRepository extends JpaRepository<Itens, Integer> {
}
