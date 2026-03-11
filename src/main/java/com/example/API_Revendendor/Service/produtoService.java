package com.example.API_Revendendor.Service;

import com.example.API_Revendendor.DTOs.produtoDTO;
import com.example.API_Revendendor.Repository.perfilRepository;
import com.example.API_Revendendor.Repository.produtoRepository;
import com.example.API_Revendendor.model.Perfil;
import com.example.API_Revendendor.model.Produto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class produtoService {

    private produtoRepository produtoRepository;
    private perfilRepository perfilRepository;
    public produtoService(produtoRepository produtoRepository, perfilRepository perfilRepository) {
        this.produtoRepository = produtoRepository;
        this.perfilRepository = perfilRepository;
    }

    @Transactional
    public Produto SalvarProduto(produtoDTO dto){
        Perfil perfil = perfilRepository.findById(dto.Perfil()).orElseThrow(
                () -> new RuntimeException("Id não encontrado!"));
        Produto produto = new Produto(
                null,
                dto.Nome(),
                dto.Descricao(),
                dto.Preco(),
                dto.Lucro(),
                perfil
        );
        produtoRepository.save(produto);
        return produto;
    }

    public List<Produto> ver_Tudo(){
        return produtoRepository.findAll();
    }

    public Produto verificar_Produto(int id){
        Produto produto = produtoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado!")
        );
        return produto;
    }
}
