package com.gmail.zagurskaya.service;

import com.gmail.zagurskaya.service.model.QuotesDTO;

import java.util.List;

public interface QuotesService {

    List<QuotesDTO> getQuotes();

    void delete(Long id);

    void deleteQuotesList(List<Long> ids);
}
