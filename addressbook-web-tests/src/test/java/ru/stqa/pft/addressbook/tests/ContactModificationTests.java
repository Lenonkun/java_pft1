package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        if (!app.getContactHelper().isThereContact()) {
            app.getContactHelper().createContact(new ContactData("ivan1", "ivanov", "ivanovich", "123", "999"
                    , "123@ya.ru", "11", "January", "1990", "group4", "123123"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        List<ContactData> before1 = app.getContactHelper().getContactList();
//        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().initContactModification(before.size()-1);
        ContactData contact = new ContactData(before.get(before.size()-1).getId(),"ivan3", "ivanov", "ivanovich", "123", "999"
                , "123@ya.ru", "11", "January", "1990", null, "123123");
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size()-1);
        before.add(contact);
//        before=after;
        Comparator<? super ContactData> byId = (Comparator<ContactData>) Comparator.comparingInt((ContactData o) -> o.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }


}
