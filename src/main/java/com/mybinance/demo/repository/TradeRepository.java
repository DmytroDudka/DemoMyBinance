package com.mybinance.demo.repository;

import com.mybinance.demo.model.entity.Trade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends CrudRepository<Trade, Integer> {
}
