package com.gmail.zagurskaya.service;

import com.gmail.zagurskaya.service.model.QuoteDTO;

import java.util.List;

public interface QuotesService {

    List<QuoteDTO> getQuotes();

    void deleteQuotesList(List<Long> ids);

    QuoteDTO getQuoteById(Long id);

    void update(QuoteDTO quoteDTO);
}
