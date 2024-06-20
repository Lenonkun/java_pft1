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
            app.goTo().HomePage();
            List<ContactData> before = app.contact().list();
            ContactData contact = new ContactData("ivan1", "ivanov", "ivanovich", "123", "999"
                    , "123@ya.ru", "11", "January", "1990", "group1", "123123");
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
