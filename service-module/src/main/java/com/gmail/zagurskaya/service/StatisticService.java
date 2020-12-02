package com.gmail.zagurskaya.service;

import com.gmail.zagurskaya.service.model.StatisticDTO;

import java.util.List;

public interface StatisticService {

    List<StatisticDTO> findAllByQuoteId(Long quoteId);

    void addStatisticByQuoteId(int mark, Long quoteId);
}
