package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressModificationTests extends TestBase{
    @Test
    public void testAddressModification(){
        app.getAddressHelper().selectAddress();
        app.getAddressHelper().initAddressModification();
        app.getAddressHelper().fillAddressForm(new AddressData("Editivan", "Editivanov", "Editivanovich", "123", "999"
                , "123@ya.ru", "11", "January", "1990", "123123"));
        app.getAddressHelper().submitAddressModification();
        app.getAddressHelper().returnToHomePage();
    }


}
