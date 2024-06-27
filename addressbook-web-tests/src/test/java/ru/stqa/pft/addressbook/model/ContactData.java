package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

import static java.sql.Types.TINYINT;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "middlename")
    private String middlename;
    @Expose
    @Column(name = "lastname")
    private String lastname;
    @Expose
    @Column(name = "address")
    private String address;
    @Expose
    @Column(name = "email")
    private String email;
    @Column(name = "email2")
    private String email2;
    @Column(name = "email3")
    private String email3;
    @Transient
    private String allEmails;
    @Expose
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "home")
    private String homePhone;
    @Column(name = "work")
    private String workPhone;
    @Transient
    private String allPhones;
    @XStreamOmitField
    @Column(name = "bday",columnDefinition = "tinyint")
    private String bday;
    @XStreamOmitField
    @Column(name = "bmonth")
    private String bmonth;
    @Column(name = "byear")
    private String byear;
    @XStreamOmitField
    @Transient
    private String group;
    @Column(name = "address2")
    private String address2;
    @Column(name = "photo")
    private String photo;

    @XStreamOmitField
    @Column(name = "deprecated", columnDefinition = "TIMESTAMP")
    private Date deprecated;

    public Date getDeprecated() {
        return deprecated;
    }
    public ContactData withDeprecated(Date deprecated) {
        this.deprecated = deprecated;
        return this;
    }


    public File getPhoto() {
        return new File(photo);
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
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
        this.firstname = fname;
        return this;
    }
    public String getFirstname() {
        return firstname;
    }


    public ContactData withMname(String mname) {
        this.middlename = mname;
        return this;
    }
    public String getMiddlename() {
        return middlename;
    }


    public ContactData withLname(String lname) {
        this.lastname = lname;
        return this;
    }
    public String getLastname() {
        return lastname;
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
        return "ContactData{" + "id=" + id + ", fname='" + firstname + '\'' + ", lname='" + lastname + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (!Objects.equals(firstname, that.firstname)) return false;
        return Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
}
