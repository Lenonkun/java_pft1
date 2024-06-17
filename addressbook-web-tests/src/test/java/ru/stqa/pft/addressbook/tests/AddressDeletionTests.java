package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressDeletionTests extends TestBase {

    @Test
    public void testDeletionAddress() {
        if (! app.getAddressHelper().isThereAddress()){
            app.getAddressHelper().createAddress(new AddressData("ivan", "ivanov", "ivanovich", "123", "999"
                    , "123@ya.ru", "11", "January", "1990", "group4", "123123"), true);
        }
        app.getAddressHelper().selectAddress();
        app.getAddressHelper().deleteSelectedAddress();
        app.getAddressHelper().goToHomePage();
    }

}
