package com.example.API_Revendendor.Controller;

import com.example.API_Revendendor.DTOs.perfilDTO;
import com.example.API_Revendendor.Service.perfilService;
import com.example.API_Revendendor.model.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Perfil")
public class perfilController {
    @Autowired
    private perfilService perfilService;

    public perfilController(perfilService perfilService) {
        this.perfilService = perfilService;
    }

    @PostMapping("/")
    public ResponseEntity<?> SalvarPerfil(@RequestBody perfilDTO dto) {
        if(dto == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(perfilService.SalvarPerfil(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> MostrarPerfil(@PathVariable int id) {
        if(id == 0){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(perfilService.MostrarPerfil(id));
    }
}
