package com.gmail.zagurskaya.service.converter;

import com.gmail.zagurskaya.repository.model.Quotes;
import com.gmail.zagurskaya.service.model.QuotesDTO;

public interface QuotesConverter {

    QuotesDTO toDTO(Quotes quotes);

    Quotes toEntity(QuotesDTO quotesDTO);
}
