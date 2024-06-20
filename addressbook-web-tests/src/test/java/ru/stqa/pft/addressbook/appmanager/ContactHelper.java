package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void create(ContactData address, boolean b) {
        goToNewContactPage();//переходим на ЭФ создание адреса
        fillContactForm(address, b);
        submitContactCreation();
        goToHomePage();
    }
    public void modify(int index, ContactData contact) {
        initContactModification(index);
        fillContactForm(contact, false);
        submitContactModification();
        goToHomePage();
    }
    public void delete(int index) {
        selectContact(index);
        deleteSelectedContact();
        goToHomePage();
    }

    public void goToNewContactPage() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFname());
        type(By.name("middlename"), contactData.getMname());
        type(By.name("lastname"), contactData.getLname());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
        select(By.name("bday"), contactData.getBday());
        select(By.name("bmonth"), contactData.getBmonth());
        type(By.name("byear"), contactData.getByear());
        if (creation == true) {
            select(By.name("new_group"), contactData.getNewGroup());
        }
        else if (creation == false) {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
        type(By.name("address2"), contactData.getAddress2());

    }

    public void submitContactCreation() {
        click(By.xpath("//*[@id=\"content\"]/form/input[21]"));
    }

    public void goToHomePage() {
        click(By.linkText("home"));
    }


    public void submitContactModification() {
        click(By.xpath("//*[@id=\"content\"]/form[1]/input[22]"));
    }

    public void selectContact(int index) {
        wd.findElements(By.cssSelector("input[type='checkbox']")).get(index).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
        if (isAlertPresent()) {
            Alert alert = wd.switchTo().alert();
            alert.accept();
        }
    }

    public void initContactModification(int index) {
//        click(By.xpath("//img[@alt='Edit']"));
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public boolean isThereContact() {
        return isElementPresent(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement element : elements) {
            String lname = element.findElement(By.xpath("//td[2]")).getText();
            String name = element.findElement(By.xpath("//td[3]")).getText();
            int id = Integer.parseInt( element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withFname(name).withLname(lname);
            contacts.add(contact);
        }
        return contacts;
    }
}
