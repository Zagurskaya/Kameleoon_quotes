package com.gmail.zagurskaya.repository;


import com.gmail.zagurskaya.repository.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuoteRepository extends JpaRepository<Quote, Long> {

    List<Quote> findAllByUserId(Long userId);

    @Modifying
    @Query("delete from Quote q where q.id = :id")
    void deleteById(@Param("id") Long id);
}
