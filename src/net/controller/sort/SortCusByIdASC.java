/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.controller.sort;

import java.util.Comparator;
import net.model.Customer;

/**
 *
 * @author NGUYEN KHAC TUAN
 */
public class SortCusByIdASC implements Comparator<Customer>{
    
    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
