package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public void modify(ContactData contact) {
        initContactModification(contact.getId());
        fillContactForm(contact, false);
        submitContactModification();
        goToHomePage();
    }
    public void delete(ContactData delete) {
        selectContact(delete.getId());
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

    public void selectContact(int id) {
        wd.findElement(By.cssSelector("input[value='"+id+"']")).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
        if (isAlertPresent()) {
            Alert alert = wd.switchTo().alert();
            alert.accept();
        }
    }

    public void initContactModification(int id) {
        wd.findElement(By.cssSelector("tr[name='entry'] > td[class='center'] > a[href='edit.php?id="+id+"']")).click();
    }

    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement element : elements) {
            int id = Integer.parseInt( element.findElement(By.tagName("input")).getAttribute("value"));
            String fisrstName = element.findElement(By.xpath(".//td[3]")).getText();
            String fisrstName1 = element.findElement(By.cssSelector("td:nth-of-type(3)")).getText();
            String lastName = element.findElement(By.xpath(".//td[2]")).getText();
            String lastName1 = element.findElement(By.cssSelector("td:nth-of-type(2)")).getText();
            contacts.add(new ContactData().withId(id).withFname(fisrstName1).withLname(lastName1));
        }
        return contacts;
    }

    public boolean isThereContact() {
        return isElementPresent(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }
}
