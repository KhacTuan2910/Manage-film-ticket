package net.controller.sort;

import java.util.Comparator;
import net.model.Customer;

/**
 *
 * @author NGUYEN KHAC TUAN
 */
public class SortCusByNameDESC implements Comparator<Customer>{

    @Override
    public int compare(Customer o1, Customer o2) {
        return o2.getFirstName().compareTo(o1.getFirstName());
    }
}
