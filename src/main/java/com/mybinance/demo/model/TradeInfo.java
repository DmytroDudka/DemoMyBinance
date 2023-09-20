package com.mybinance.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@ToString
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TradeInfo {

    @JsonProperty("e")
    String eventType;
    @JsonProperty("E")
    Long eventTime;
    @JsonProperty("s")
    String symbol;
    @JsonProperty("t")
    Long tradeId;
    @JsonProperty("p")
    Double price;
    @JsonProperty("q")
    Double quantity;
    @JsonProperty("b")
    Long buyerOrderId;
    @JsonProperty("a")
    Long sellerOrderId;
    @JsonProperty("T")
    Long tradeTime;
    @JsonProperty("m")
    Boolean isBuyerMarketMaker;
    @JsonProperty("M")
    Boolean ignore;
}
