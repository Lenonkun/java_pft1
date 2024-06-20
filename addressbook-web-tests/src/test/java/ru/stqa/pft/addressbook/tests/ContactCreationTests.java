package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testCreationContact() throws Exception {
//        for(int i = 1;i<4;i++) {
//            logger.info("Пример логирования с использованием SLF4J и Logback");
            app.contact().goToHomePage();
            List<ContactData> before = app.contact().list();
            ContactData contact = new ContactData()
                    .withFname("ivan1").withMname("ivanov").withLname("ivanovich").withAddress("123")
                    .withMobile("999").withEmail("123@ya.ru").withBday("11").withBmonth("January")
                    .withByear("1990").withGroup("group1").withAddress2("123123");
            app.contact().create(contact,true);

            List<ContactData> after = app.contact().list();
            Assert.assertEquals(after.size(), before.size() + 1);

            Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
            before.add(contact);
            before.sort(byId);
            after.sort(byId);
            Assert.assertEquals(before,after);
//        }

    }
}
