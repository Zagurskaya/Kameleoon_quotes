package com.gmail.zagurskaya.service.impl;

import com.gmail.zagurskaya.repository.QuotesRepository;
import com.gmail.zagurskaya.repository.model.Quotes;
import com.gmail.zagurskaya.service.QuotesService;
import com.gmail.zagurskaya.service.converter.QuotesConverter;
import com.gmail.zagurskaya.service.model.QuotesDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class QuotesServiceImpl implements QuotesService {
    private static final Logger logger = LogManager.getLogger(QuotesServiceImpl.class);

    private final QuotesConverter quotesConverter;
    private final QuotesRepository quotesRepository;

    @Autowired
    public QuotesServiceImpl(QuotesConverter quotesConverter, QuotesRepository quotesRepository) {
        this.quotesConverter = quotesConverter;
        this.quotesRepository = quotesRepository;
    }

    @Override
    @Transactional
    public List<QuotesDTO> getQuotes() {
        List<Quotes> quotess = quotesRepository.findAll(0, Integer.MAX_VALUE);
        List<QuotesDTO> quotessDTO = quotess.stream()
                .map(quotesConverter::toDTO)
                .collect(Collectors.toList());
        return quotessDTO;
    }

    @Override
    @Transactional
    public void delete(Long id) {

        quotesRepository.remove(quotesRepository.findById(id));
    }

    @Override
    public void deleteQuotesList(List<Long> ids) {
        ids.stream().forEach(id -> {
            delete(id);
            logger.info("deleted review with id = " + id);
        });
    }
}
