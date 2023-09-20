package com.mybinance.demo.utils;

import com.mybinance.demo.model.CurrencyPair;
import lombok.SneakyThrows;

import java.net.URI;

public class StreamUriBuilder {

    private static final String ENDPOINT = "wss://stream.binance.com:9443";
    private static final String RAW = "/ws/%s@trade";
    private static final String RAW_ENDPOINT = ENDPOINT + RAW;


    @SneakyThrows
    public static URI build(CurrencyPair pair) {
        return new URI(String.format(RAW_ENDPOINT, pair.getValue()));
    }
}
