package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void create(ContactData address, boolean b) {
        goToNewContactPage();//переходим на ЭФ создание адреса
        fillContactForm(address, b);
        submitContactCreation();
        contactsCache=null;
        goToHomePage();
    }
    public void modify(ContactData contact) {
        initContactModification(contact.getId());
        fillContactForm(contact, false);
        submitContactModification();
        contactsCache=null;
        goToHomePage();
    }
    public void delete(ContactData delete) {
        selectContact(delete.getId());
        deleteSelectedContact();
        contactsCache=null;
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
            select(By.name("new_group"), contactData.getGroup());
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

    private Contacts contactsCache;
    public Contacts all() {
        if (contactsCache!=null){
            return contactsCache;
        }
        else
            contactsCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
        for (WebElement element : elements) {
            int id = Integer.parseInt( element.findElement(By.tagName("input")).getAttribute("value"));
            String fisrstName1 = element.findElement(By.cssSelector("td:nth-of-type(3)")).getText();
            String lastName1 = element.findElement(By.cssSelector("td:nth-of-type(2)")).getText();
            String address = element.findElement(By.cssSelector("td:nth-of-type(4)")).getText();
            String allEmails =element.findElement(By.cssSelector("td:nth-of-type(5)")).getText();
            String allPhones = element.findElement(By.cssSelector("td:nth-of-type(6)")).getText();

            contactsCache.add(new ContactData().withId(id).withFname(fisrstName1).withLname(lastName1)
                    .withAddress(address).withAllEmails(allEmails).withAllPhones(allPhones));
        }
        return contactsCache;
    }

    public boolean isThereContact() {
        return isElementPresent(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModification(contact.getId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");

        String address = wd.findElement(By.name("address")).getText();

        String home = cleaned(wd.findElement(By.name("home")).getAttribute("value"));
        String mobile = cleaned(wd.findElement(By.name("mobile")).getAttribute("value"));
        String work = cleaned(wd.findElement(By.name("work")).getAttribute("value"));

        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");

        wd.navigate().back();
        return contact.withId(contact.getId()).withFname(firstName).withLname(lastName)
                .withAddress(address).withHomePhone(home).withMobile(mobile).withWorkPhone(work)
                .withEmail(email).withEmail2(email2).withEmail3(email3);
    }

    public String cleaned(String phone){
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }
}
