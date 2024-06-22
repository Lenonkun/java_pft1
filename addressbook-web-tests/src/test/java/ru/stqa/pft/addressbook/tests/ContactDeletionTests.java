package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactDeletionTests extends TestBase {
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
    public void testDeletionContact() {
        Contacts before = app.contact().all();
        ContactData deletedContact=before.iterator().next();

        app.contact().delete(deletedContact);

        Assert.assertEquals(app.contact().count(), before.size() - 1);
        Contacts after = app.contact().all();

        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(deletedContact)));
    }



}
