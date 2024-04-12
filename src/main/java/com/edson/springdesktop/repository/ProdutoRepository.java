package com.edson.springdesktop.repository;

import com.edson.springdesktop.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByDescricaoContaining(String parteDoNome);
}