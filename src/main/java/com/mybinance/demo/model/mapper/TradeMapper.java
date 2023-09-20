package com.mybinance.demo.model.mapper;

import com.mybinance.demo.model.entity.Trade;
import com.mybinance.demo.model.TradeInfo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface TradeMapper {
    Trade sourceToDestination(TradeInfo source);

    List<Trade> sourceToDestination(List<TradeInfo> source);
}
