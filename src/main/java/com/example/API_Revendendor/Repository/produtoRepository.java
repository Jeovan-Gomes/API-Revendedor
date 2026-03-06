package com.example.API_Revendendor.Repository;

import com.example.API_Revendendor.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface produtoRepository extends JpaRepository<Produto, Integer> {
}
