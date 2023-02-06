package com.agrodelas.agrodelas.controller;

import com.agrodelas.agrodelas.model.Produto;
import com.agrodelas.agrodelas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    //retorna todos os produtos
    @GetMapping
    public ResponseEntity<List<Produto>> getAll() {
        return ResponseEntity.ok(produtoRepository.findAll());
    }

    //buscar por nome
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome) {
        return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
    }


    //buscar por valor
    @GetMapping("/valor/{valor}")
    public ResponseEntity<List<Produto>> getByValor(@PathVariable double valor) {
        return ResponseEntity.ok(produtoRepository.findAllByValor(valor));
    }

    //buscar por peso
    @GetMapping("/peso/{peso}")
    public ResponseEntity<List<Produto>> getByPeso(@PathVariable double peso) {
        return ResponseEntity.ok(produtoRepository.findAllByPeso(peso));
    }

    //buscar por volume
    @GetMapping("/volume/{volume}")
    public ResponseEntity<List<Produto>> getByVolume(@PathVariable double volume) {
        return ResponseEntity.ok(produtoRepository.findAllByVolume());
    }

    //buscar por valores menores que (peso, volume, valor)
    //buscar por valores maiores que (peso, volume, valor)

    //buscar por quantidade
    //retorna produto por id
    //post
    //put
    //delete
}
