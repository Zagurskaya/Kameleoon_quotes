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

    @Query(
            value = "SELECT quotes.id,quotes.date, quotes.user_id, quotes.description FROM \n" +
                    "(SELECT statistics.quote_id as quoteid, round(AVG(statistics.mark),2) as rating, COUNT(statistics.quote_id) as countid \n" +
                    " FROM statistics \n" +
                    " GROUP BY statistics.quote_id \n" +
                    " ORDER BY rating DESC, countid ASC) statistic \n" +
                    " LEFT JOIN quotes \n" +
                    " ON statistic.quoteid = quotes.id \n" +
                    "LIMIT ?1",
            nativeQuery = true)
    List<Quote> TopQuotes(int i);
}
