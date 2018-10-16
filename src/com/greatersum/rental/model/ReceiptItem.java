package com.greatersum.rental.model;

import com.greatersum.rental.model.Movie;

import java.math.BigDecimal;

public class ReceiptItem {
    private Movie movie;
    private BigDecimal amount;

    public ReceiptItem(Movie movie, BigDecimal amount) {
        this.movie = movie;
        this.amount = amount;
    }

    public Movie getMovie() {
        return movie;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
