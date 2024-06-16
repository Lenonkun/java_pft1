package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressHelper extends HelperBase {


    public AddressHelper(WebDriver wd) {
        super(wd);
    }

    public void fillAddressForm(AddressData addressData) {
        type(By.name("firstname"), addressData.fname());
        type(By.name("middlename"), addressData.mname());
        type(By.name("lastname"), addressData.lname());
        type(By.name("address"), addressData.address());
        type(By.name("mobile"), addressData.mobile());
        type(By.name("email"), addressData.email());
        select(By.name("bday"), addressData.bday());
        select(By.name("bmonth"), addressData.bmonth());
        type(By.name("byear"), addressData.byear());
        select(By.name("new_group"), addressData.group());
        type(By.name("address2"), addressData.address2());

    }

    public void submitAddressCreation() {
        click(By.xpath("//input[21]"));
    }

    public void returnToHomePage(){
        click(By.linkText("home page"));
    }
}
