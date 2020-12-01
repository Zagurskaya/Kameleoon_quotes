package com.gmail.zagurskaya.repository;


import com.gmail.zagurskaya.repository.model.Quotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface QuotesRepository extends JpaRepository<Quotes, Long> {

    @Modifying
    @Query("delete from Quotes q where q.id in :ids")
    void deleteByQuoteIds(@Param("ids") Iterable<Long> ids);
}
