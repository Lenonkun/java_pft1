package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData{
    private final String id;
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

    public ContactData(String id, String fname, String mname, String lname, String address, String mobile, String email, String bday, String bmonth, String byear, String newGroup, String address2) {
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
        this.id = null;
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
                "id='" + id + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(fname, that.fname)) return false;
        return Objects.equals(lname, that.lname);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        return result;
    }
    public String getId() {
        return id;
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
