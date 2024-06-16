package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressHelper extends HelperBase {


    public AddressHelper(WebDriver wd) {
        super(wd);
    }

    public void fillAddressForm(AddressData addressData, boolean creation) {
        type(By.name("firstname"), addressData.fname());
        type(By.name("middlename"), addressData.mname());
        type(By.name("lastname"), addressData.lname());
        type(By.name("address"), addressData.address());
        type(By.name("mobile"), addressData.mobile());
        type(By.name("email"), addressData.email());
        select(By.name("bday"), addressData.bday());
        select(By.name("bmonth"), addressData.bmonth());
        type(By.name("byear"), addressData.byear());
        if (creation==true) {
            select(By.name("new_group"), addressData.newGroup());
        } else if (creation==false) {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
        type(By.name("address2"), addressData.address2());

    }

    public void submitAddressCreation() {
        click(By.xpath("//*[@id=\"content\"]/form/input[21]"));
    }

    public void submitAddressModification() {
        click(By.xpath("//*[@id=\"content\"]/form[1]/input[22]"));
    }


    public void returnToHomePage() {
        click(By.linkText("home"));
    }


    public void selectAddress() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedAddress() {
        click(By.xpath("//input[@value='Delete']"));
        if (isAlertPresent()) {
            Alert alert = wd.switchTo().alert();
            alert.accept();
        }
    }

    public void initAddressModification() {
        click(By.xpath("//img[@alt='Edit']"));
        //*[@id="maintable"]/tbody/tr[2]/td[8]/a/img

    }


}
