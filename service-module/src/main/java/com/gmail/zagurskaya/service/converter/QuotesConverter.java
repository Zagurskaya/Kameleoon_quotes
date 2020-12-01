package com.gmail.zagurskaya.service.converter;

import com.gmail.zagurskaya.repository.model.Quotes;
import com.gmail.zagurskaya.service.model.QuoteDTO;

public interface QuotesConverter {

    QuoteDTO toDTO(Quotes quotes);

    Quotes toEntity(QuoteDTO quoteDTO);
}
