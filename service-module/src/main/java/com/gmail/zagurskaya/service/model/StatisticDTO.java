package com.gmail.zagurskaya.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class StatisticDTO {

    private Long id;
    @NotNull
    private QuoteDTO quote;
    @NotNull
    private String mark;
}
