package com.example.API_Revendendor.Service;

import com.example.API_Revendendor.DTOs.pedidoDTO;
import com.example.API_Revendendor.Repository.clienteRepository;
import com.example.API_Revendendor.Repository.pedidoRepository;
import com.example.API_Revendendor.model.Cliente;
import com.example.API_Revendendor.model.Pedido;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pedidoService {
    @Autowired
    private pedidoRepository pedidoRepository;
    @Autowired
    private clienteRepository clienteRepository;

    public pedidoService(pedidoRepository pedidoRepository, clienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Pedido CriarPedido(pedidoDTO dto){
        Cliente cliente = clienteRepository.findById(dto.Cliente()).orElseThrow(
                () -> new RuntimeException("Id não encontrado!")
        );
        Pedido pedido = new Pedido(
                null,
                dto.Data(),
                dto.Valor_Total(),
                dto.Status(),
                cliente
        );

        pedidoRepository.save(pedido);
        return pedido;
    }

    public List<Pedido> MostrarPedido(Integer id){
        List<Pedido> pedidos = pedidoRepository.findById(id).stream().toList();
        return pedidos;
    }
}
