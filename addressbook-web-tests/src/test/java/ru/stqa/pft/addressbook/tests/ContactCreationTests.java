package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testCreationContact() throws Exception {
//            logger.info("Пример логирования с использованием SLF4J и Logback");
        app.contact().goToHomePage();

        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData()
                .withFname("ivan4").withMname("ivanovich").withLname("ivanov").withAddress("123")
                .withMobile("999").withEmail("123@ya.ru").withBday("11").withBmonth("January")
                .withByear("1990").withGroup("group1").withAddress2("123123");

        app.contact().create(contact, true);

        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
