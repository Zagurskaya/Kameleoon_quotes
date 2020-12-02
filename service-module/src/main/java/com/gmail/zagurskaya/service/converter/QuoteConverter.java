package com.gmail.zagurskaya.service.converter;

import com.gmail.zagurskaya.repository.model.Quote;
import com.gmail.zagurskaya.service.model.QuoteDTO;

public interface QuoteConverter {

    QuoteDTO toDTO(Quote quote);

    Quote toEntity(QuoteDTO quoteDTO);
}
