package com.mybinance.demo.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "event_type")
    String eventType;
    @Column(name = "event_time")
    Long eventTime;
    @Column(name = "symbol")
    String symbol;
    @Column(name = "trade_id", nullable = false)
    Long tradeId;
    @Column(name = "price")
    Double price;
    @Column(name = "quantity")
    Double quantity;
    @Column(name = "buyer_order_id")
    Long buyerOrderId;
    @Column(name = "seller_order_id")
    Long sellerOrderId;
    @Column(name = "trade_time")
    Long tradeTime;
    @Column(name = "is_buyer_market_maker")
    Boolean isBuyerMarketMaker;
    @Column(name = "is_ignore")
    Boolean ignore;
}
