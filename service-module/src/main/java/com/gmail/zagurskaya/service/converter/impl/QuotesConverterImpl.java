package com.gmail.zagurskaya.service.converter.impl;

import com.gmail.zagurskaya.repository.UserRepository;
import com.gmail.zagurskaya.repository.model.Quotes;
import com.gmail.zagurskaya.service.converter.QuotesConverter;
import com.gmail.zagurskaya.service.converter.UserConverter;
import com.gmail.zagurskaya.service.model.QuoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

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
    public QuoteDTO toDTO(Quotes quotes) {
        QuoteDTO quoteDTO = new QuoteDTO();
        quoteDTO.setId(quotes.getId());
        quoteDTO.setDate(quotes.getDate());
        quoteDTO.setUser(userConverter.toDTO(quotes.getUser()));
        quoteDTO.setDescription(quotes.getDescription());
        return quoteDTO;
    }

    @Override
    public Quotes toEntity(QuoteDTO quoteDTO) {
        Quotes quotes = new Quotes();
        quotes.setId(quoteDTO.getId());
        quotes.setDate(quoteDTO.getDate());
        quotes.setUser(userRepository.findById(quoteDTO.getUser().getId())
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id " + quoteDTO.getUser().getId())));
        quotes.setDescription(quoteDTO.getDescription());
        return quotes;
    }
}
