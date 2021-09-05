/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.controller;

import net.exception.InvalidDayOfBirthException;
import net.exception.InvalidEmailException;
import net.exception.InvalidNameException;
import net.exception.InvalidPhoneNumberException;

/**
 *
 * @author NGUYEN KHAC TUAN
 */
public interface InforFilter {

    boolean isDOBValid(String dob) throws InvalidDayOfBirthException;

    boolean isNameValid(String name) throws InvalidNameException;

    boolean isEmailValid(String email) throws InvalidEmailException;

    boolean isPhoneNumberValid(String email) throws InvalidPhoneNumberException;
}
