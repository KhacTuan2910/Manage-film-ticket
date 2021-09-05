/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author NGUYEN KHAC TUAN
 */
public class Bill implements Serializable {

    private Customer customer;
    private Movie movie;
    private Date bookDate;
    private long priceticket;
    private int numberOfTicketBooked;

    public Bill() {
    }

    public Bill(Customer customer, Movie movie, Date bookDate, 
            long priceticket, int numberOfTicketBooked) {
        this.customer = customer;
        this.movie = movie;
        this.bookDate = bookDate;
        this.priceticket = priceticket;
        this.numberOfTicketBooked = numberOfTicketBooked;
    }

    public int getNumberOfTicketBooked() {
        return numberOfTicketBooked;
    }

    public void setNumberOfTicketBooked(int numberOfTicketBooked) {
        this.numberOfTicketBooked = numberOfTicketBooked;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public long getPriceticket() {
//        var CusType = customer.getCustomerType();
//        var RoomType = movie.getType();
//        int room2DPriceOC = 70000;
//        int room2DPriceSC = 50000;
//        int room3DPriceOC = 100000;
//        int room3DPriceSC = 70000;
//        int room4DPrice = 150000;
//        
//        if (RoomType.equalsIgnoreCase("4D")) {
//            priceticket = numberOfTicketBooked * room4DPrice;
//        }
//        
//        if (CusType.equalsIgnoreCase("OC")) {
//            if(RoomType.equalsIgnoreCase("2D")) {
//                priceticket = numberOfTicketBooked * room2DPriceOC;
//            } else if (RoomType.equalsIgnoreCase("3D")) {
//                priceticket = numberOfTicketBooked * room3DPriceOC;
//            }
//        } else if (CusType.equalsIgnoreCase("SC")) {
//            if(RoomType.equalsIgnoreCase("2D")) {
//                priceticket = numberOfTicketBooked * room2DPriceSC;
//            } else if (RoomType.equalsIgnoreCase("3D")) {
//                priceticket = numberOfTicketBooked * room3DPriceSC;
//            }
//        }
        
        return priceticket;
    }

    public void setPriceticket(long priceticket) {
        this.priceticket = priceticket;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.customer);
        hash = 41 * hash + Objects.hashCode(this.movie);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bill other = (Bill) obj;
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.movie, other.movie)) {
            return false;
        }
        return true;
    }

}
