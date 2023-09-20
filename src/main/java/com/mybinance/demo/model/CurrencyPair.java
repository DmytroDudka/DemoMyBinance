package com.mybinance.demo.model;

public enum CurrencyPair {
    BTC_USDT("btcusdt"),
    ETH_USDT("ethusdt");

    private final String value;

    CurrencyPair(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
