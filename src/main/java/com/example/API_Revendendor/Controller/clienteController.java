package com.example.API_Revendendor.Controller;

import com.example.API_Revendendor.DTOs.clienteDTO;
import com.example.API_Revendendor.Service.clienteService;
import com.example.API_Revendendor.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Cliente")
public class clienteController {
    @Autowired
    private clienteService clienteService;

    public clienteController(clienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/")
    public ResponseEntity<Cliente> salvaCliente(@RequestBody clienteDTO dto) {
        if(dto == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(clienteService.SalvarCliente(dto));
    }

    @GetMapping("/")
    public ResponseEntity<List<Cliente>> ListarClientes(){
        return ResponseEntity.ok(clienteService.ListarCliente());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> ConsultarCliente(@PathVariable("id") Integer id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(clienteService.ListarClientePorId(id));
    }
}
