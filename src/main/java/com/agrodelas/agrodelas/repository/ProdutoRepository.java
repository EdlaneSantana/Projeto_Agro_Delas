package com.agrodelas.agrodelas.repository;

import com.agrodelas.agrodelas.controller.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    public List<Produto> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

    public List<Produto> findAllByValor(@Param("valor") double valor);

    public List<Produto> findAllByPeso(@Param("peso") double peso);
    public List<Produto> findAllByVolume(@Param("volume") double volume);

    public List<Produto> findAllByQuantidade(@Param("quantidade") int quantidade);
}
