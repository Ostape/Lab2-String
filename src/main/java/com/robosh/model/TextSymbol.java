package com.robosh.model;

import java.util.Objects;

public abstract class TextSymbol {

    protected String symbol;

    public TextSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TextSymbol)) return false;
        TextSymbol that = (TextSymbol) o;
        return that.getSymbol().equals(this.getSymbol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol);
    }

    @Override
    public String toString() {
        return symbol;
    }
}
