package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void goToNewContactPage() {
        click(By.linkText("add new"));
    }

    public void goToHomePage() {
        // if(isElementPresent(By.id("maintable"))){return;}
        click(By.linkText("home"));
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
        } else if (creation == false) {
            //Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
        type(By.name("address2"), contactData.getAddress2());

    }

    public void submitContactCreation() {
        click(By.xpath("//*[@id=\"content\"]/form/input[21]"));
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

    public void createContact(ContactData address, boolean b) {
        goToNewContactPage();//переходим на ЭФ создание адреса
        fillContactForm(address, true);
        submitContactCreation();
        goToHomePage();
    }

    public boolean isThereContact() {
        return isElementPresent(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement element : elements) {
            String name = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            String lname = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String id = element.findElement(By.tagName("input")).getAttribute("value");
            ContactData contact = new ContactData(id, name, lname, null, null, null, null, null, null, null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
