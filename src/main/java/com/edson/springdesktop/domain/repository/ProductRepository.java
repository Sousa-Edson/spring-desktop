package com.edson.springdesktop.domain.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edson.springdesktop.domain.entity.produto.Produto;

@Repository
public interface ProductRepository extends JpaRepository<Produto, Long> {
  List<Produto> findByDescriptionContaining(String description);
}
