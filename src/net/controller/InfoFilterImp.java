/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.exception.InvalidDayOfBirthException;
import net.exception.InvalidEmailException;
import net.exception.InvalidNameException;
import net.exception.InvalidPhoneNumberException;

/**
 *
 * @author NGUYEN KHAC TUAN
 */
public class InfoFilterImp implements InforFilter {

    @Override
    public boolean isDOBValid(String dob) throws InvalidDayOfBirthException {
        var regex = "^\\d{2}/\\d{2}/\\d{4}$";
        Pattern dobPattern = Pattern.compile(regex);
        Matcher matcher = dobPattern.matcher(dob);
        if (matcher.matches()) {
            return true;
        } else {
            var msg = "Ngày sinh không hợp lệ: " + dob;
            throw new InvalidDayOfBirthException(dob, msg);
        }
    }

    @Override
    public boolean isNameValid(String name) throws InvalidNameException {
        if (name != null && name.length() > 0) {
            var regex = "^(\\w+.*[^0-9].*){2,40}$";
            Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(name);
            if (matcher.matches()) {
                return true;
            } else {
                var msg = "Họ tên không hợp lệ: " + name;
                throw new InvalidNameException(msg, name);
            }
        } else {
            var msg = "Họ tên không hợp lệ: " + name;
            throw new InvalidNameException(name, msg);
        }
    }

    @Override
    public boolean isEmailValid(String email) throws InvalidEmailException {
        var regex = "^[a-z]+[a-z0-9._]*@gmail.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        } else {
            var msg = "Email không hợp lệ: " + email;
            throw new InvalidEmailException(email, msg);
        }
    }

    @Override
    public boolean isPhoneNumberValid(String phoneNumber) 
            throws InvalidPhoneNumberException {
        var regex = "^(03|04|07|08|09)\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        if (matcher.matches()) {
            return true;
        } else {
            var msg = "Số điện thoại không hợp lệ: " + phoneNumber;
            throw new InvalidPhoneNumberException(phoneNumber, msg);
        }
    }
    
}
