package com.edson.springdesktop.domain.repository;

import com.edson.springdesktop.domain.entity.product.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByDescriptionContaining(String description);
}
