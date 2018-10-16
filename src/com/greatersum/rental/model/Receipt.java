package com.greatersum.rental.model;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Receipt {
    private Customer customer;
    private int frequentRenterPoints;
    private BigDecimal amount;
    private ArrayList<ReceiptItem> rentedMovies;

    public Receipt(Customer customer) {
        this.customer = customer;
        this.frequentRenterPoints = 0;
        this.amount = BigDecimal.valueOf(0);
        this.rentedMovies = new ArrayList<>();
    }

    public void incrementFrequentRenterPoints() {
        frequentRenterPoints++;
    }

    public void addReceiptItem(ReceiptItem item) {
        rentedMovies.add(item);
    }

    @Override
    public String toString() {
        BigDecimal totalAmount = BigDecimal.valueOf(0);
        String result = "Rental Record for " + customer.getName() + "\n";

        for (ReceiptItem ri : rentedMovies) {
            result += "\t" + ri.getMovie().getTitle() + "\t" + ri.getAmount() + "\n";
            totalAmount = totalAmount.add(ri.getAmount());
        }
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points\n";
        return result;
    }
}
