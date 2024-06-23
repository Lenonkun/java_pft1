package ru.stqa.pft.addressbook.model;

import java.io.File;
import java.util.Objects;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String fname;
    private String mname;
    private String lname;
    private String address;
    private String mobile;
    private String email;
    private String email2;
    private String email3;
    private String allEmails;
    private String bday="-";
    private String bmonth="-";
    private String byear;
    private String group="[none]";
    private String address2;
    private String homePhone;
    private String workPhone;
    private String allPhones;
    private File photo;


    public File getPhoto() {
        return photo;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }






    public ContactData withId(int id) {
        this.id = id;
        return this;
    }
    public int getId() {
        return id;
    }


    public ContactData withFname(String fname) {
        this.fname = fname;
        return this;
    }
    public String getFname() {
        return fname;
    }


    public ContactData withMname(String mname) {
        this.mname = mname;
        return this;
    }
    public String getMname() {
        return mname;
    }


    public ContactData withLname(String lname) {
        this.lname = lname;
        return this;
    }
    public String getLname() {
        return lname;
    }


    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }
    public String getAddress() {
        return address;
    }


    public ContactData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }
    public String getMobile() {
        return mobile;
    }


    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }
    public String getEmail() {
        return email;
    }


    public ContactData withBday(String bday) {
        this.bday = bday;
        return this;
    }
    public String getBday() {
        return bday;
    }


    public ContactData withBmonth(String bmonth) {
        this.bmonth = bmonth;
        return this;
    }
    public String getBmonth() {
        return bmonth;
    }


    public ContactData withByear(String byear) {
        this.byear = byear;
        return this;
    }
    public String getByear() {
        return byear;
    }


    public ContactData withGroup(String newGroup) {
        this.group = newGroup;
        return this;
    }
    public String getGroup() {
        return group;
    }


    public ContactData withAddress2(String address2) {
        this.address2 = address2;
        return this;
    }
    public String getAddress2() {
        return address2;
    }


    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }
    public String getHomePhone(){
        return homePhone;
    }


    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }
    public String getWorkPhone(){
        return workPhone;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }
    public String getEmail2(){
        return email2;
    }


    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }
    public String getEmail3(){
        return email3;
    }

    @Override
    public String toString() {
        return "ContactData{" + "id=" + id + ", fname='" + fname + '\'' + ", lname='" + lname + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (!Objects.equals(fname, that.fname)) return false;
        return Objects.equals(lname, that.lname);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fname != null ? fname.hashCode() : 0);
        result = 31 * result + (lname != null ? lname.hashCode() : 0);
        return result;
    }
}
