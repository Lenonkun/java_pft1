package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

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
        type(By.name("firstname"), contactData.fname());
        type(By.name("middlename"), contactData.mname());
        type(By.name("lastname"), contactData.lname());
        type(By.name("address"), contactData.address());
        type(By.name("mobile"), contactData.mobile());
        type(By.name("email"), contactData.email());
        select(By.name("bday"), contactData.bday());
        select(By.name("bmonth"), contactData.bmonth());
        type(By.name("byear"), contactData.byear());
        if (creation==true) {
            select(By.name("new_group"), contactData.newGroup());
        } else if (creation==false) {
            //Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
        type(By.name("address2"), contactData.address2());

    }

    public void submitContactCreation() {
        click(By.xpath("//*[@id=\"content\"]/form/input[21]"));
    }

    public void submitContactModification() {
        click(By.xpath("//*[@id=\"content\"]/form[1]/input[22]"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
        if (isAlertPresent()) {
            Alert alert = wd.switchTo().alert();
            alert.accept();
        }
    }

    public void initContactModification() {
        click(By.xpath("//img[@alt='Edit']"));
        //*[@id="maintable"]/tbody/tr[2]/td[8]/a/img

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
        List<WebElement> elements = wd.findElements(By.cssSelector("tr.entry"));
        for (WebElement element: elements){
            String name = element.findElement(By.cssSelector(("td:nth-child(2)")).toString();
            ContactData contact = new ContactData(name,null,null,null,null,null,null,null,null,null,null);
            contacts.add(contact);
        }
        return contacts;
    }
}
