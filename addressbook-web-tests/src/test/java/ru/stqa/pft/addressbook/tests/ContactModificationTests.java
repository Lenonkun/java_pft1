package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.contact().goToHomePage();
        if (app.contact().list().size()==0) {
            app.contact().create(new ContactData("ivan", "ivanov", "ivanovich", "123", "999"
                    , "123@ya.ru", "11", "January", "1990", "group1", "123123"), true);
        }
    }
    @Test
    public void testContactModification() {
        List<ContactData> before = app.contact().list();

        int index = before.size()-1;
        ContactData contact = new ContactData(before.get(index).getId(),"ivan1", "ivanov", "ivanovich", "123", "999"
                , "123@ya.ru", "11", "January", "1990", "group1", "123123");

        app.contact().modify(index, contact);


        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());
        //Сравнение после модификации
        before.set(index, contact);
        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);//actual - фактический/expected - ожидаемый

    }




}
