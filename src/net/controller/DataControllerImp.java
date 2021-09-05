package net.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.controller.sort.SortCusByIdASC;
import net.controller.sort.SortCusByIdDESC;
import net.controller.sort.SortCusByNameASC;
import net.controller.sort.SortCusByNameDESC;
import net.controller.sort.SortMovieByIdASC;
import net.controller.sort.SortMovieByIdDESC;
import net.controller.sort.SortMovieByNameASC;
import net.controller.sort.SortMovieByNameDESC;
import net.model.Bill;
import net.model.Customer;
import net.model.Movie;

/**
 *
 * @author NGUYEN KHAC TUAN
 */
public class DataControllerImp implements DataController {

    @Override
    public <T> void writeToFile(List<T> data, String fileName) {
        try ( FileOutputStream fos = new FileOutputStream(fileName);  ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(data);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public <T> List<T> readDataFromFile(String fileName) {
        List<T> data = new ArrayList<>();
        File file = new File(fileName);
        if (file.length() > 0) {
            try ( FileInputStream fis = new FileInputStream(file);  ObjectInputStream ois = new ObjectInputStream(fis)) {
                data = (List<T>) ois.readObject();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        return data;
    }

    @Override
    public void sortMovieByNameASC(List<Movie> movies) {
        Collections.sort(movies, new SortMovieByNameASC());
    }

    @Override
    public void sortMovieByNameDESC(List<Movie> movies) {
        Collections.sort(movies, new SortMovieByNameDESC());
    }

    @Override
    public void sortMovieByIdASC(List<Movie> movies) {
        Collections.sort(movies, new SortMovieByIdASC());
    }

    @Override
    public void sortMovieByIdDESC(List<Movie> movies) {
        Collections.sort(movies, new SortMovieByIdDESC());
    }

    @Override
    public List<Movie> searchMovieByName(List<Movie> movies, String key) {
        List<Movie> resultList = new ArrayList<>();
        var regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        for (Movie movie : movies) {
            matcher = pattern.matcher(movie.getName());
            if (matcher.matches()) {
                resultList.add(movie);
            }
        }
        return resultList;
    }

    @Override
    public List<Movie> searchMovieById(List<Movie> movies, int key) {
        List<Movie> resultList = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.getId() == key) {
                resultList.add(movie);
            }
        }
        return resultList;
    }

    @Override
    public List<Movie> searchMovieByRoomType(List<Movie> movies, String key) {
        List<Movie> resultList = new ArrayList<>();
        var regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        for (Movie movie : movies) {
            matcher = pattern.matcher(movie.getType());
            if (matcher.matches()) {
                resultList.add(movie);
            }
        }
        return resultList;
    }

    @Override
    public void sortCusByNameASC(List<Customer> customers) {
        Collections.sort(customers, new SortCusByNameASC());
    }

    @Override
    public void sortCusByNameDESC(List<Customer> customers) {
        Collections.sort(customers, new SortCusByNameDESC());
    }

    @Override
    public void sortCusByIdASC(List<Customer> customers) {
        Collections.sort(customers, new SortCusByIdASC());
    }

    @Override
    public void sortCusByIdDESC(List<Customer> customers) {
        Collections.sort(customers, new SortCusByIdDESC());
    }

    @Override
    public List<Customer> searchCusByName(List<Customer> customers, String key) {
        List<Customer> resultList = new ArrayList<>();
        var regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        for (Customer customer : customers) {
            matcher = pattern.matcher(customer.getFullName());
            if (matcher.matches()) {
                resultList.add(customer);
            }
        }
        return resultList;
    }

    @Override
    public List<Customer> searchCusById(List<Customer> customers, String key) {
        List<Customer> resultList = new ArrayList<>();
        var regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        for (Customer customer : customers) {
            matcher = pattern.matcher(customer.getId());
            if (matcher.matches()) {
                resultList.add(customer);
            }
        }
        return resultList;
    }

    @Override
    public List<Customer> searchCusByCusType(List<Customer> customers, String key) {
        List<Customer> resultList = new ArrayList<>();
        var regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        for (Customer customer : customers) {
            var customerType = customer.getCustomerType();
            matcher = pattern.matcher(customerType);
            if (matcher.matches()) {
                resultList.add(customer);
            }
        }
        return resultList;
    }

    @Override
    public List<Bill> searchBillByCusId(List<Bill> bills, String key) {
        List<Bill> resultList = new ArrayList<>();
        var regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        for (Bill b : bills) {
            matcher = pattern.matcher(b.getCustomer().getId());
            if (matcher.matches()) {
                resultList.add(b);
            }
        }
        return resultList;
    }

    @Override
    public List<Bill> searchBillByRType(List<Bill> bills, String key) {
        List<Bill> resultList = new ArrayList<>();
        var regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        for (Bill b : bills) {
            var movieType = b.getMovie().getType();
            matcher = pattern.matcher(movieType);
            if (matcher.matches()) {
                resultList.add(b);
            }
        }
        return resultList;
    }

    @Override
    public List<Bill> searchBillByTime(List<Bill> bills,
            Date fromDate, Date toDate) {
        List<Bill> resultList = new ArrayList<>();
        long deltaTime = 24 * 60 * 60 * 1000 - 1;//ms
        for (var b : bills) {
            if (fromDate.getTime() <= b.getBookDate().getTime()
                    && (toDate.getTime() + deltaTime
                    >= b.getBookDate().getTime())) {
                resultList.add(b);
            }
        }
        return resultList;
    }

    @Override
    public List<Bill> searchBillByMovieId(List<Bill> bills, String key) {
        List<Bill> resultList = new ArrayList<>();
        var regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher;
        for (Bill b : bills) {
            matcher = pattern.matcher(b.getMovie().getId() + "");
            if (matcher.matches()) {
                resultList.add(b);
            }
        }
        return resultList;
    }

}
