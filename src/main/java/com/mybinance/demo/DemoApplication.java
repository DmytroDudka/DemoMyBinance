package com.mybinance.demo;

import com.mybinance.demo.model.TradeInfo;
import com.mybinance.demo.stream.TradeSubscriber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public BlockingQueue<TradeInfo> createTradeBlockingQueue() {
        return new LinkedBlockingQueue<>();
    }

    @Bean
    ApplicationListener<ApplicationReadyEvent> onApplicationReadyEventListener(TradeSubscriber tradeSubscriber) {
        return (evt) -> tradeSubscriber.startStream();
    }
}
