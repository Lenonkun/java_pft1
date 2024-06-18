package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testDeletionContact() {
        if (!app.getContactHelper().isThereContact()) {
            app.getContactHelper().createContact(new ContactData("ivan", "ivanov", "ivanovich", "123", "999"
                    , "123@ya.ru", "11", "January", "1990", "group4", "123123"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

//        Assert.assertEquals(before, after);
    }

}
