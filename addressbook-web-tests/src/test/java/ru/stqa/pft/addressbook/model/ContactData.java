package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData{
    private int id;
    private final String fname;
    private final String mname;
    private final String lname;
    private final String address;
    private final String mobile;
    private final String email;
    private final String bday;
    private final String bmonth;
    private final String byear;
    private final String newGroup;
    private final String address2;

    public ContactData(int id, String fname, String mname, String lname, String address, String mobile, String email, String bday, String bmonth, String byear, String newGroup, String address2) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.mname = mname;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.newGroup = newGroup;
        this.address2 = address2;
    }
    public ContactData(String fname, String mname, String lname, String address, String mobile, String email, String bday, String bmonth, String byear, String newGroup, String address2) {
        id = 0;
        this.fname = fname;
        this.lname = lname;
        this.mname = mname;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.newGroup = newGroup;
        this.address2 = address2;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", lname='" + lname + '\'' +
                ", fname='" + fname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData contactData = (ContactData) o;

        if (id != contactData.id) return false;
        if (!Objects.equals(fname, contactData.fname)) return false;
        return Objects.equals(lname, contactData.lname);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public String getMname() {
        return mname;
    }

    public String getLname() {
        return lname;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }

    public String getNewGroup() {
        return newGroup;
    }

    public String getAddress2() {
        return address2;
    }
}
