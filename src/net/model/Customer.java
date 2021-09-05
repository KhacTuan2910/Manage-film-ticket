package net.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import net.controller.InfoFilterImp;
import net.exception.InvalidDayOfBirthException;
import net.exception.InvalidEmailException;
import net.exception.InvalidNameException;
import net.exception.InvalidPhoneNumberException;

/**
 *
 * @author NGUYEN KHAC TUAN
 */
public class Customer implements Serializable{
    private FullName fullName;
    private Date dob;
    private String id;
    private static int sId = 100000;
    private String customerType;
    private String email;
    private String phoneNumber;

    public Customer() {
        fullName = new FullName();
        id = "KH" + sId++;
    }

    public Customer(String id) {
        this.id = id;
    }

    public Customer(String fullName, String dob, String customerType,
            String email, String phoneNumber) throws InvalidNameException,
            InvalidDayOfBirthException, ParseException, InvalidEmailException, 
            InvalidPhoneNumberException {
        this();
        setFullName(fullName);
        setDob(dob);
        setCustomerType(customerType);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    public Customer(String fullName, String dob, String id, String customerType,
            String email, String phoneNumber) 
            throws InvalidNameException, InvalidDayOfBirthException, 
            ParseException, InvalidEmailException, 
            InvalidPhoneNumberException {
        this.id = id;
        setFullName(fullName);
        setDob(dob);
        setCustomerType(customerType);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    public String getFullName() {
        return fullName.getLast()
                + fullName.getMid() + " " + fullName.getFirst();
    }
    
    public String getFirstName(){
        return this.fullName.first ;
    }

    public void setFullName(String fullName) throws InvalidNameException {
        this.fullName = new FullName();
        var infoFilter = new InfoFilterImp();
        try {
            if (infoFilter.isNameValid(fullName)) {
                var words = fullName.split("\\s+");
                if (words.length > 0) {
                    this.fullName.setLast(words[0]);
                    this.fullName.setFirst(words[words.length - 1]);
                    var mName = " ";
                    for (int i = 1; i < words.length - 1; i++) {
                        mName += words[i];
                    }
                    this.fullName.setMid(mName);
                }
            }
        } catch (InvalidNameException ex) {
            throw ex;
        }
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(String dob) 
            throws InvalidDayOfBirthException, ParseException {
        var infoFilter = new InfoFilterImp();
        try {
            if (infoFilter.isDOBValid(dob)) {
                this.dob = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
            }
        } catch (InvalidDayOfBirthException | ParseException ex) {
            throw ex;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static int getsId() {
        return sId;
    }

    public static void setsId(int sId) {
        Customer.sId = sId;
    }
    
    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidEmailException {
        var infoFilter = new InfoFilterImp();
        try {
            if (infoFilter.isEmailValid(email)) {
                this.email = email;
            }
        } catch (InvalidEmailException ex) {
            throw ex;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) 
            throws InvalidPhoneNumberException {
        var infoFilter = new InfoFilterImp();
        try {
            if (infoFilter.isPhoneNumberValid(phoneNumber)) {
                this.phoneNumber = phoneNumber;
            }
        } catch (InvalidPhoneNumberException ex) {
            throw ex;
        }
    }

    class FullName implements Serializable {

        private String first;
        private String last;
        private String mid;

        public FullName() {
            first = "";
            last = "";
            mid = "";
        }

        public FullName(String first) {
            this.first = first;
        }

        public FullName(String first, String last, String mid) {
            this.first = first;
            this.last = last;
            this.mid = mid;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.id);
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
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
    
    

    @Override
    public String toString() {
        return "Customer{" + "fullName=" + fullName + ", dob=" + dob 
                + ", id=" + id + ", customerType=" + customerType 
                + ", email=" + email + ", phoneNumber=" + phoneNumber + '}';
    }
    
    
}
