package com.edson.springdesktop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edson.springdesktop.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long>{

}
