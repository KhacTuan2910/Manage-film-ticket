/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.model;

import java.io.Serializable;

/**
 *
 * @author NGUYEN KHAC TUAN
 */
public class Movie implements Serializable {

    private int id;
    private static int sId = 100000; // id tự động tăng từ 100000
    private String name;
    private String type;
    private int numOfSeat;
    private int availableSeat;

    public Movie() {
        id = sId++;
    }

    public Movie(int id) {
        this.id = id;
    }

    public Movie(String name, String type, int numOfSeat, int availableSeat) {
        this();
        this.name = name;
        this.type = type;
        this.numOfSeat = numOfSeat;
        this.availableSeat = availableSeat;
    }

    public Movie(int id, String name, String type, int numOfSeat, int availableSeat) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.numOfSeat = numOfSeat;
        this.availableSeat = availableSeat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getsId() {
        return sId;
    }

    public static void setsId(int sId) {
        Movie.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumOfSeat() {
        return numOfSeat;
    }

    public void setNumOfSeat(int numOfSeat) {
        this.numOfSeat = numOfSeat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id;
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
        final Movie other = (Movie) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    // Tạm thời xét chỗ còn trống = số ghế. sửa sau !!!
    public int getAvailableSeat() {
        return availableSeat = getNumOfSeat();
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", name=" + name + ", type=" + type 
                + ", numOfSeat=" + numOfSeat 
                + ", availableSeat=" + availableSeat + '}';
    }

    

}
