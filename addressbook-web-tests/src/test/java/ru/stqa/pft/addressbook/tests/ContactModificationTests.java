package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification() {
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereContact()){
            app.getContactHelper().createContact(new ContactData("ivan", "ivanov", "ivanovich", "123", "999"
                    , "123@ya.ru", "11", "January", "1990", "group4", "123123"), true);
        }
        app.getContactHelper().selectContact(0);
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Editivan", "Editivanov", "Editivanovich", "123", "999"
                , "123@ya.ru", "11", "January", "1990", null, "123123"), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().goToHomePage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,before);
    }


}
