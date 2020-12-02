package com.gmail.zagurskaya.service.converter;

import com.gmail.zagurskaya.repository.model.Statistic;
import com.gmail.zagurskaya.service.model.StatisticDTO;

public interface StatisticConverter {

    StatisticDTO toDTO(Statistic statistic);

    Statistic toEntity(StatisticDTO statisticDTO);

}
