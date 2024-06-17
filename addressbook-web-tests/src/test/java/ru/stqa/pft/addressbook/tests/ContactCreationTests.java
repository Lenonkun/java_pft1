package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testCreationContact() throws Exception {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().goToNewContactPage();//переходим на ЭФ создание адреса
        app.getContactHelper().fillContactForm(new ContactData("ivan", "ivanov", "ivanovich", "123", "999"
                , "123@ya.ru", "11", "January", "1990", "group4", "123123"), true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(),before.size() + 1);

    }
}
