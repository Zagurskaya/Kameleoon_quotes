package com.gmail.zagurskaya.repository;


import com.gmail.zagurskaya.repository.model.Quotes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotesRepository extends JpaRepository<Quotes, Long> {

}
