package com.gmail.zagurskaya.service.converter.impl;

import com.gmail.zagurskaya.repository.UserRepository;
import com.gmail.zagurskaya.repository.model.Quote;
import com.gmail.zagurskaya.service.converter.QuoteConverter;
import com.gmail.zagurskaya.service.converter.UserConverter;
import com.gmail.zagurskaya.service.model.QuoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class QuoteConverterImpl implements QuoteConverter {

    private final UserConverter userConverter;
    private final UserRepository userRepository;

    @Autowired
    public QuoteConverterImpl(UserConverter userConverter, UserRepository userRepository) {
        this.userConverter = userConverter;
        this.userRepository = userRepository;
    }

    @Override
    public QuoteDTO toDTO(Quote quote) {
        QuoteDTO quoteDTO = new QuoteDTO();
        quoteDTO.setId(quote.getId());
        quoteDTO.setDate(quote.getDate());
        quoteDTO.setUser(userConverter.toDTO(quote.getUser()));
        quoteDTO.setDescription(quote.getDescription());
        return quoteDTO;
    }

    @Override
    public Quote toEntity(QuoteDTO quoteDTO) {
        Quote quote = new Quote();
        quote.setId(quoteDTO.getId());
        quote.setDate(quoteDTO.getDate());
        quote.setUser(userRepository.findById(quoteDTO.getUser().getId())
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id " + quoteDTO.getUser().getId())));
        quote.setDescription(quoteDTO.getDescription());
        return quote;
    }
}
