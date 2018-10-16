package com.greatersum.rental;

import com.greatersum.rental.model.Customer;
import com.greatersum.rental.model.MovieRental;
import org.approvaltests.Approvals;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class RentalTests {
    @Test
    public void MartinTest() throws FileNotFoundException {
        List<MovieRental> rentals = Arrays.asList(
                new MovieRental("F001", 3),
                new MovieRental("F002", 1)
        );
        Customer customer = new Customer("martin", rentals);

        RentalInfo info = new RentalInfo();
        String actualResult = info.statement(customer);

        Approvals.verify(actualResult);
    }

    @Test
    public void AllMovieCodesFourDays() throws FileNotFoundException {
        List<MovieRental> rentals = Arrays.asList(
                new MovieRental("F001", 4),
                new MovieRental("F002", 4),
                new MovieRental("F003", 4),
                new MovieRental("F004", 4)
        );
        Customer customer = new Customer("martin", rentals);

        RentalInfo info = new RentalInfo();
        String actualResult = info.statement(customer);

        Approvals.verify(actualResult);
    }

    @Test
    public void AllMovieCodesOneDay() throws FileNotFoundException {
        List<MovieRental> rentals = Arrays.asList(
                new MovieRental("F001", 1),
                new MovieRental("F002", 1),
                new MovieRental("F003", 1),
                new MovieRental("F004", 1)
        );
        Customer customer = new Customer("martin", rentals);

        RentalInfo info = new RentalInfo();
        String actualResult = info.statement(customer);

        Approvals.verify(actualResult);
    }
}
