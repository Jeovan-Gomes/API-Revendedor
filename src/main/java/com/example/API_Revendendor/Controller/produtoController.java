package com.example.API_Revendendor.Controller;

import com.example.API_Revendendor.DTOs.produtoDTO;
import com.example.API_Revendendor.Service.produtoService;
import com.example.API_Revendendor.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Produto")
public class produtoController {
    @Autowired
    produtoService produtoService;

    public produtoController(produtoService produtoService){
        this.produtoService = produtoService;
    }

    @PostMapping("/")
    public ResponseEntity<Produto> SalvarProduto(@RequestBody produtoDTO dto){
        if(dto == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(produtoService.SalvarProduto(dto));
    }

    @GetMapping("/All")
    public ResponseEntity<List<Produto>> ListarProduto(){
        return ResponseEntity.ok(produtoService.ver_Tudo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable int id){
        if(id == -1){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok(produtoService.verificar_Produto(id));
    }
}
