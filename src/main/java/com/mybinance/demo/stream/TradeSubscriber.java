package com.mybinance.demo.stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybinance.demo.client.WebsocketClientEndpoint;
import com.mybinance.demo.model.CurrencyPair;
import com.mybinance.demo.model.TradeInfo;
import com.mybinance.demo.utils.StreamUriBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.concurrent.BlockingQueue;

/***
 *
 * {@link com.mybinance.demo.stream.TradeSubscriber} is a RAW subscriber for certain stream (certain currency).
 * A Binance API will disconnect after 24 hours. We can implement scheduler for this purposes
 *
 */
@Slf4j
@Component
public class TradeSubscriber {
    private final BlockingQueue<TradeInfo> tradeQueue;

    public TradeSubscriber(BlockingQueue<TradeInfo> tradeQueue) {
        this.tradeQueue = tradeQueue;
    }

    public void startStream() {
        startStream(CurrencyPair.BTC_USDT);
        startStream(CurrencyPair.ETH_USDT);
    }

    private void startStream(CurrencyPair pair) {
            URI uri = StreamUriBuilder.build(pair);
            final WebsocketClientEndpoint clientEndPoint = new WebsocketClientEndpoint();

            ObjectMapper objectMapper = new ObjectMapper();
            clientEndPoint.addMessageHandler(payload -> {
                try {
                    TradeInfo trade = objectMapper.readValue(payload, TradeInfo.class);
                    tradeQueue.put(trade);
                    log.info("Stream:" + trade);
                } catch (JsonProcessingException | InterruptedException e) {
                    log.warn("Exception in stream reading");
                }
            });

            clientEndPoint.connect(uri);
    }
}
