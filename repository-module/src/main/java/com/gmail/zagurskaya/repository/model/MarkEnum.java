package com.gmail.zagurskaya.repository.model;

public enum MarkEnum {
    CONS(0),
    PROS(1);

    private int value;

    MarkEnum(int value) {
        this.value = value;
    }

    public static MarkEnum getValue(int x) {
        if (1 == x) {
            return PROS;
        } else if (0 == x) {
            return CONS;
        } else throw new IllegalArgumentException();
    }
}
