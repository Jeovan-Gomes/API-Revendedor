package com.example.API_Revendendor.Controller;

import com.example.API_Revendendor.DTOs.pedidoDTO;
import com.example.API_Revendendor.Service.pedidoService;
import com.example.API_Revendendor.model.Pedido;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Pedido")
public class pedidoController {
    private pedidoService pedidoService;

    public pedidoController(pedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    @PostMapping("/")
    public ResponseEntity<Pedido> cadastrarPedido(@RequestBody pedidoDTO dto){
        if(dto == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(pedidoService.CriarPedido(dto));
    }

}
