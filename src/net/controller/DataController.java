package net.controller;

import java.util.Date;
import java.util.List;
import net.model.Bill;
import net.model.Customer;
import net.model.Movie;

/**
 *
 * @author NGUYEN KHAC TUAN
 */
public interface DataController {

    int MOVIE = 1;
    int BILL = 2;
    int CUSTOMER = 3;
    String MOVIE_FILE = "MOVIE.DAT";
    String BILL_FILE = "BILL..DAT";
    String CUS_FILE = "CUSTOMER.DAT";

    <T> void writeToFile(List<T> data, String fileName);

    <T> List<T> readDataFromFile(String fileName);

    void sortMovieByNameASC(List<Movie> movies);

    void sortMovieByNameDESC(List<Movie> movies);

    void sortMovieByIdASC(List<Movie> movies);

    void sortMovieByIdDESC(List<Movie> movies);

    List<Movie> searchMovieByName(List<Movie> movies, String key);

    List<Movie> searchMovieById(List<Movie> movies, int key);

    List<Movie> searchMovieByRoomType(List<Movie> movies, String key);

    void sortCusByNameASC(List<Customer> customers);

    void sortCusByNameDESC(List<Customer> customers);

    void sortCusByIdASC(List<Customer> customers);

    void sortCusByIdDESC(List<Customer> customers);
    
    List<Customer> searchCusByName(List<Customer> customers, String key);

    List<Customer> searchCusById(List<Customer> customers, String key);

    List<Customer> searchCusByCusType(List<Customer> customers, String key);
    
    List<Bill> searchBillByCusId(List<Bill> bill, String key);
    
    List<Bill> searchBillByMovieId(List<Bill> bill, String key);
    
    List<Bill> searchBillByRType(List<Bill> bill, String key);
    
    List<Bill> searchBillByTime(List<Bill> bill, Date fromDate,Date toDate);
}
