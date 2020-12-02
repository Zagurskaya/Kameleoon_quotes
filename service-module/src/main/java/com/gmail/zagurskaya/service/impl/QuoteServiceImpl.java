package com.gmail.zagurskaya.service.impl;

import com.gmail.zagurskaya.repository.QuoteRepository;
import com.gmail.zagurskaya.repository.model.Quote;
import com.gmail.zagurskaya.service.QuoteService;
import com.gmail.zagurskaya.service.converter.QuoteConverter;
import com.gmail.zagurskaya.service.model.QuoteDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuoteServiceImpl implements QuoteService {
    private static final Logger logger = LogManager.getLogger(QuoteServiceImpl.class);

    private final QuoteConverter quoteConverter;
    private final QuoteRepository quoteRepository;

    @Autowired
    public QuoteServiceImpl(QuoteConverter quoteConverter, QuoteRepository quoteRepository) {
        this.quoteConverter = quoteConverter;
        this.quoteRepository = quoteRepository;
    }

    @Override
    @Transactional
    public List<QuoteDTO> getQuotes() {
        List<Quote> quotes = quoteRepository.findAll();
        List<QuoteDTO> quoteDTO = quotes.stream()
                .map(quoteConverter::toDTO)
                .collect(Collectors.toList());
        return quoteDTO;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        quoteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public QuoteDTO getQuoteById(Long id) {
        Quote loaded = quoteRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Quote not found with id  " + id));
        QuoteDTO quoteDTO = quoteConverter.toDTO(loaded);
        return quoteDTO;

    }

    @Override
    @Transactional
    public void update(QuoteDTO quoteDTO) {
        Quote quote = quoteConverter.toEntity(quoteDTO);
        quoteRepository.save(quote);
    }

    @Override
    @Transactional
    public void add(QuoteDTO quoteDTO) {
        Quote quote = quoteConverter.toEntity(quoteDTO);
        quote.setDate(LocalDate.now());
        quoteRepository.save(quote);
    }

    @Override
    @Transactional(readOnly = true)
    public List<QuoteDTO> getQuotesByUserId(Long userId) {
        List<Quote> quoteList = quoteRepository.findAllByUserId(userId);
        return quoteList.stream()
                .map(quoteConverter::toDTO)
                .collect(Collectors.toList());
    }
}
