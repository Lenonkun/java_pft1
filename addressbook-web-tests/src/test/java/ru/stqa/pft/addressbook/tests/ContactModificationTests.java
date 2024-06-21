package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.contact().goToHomePage();
        if (app.contact().all().size()==0) {
            app.contact().create(new ContactData()
                    .withFname("ivan4").withMname("ivanovich").withLname("ivanov").withAddress("123")
                    .withMobile("999").withEmail("123@ya.ru").withBday("11").withBmonth("January")
                    .withByear("1990").withGroup("group1").withAddress2("123123"), true);
        }
    }
    @Test
    public void testContactModification() {
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFname("ivan1")
                .withMname("ivanov").withLname("ivanovich").withAddress("123").withMobile("999")
                .withEmail("123@ya.ru").withBday("11").withBmonth("January").withByear("1990")
                .withGroup("group1").withAddress2("123123");

        app.contact().modify(contact);


        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());
        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before,after);//actual - фактический/expected - ожидаемый

    }




}
