package com.example.dbtradeapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dbtradeapp.entities.TradeBook;
import com.example.dbtradeapp.entities.composite.TradeBookId;

@Repository
public interface TradeBookRepo extends JpaRepository<TradeBook, TradeBookId> {

}
