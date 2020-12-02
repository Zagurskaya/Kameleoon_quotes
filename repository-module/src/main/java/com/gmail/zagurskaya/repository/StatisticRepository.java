package com.gmail.zagurskaya.repository;

import com.gmail.zagurskaya.repository.model.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatisticRepository extends JpaRepository<Statistic, Long> {

    List<Statistic> findAllByQuoteId(Long quoteId);
}
