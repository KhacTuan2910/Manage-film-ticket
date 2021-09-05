/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.exception;

/**
 *
 * @author NGUYEN KHAC TUAN
 */
public class InvalidDayOfBirthException extends Exception {

    private String invalidDob;

    public InvalidDayOfBirthException() {
    }

    public InvalidDayOfBirthException(String invalidDob, String message) {
        super(message);
        this.invalidDob = invalidDob;
    }

    public String getInvalidDob() {
        return invalidDob;
    }

    public void setInvalidDob(String invalidDob) {
        this.invalidDob = invalidDob;
    }

}
