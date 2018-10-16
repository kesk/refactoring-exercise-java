package com.greatersum.rental;

import com.greatersum.rental.model.*;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Map;

public class RentalInfo {

    public String statement(Customer customer) throws FileNotFoundException {
        Map<String, Movie> movies = MovieStorage.loadMovies("resources/movies.yaml");

        Receipt receipt = new Receipt(customer);
        for (MovieRental r : customer.getRentals()) {
            Movie movie = movies.get(r.getMovieId());
            ReceiptItem item = createReceiptItem(movie, r.getDays());

            receipt.addReceiptItem(item);
            receipt.incrementFrequentRenterPoints();

            if (movie.getCode() == MovieCode.NEW && r.getDays() > 2) {
                receipt.incrementFrequentRenterPoints();
            }
        }

        return receipt.toString();
    }

    private static ReceiptItem createReceiptItem(Movie movie, int days) {
        BigDecimal thisAmount = BigDecimal.valueOf(0);
        switch (movie.getCode()) {
            case REGULAR:
                thisAmount = BigDecimal.valueOf(2);
                if (days > 2) {
                    thisAmount = BigDecimal.valueOf((days - 2) * 1.5).add(thisAmount);
                }
                break;

            case NEW:
                thisAmount = BigDecimal.valueOf(days * 3);
                break;

            case CHILDRENS:
                thisAmount = BigDecimal.valueOf(1.5);
                if (days > 3) {
                    thisAmount = BigDecimal.valueOf((days - 3) * 1.5).add(thisAmount);
                }
                break;
        }

        return new ReceiptItem(movie, thisAmount);
    }
}
