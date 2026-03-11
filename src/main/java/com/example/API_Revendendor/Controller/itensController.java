package com.example.API_Revendendor.Controller;

import com.example.API_Revendendor.DTOs.itensDTO;
import com.example.API_Revendendor.Repository.itensRepository;
import com.example.API_Revendendor.Service.itensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Itens")
public class itensController {
    @Autowired
    private itensService itensService;

    public itensController(itensService itensService) {
        this.itensService = itensService;
    }

    @PostMapping("/")
    public ResponseEntity<?> salvaItem(@RequestBody itensDTO dto) {
        if(dto == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(itensService.AdicionarItens(dto));
    }

    @GetMapping("/")
    public ResponseEntity<List<?>> ListarItens(){
        return ResponseEntity.ok(itensService.ListarItens());
    }
}
