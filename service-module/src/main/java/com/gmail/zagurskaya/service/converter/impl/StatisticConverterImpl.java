package com.gmail.zagurskaya.service.converter.impl;

import com.gmail.zagurskaya.repository.QuoteRepository;
import com.gmail.zagurskaya.repository.StatisticRepository;
import com.gmail.zagurskaya.repository.model.MarkEnum;
import com.gmail.zagurskaya.repository.model.RoleEnum;
import com.gmail.zagurskaya.repository.model.Statistic;
import com.gmail.zagurskaya.service.converter.QuoteConverter;
import com.gmail.zagurskaya.service.converter.StatisticConverter;
import com.gmail.zagurskaya.service.model.StatisticDTO;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class StatisticConverterImpl implements StatisticConverter {

    private final StatisticRepository statisticRepository;
    private final QuoteConverter quoteConverter;
    private final QuoteRepository quoteRepository;

    public StatisticConverterImpl(StatisticRepository statisticRepository, QuoteConverter quoteConverter, QuoteRepository quoteRepository) {
        this.statisticRepository = statisticRepository;
        this.quoteConverter = quoteConverter;
        this.quoteRepository = quoteRepository;
    }

    @Override
    public StatisticDTO toDTO(Statistic statistic) {
        StatisticDTO statisticDTO = new StatisticDTO();
        statisticDTO.setId(statistic.getId());
        statisticDTO.setQuote(quoteConverter.toDTO(statistic.getQuote()));
        statisticDTO.setMark(statistic.getMark().toString());
        return statisticDTO;
    }

    @Override
    public Statistic toEntity(StatisticDTO statisticDTO) {
        Statistic statistic = new Statistic();
        statistic.setId(statisticDTO.getId());
        statistic.setQuote(quoteRepository.findById(statisticDTO.getQuote().getId())
                .orElseThrow(() -> new EntityNotFoundException("Quote not found with id " + statisticDTO.getQuote().getId())));
        statistic.setMark(MarkEnum.valueOf(statisticDTO.getMark()));
        return statistic;
    }
}
