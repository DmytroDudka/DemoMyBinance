package com.mybinance.demo.task;

import com.mybinance.demo.model.TradeInfo;
import com.mybinance.demo.model.entity.Trade;
import com.mybinance.demo.model.mapper.TradeMapper;
import com.mybinance.demo.repository.TradeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/***
 *
 *  {@link com.mybinance.demo.task.TradeSaver} is a class responsible for saving data to database.
 * In the future, we can use different queues for respective streams.
 *
 */
@Slf4j
@Component
public class TradeSaver {

    private final BlockingQueue<TradeInfo> tradeQueue;
    private final TradeRepository tradeRepository;
    private final TradeMapper mapper;

    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    int batchSize;

    public TradeSaver(BlockingQueue<TradeInfo> tradeQueue, TradeRepository tradeRepository, TradeMapper mapper) {
        this.tradeQueue = tradeQueue;
        this.tradeRepository = tradeRepository;
        this.mapper = mapper;
    }

    @Scheduled(fixedDelayString = "${scheduler.trade.fixed_delay.milliseconds}")
    public void scheduleBatchInsertTask() {
        log.info("Saver task started...");
        int i = 0;
        List<Trade> trades = new ArrayList<>();
        try {
            while (i < batchSize) {
                i++;
                TradeInfo tradeInfo = tradeQueue.take();
                trades.add(mapper.sourceToDestination(tradeInfo));
                log.info("Saving:" + tradeInfo);
            }
            tradeRepository.saveAll(trades);
        } catch (InterruptedException e) {
            log.warn("Wrong saving to DB:" + e);
        }
    }
}
