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
public class InvalidEmailException extends Exception {

    private String invalidEmail;

    public InvalidEmailException() {
    }

    public InvalidEmailException(String invalidEmail, String message) {
        super(message);
        this.invalidEmail = invalidEmail;
    }

    public String getInvalidEmail() {
        return invalidEmail;
    }

    public void setInvalidEmail(String invalidEmail) {
        this.invalidEmail = invalidEmail;
    }

}
