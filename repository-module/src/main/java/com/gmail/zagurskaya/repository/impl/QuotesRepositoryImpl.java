package com.gmail.zagurskaya.repository.impl;

import com.gmail.zagurskaya.repository.QuotesRepository;
import com.gmail.zagurskaya.repository.model.Quotes;
import org.springframework.stereotype.Repository;

@Repository
public class QuotesRepositoryImpl extends GenericRepositoryImpl<Long, Quotes> implements QuotesRepository {

}
