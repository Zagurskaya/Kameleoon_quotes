package com.gmail.zagurskaya.service.converter.impl;

import com.gmail.zagurskaya.repository.UserRepository;
import com.gmail.zagurskaya.repository.model.Quotes;
import com.gmail.zagurskaya.service.converter.QuotesConverter;
import com.gmail.zagurskaya.service.converter.UserConverter;
import com.gmail.zagurskaya.service.model.QuotesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuotesConverterImpl implements QuotesConverter {

    private final UserConverter userConverter;
    private final UserRepository userRepository;

    @Autowired
    public QuotesConverterImpl(UserConverter userConverter, UserRepository userRepository) {
        this.userConverter = userConverter;
        this.userRepository = userRepository;
    }

    @Override
    public QuotesDTO toDTO(Quotes quotes) {
        QuotesDTO quotesDTO = new QuotesDTO();
        quotesDTO.setId(quotes.getId());
        quotesDTO.setDate(quotes.getDate());
        quotesDTO.setUser(userConverter.toDTO(quotes.getUser()));
        quotesDTO.setDescription(quotes.getDescription());
        return quotesDTO;
    }

    @Override
    public Quotes toEntity(QuotesDTO quotesDTO) {
        Quotes quotes = new Quotes();
        quotes.setId(quotesDTO.getId());
        quotes.setDate(quotesDTO.getDate());
        quotes.setUser(userRepository.findById(quotesDTO.getUser().getId()));
        quotes.setDescription(quotesDTO.getDescription());
        return quotes;
    }
}
