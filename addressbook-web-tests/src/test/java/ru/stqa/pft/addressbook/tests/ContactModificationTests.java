package ru.stqa.pft.addressbook.tests;

import org.apache.http.annotation.Contract;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        if (!app.getContactHelper().isThereContact()) {
            app.getContactHelper().createContact(new ContactData("ivan1", "ivanov", "ivanovich", "123", "999"
                    , "123@ya.ru", "11", "January", "1990", "group1", "123123"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
//        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().initContactModification(before.size()-1);
        ContactData contact = new ContactData(before.get(before.size()-1).getId(),"ivan1", "ivanov", "ivanovich", "123", "999"
                , "123@ya.ru", "11", "January", "1990", "group1", "123123");
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        //Сравнение после модификации
        before.set(before.size()-1, contact);
        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
//        Assert.assertEquals(after,before);//actual - фактический/expected - ожидаемый
        Assert.assertEquals(before,after);//actual - фактический/expected - ожидаемый

    }


}
