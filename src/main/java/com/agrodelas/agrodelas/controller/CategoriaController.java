package com.agrodelas.agrodelas.controller;

import com.agrodelas.agrodelas.model.Categoria;
import com.agrodelas.agrodelas.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Categoria>> getByTitle(@PathVariable String descricao){
        return ResponseEntity.ok(categoriaRepository.findAllByDescricaoContainingIgnoreCase(descricao));
    }

}
