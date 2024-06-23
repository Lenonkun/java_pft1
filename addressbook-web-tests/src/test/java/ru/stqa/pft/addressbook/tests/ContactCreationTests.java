package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testCreationContact() throws Exception {
//            logger.info("Пример логирования с использованием SLF4J и Logback");
        app.contact().goToHomePage();

        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/Photos_vjXZUhS7tQ.png");
        ContactData contact = new ContactData()
                .withFname("ivan").withMname("ivanov").withLname("ivanovich").withAddress("123")
                .withMobile("999").withEmail("123@ya.ru").withBday("11").withBmonth("January")
                .withByear("1990").withGroup("group1").withAddress2("123123").withPhoto(photo);

        app.contact().create(contact, true);
        Assert.assertEquals(app.contact().count(), before.size() + 1);
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}
