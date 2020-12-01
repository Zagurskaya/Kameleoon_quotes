package com.gmail.zagurskaya.service.impl;

import com.gmail.zagurskaya.repository.QuotesRepository;
import com.gmail.zagurskaya.repository.model.Quotes;
import com.gmail.zagurskaya.service.QuotesService;
import com.gmail.zagurskaya.service.converter.QuotesConverter;
import com.gmail.zagurskaya.service.model.QuoteDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
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
    public List<QuoteDTO> getQuotes() {
        List<Quotes> quotes = quotesRepository.findAll();
        List<QuoteDTO> quoteDTO = quotes.stream()
                .map(quotesConverter::toDTO)
                .collect(Collectors.toList());
        return quoteDTO;
    }

    @Override
    @Transactional
    public void deleteQuotesList(List<Long> ids) {
        quotesRepository.deleteByQuoteIds(ids);
    }

    @Override
    @Transactional(readOnly = true)
    public QuoteDTO getQuoteById(Long id) {
        Quotes loaded = quotesRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Quote not found with id  " + id));
        QuoteDTO quoteDTO = quotesConverter.toDTO(loaded);
        return quoteDTO;

    }

    @Override
    @Transactional
    public void update(QuoteDTO quoteDTO) {
        Quotes quote = quotesConverter.toEntity(quoteDTO);
        quotesRepository.save(quote);
    }
}
