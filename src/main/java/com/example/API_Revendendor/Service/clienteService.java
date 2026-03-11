package com.example.API_Revendendor.Service;

import com.example.API_Revendendor.DTOs.clienteDTO;
import com.example.API_Revendendor.Repository.clienteRepository;
import com.example.API_Revendendor.Repository.perfilRepository;
import com.example.API_Revendendor.model.Cliente;
import com.example.API_Revendendor.model.Perfil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class clienteService {
    @Autowired
    private perfilRepository perfilRepository;

    @Autowired
    private clienteRepository clienteRepository;

    public clienteService(perfilRepository perfilRepository, clienteRepository clienteRepository) {
        this.perfilRepository = perfilRepository;
        this.clienteRepository = clienteRepository;
    }

    public Cliente SalvarCliente(clienteDTO dto){
        Perfil perfil = perfilRepository.findById(dto.Perfil()).orElseThrow(
                () -> new RuntimeException("id não encontrado"));

        Cliente cliente = new Cliente(
                null,
                dto.Nome(),
                dto.Celular(),
                dto.data_Cadastro(),
                perfil
        );

        return clienteRepository.save(cliente);
    }

    public List<Cliente> ListarCliente(){
        return clienteRepository.findAll();
    }

    public Cliente ListarClientePorId(Integer id){
        Cliente c = clienteRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado!")
        );

        return c;
    }
}
