package com.edson.springdesktop.api.repository;



import com.edson.springdesktop.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByDescricaoContaining(String parteDoNome);
}