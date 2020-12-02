package com.gmail.zagurskaya.service.impl;

import com.gmail.zagurskaya.repository.QuoteRepository;
import com.gmail.zagurskaya.repository.StatisticRepository;
import com.gmail.zagurskaya.repository.model.MarkEnum;
import com.gmail.zagurskaya.repository.model.Quote;
import com.gmail.zagurskaya.repository.model.Statistic;
import com.gmail.zagurskaya.service.StatisticService;
import com.gmail.zagurskaya.service.converter.StatisticConverter;
import com.gmail.zagurskaya.service.model.StatisticDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StatisticServiceImpl implements StatisticService {

    private final StatisticConverter statisticConverter;
    private final StatisticRepository statisticRepository;
    private final QuoteRepository quoteRepository;

    @Autowired
    public StatisticServiceImpl(StatisticConverter statisticConverter, StatisticRepository statisticRepository, QuoteRepository quoteRepository) {
        this.statisticConverter = statisticConverter;
        this.statisticRepository = statisticRepository;
        this.quoteRepository = quoteRepository;
    }

    @Override
    @Transactional
    public void addStatisticByQuoteId(int mark, Long quoteId) {
        Quote quote = quoteRepository.findById(quoteId)
                .orElseThrow(() -> new EntityNotFoundException("Quote not found with id " + quoteId));
        Statistic newStatistic = new Statistic();
        newStatistic.setQuote(quote);
        newStatistic.setMark(MarkEnum.getValue(mark));
        statisticRepository.save(newStatistic);
    }
}
