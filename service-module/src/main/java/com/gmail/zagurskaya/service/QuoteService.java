package com.gmail.zagurskaya.service;

import com.gmail.zagurskaya.service.model.QuoteDTO;

import java.util.List;

public interface QuoteService {

    List<QuoteDTO> getQuotes();

    QuoteDTO getQuoteById(Long id);

    void update(QuoteDTO quoteDTO);

    void add(QuoteDTO quoteDTO);

    void delete(Long id);

    List<QuoteDTO> getQuotesByUserId(Long userId);

    List<QuoteDTO> findTopQuotes(int topLimit);

}
