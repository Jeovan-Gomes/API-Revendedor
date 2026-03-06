package com.example.API_Revendendor.Service;

import com.example.API_Revendendor.DTOs.perfilDTO;
import com.example.API_Revendendor.Repository.perfilRepository;
import com.example.API_Revendendor.model.Perfil;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class perfilService {
    @Autowired
    private perfilRepository pRepository;

    @Transactional

    public Perfil SalvarPerfil(perfilDTO dto){
        Perfil perfil = new Perfil(0 ,dto.Nome(),dto.Celular(), dto.Email(), dto.Senha(), dto.CPF());
        pRepository.save(perfil);
        return perfil;
    }

    public Perfil MostrarPerfil(int id){
        return pRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
