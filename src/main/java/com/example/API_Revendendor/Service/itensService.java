package com.example.API_Revendendor.Service;

import com.example.API_Revendendor.DTOs.itensDTO;
import com.example.API_Revendendor.Repository.itensRepository;
import com.example.API_Revendendor.Repository.pedidoRepository;
import com.example.API_Revendendor.Repository.produtoRepository;
import com.example.API_Revendendor.model.Itens;
import com.example.API_Revendendor.model.Pedido;
import com.example.API_Revendendor.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class itensService {
    @Autowired
    private itensRepository itensRepository;
    @Autowired
    private pedidoRepository pedidoRepository;
    @Autowired
    private produtoRepository produtoRepository;

    public Itens AdicionarItens(itensDTO dto) {
        Produto produto = produtoRepository.findById(dto.produto()).orElseThrow(
                () -> new RuntimeException("Id do produto não encontrado!")
        );

        Pedido pedido = pedidoRepository.findById(dto.pedido()).orElseThrow(
                () -> new RuntimeException("Id do pedido não encontrado!")
        );

        Itens item = new Itens(
                null,
                pedido,
                produto,
                dto.Quantidade(),
                dto.Preco_Unitario()
        );
        itensRepository.save(item);
        return item;
    }

    public List<Itens> ListarItens(){
        return itensRepository.findAll();
    }
}
