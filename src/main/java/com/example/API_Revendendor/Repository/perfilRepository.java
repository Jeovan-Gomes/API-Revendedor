package com.example.API_Revendendor.Repository;

import com.example.API_Revendendor.DTOs.perfilDTO;
import com.example.API_Revendendor.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface perfilRepository extends JpaRepository<Perfil, Integer> {
}
