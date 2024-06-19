package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testCreationContact() throws Exception {
//        for(int i = 1;i<4;i++) {
//            logger.info("Пример логирования с использованием SLF4J и Logback");
            app.getContactHelper().goToHomePage();
            List<ContactData> before = app.getContactHelper().getContactList();
            ContactData contact = new ContactData("ivan1", "ivanov", "ivanovich", "123", "999"
                    , "123@ya.ru", "11", "January", "1990", "group1", "123123");
            app.getContactHelper().createContact(contact,true);

            List<ContactData> after = app.getContactHelper().getContactList();
            Assert.assertEquals(after.size(), before.size() + 1);

            Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
            before.add(contact);

            before.sort(byId);
            after.sort(byId);

            Assert.assertEquals(before,after);
//        }

    }
}
