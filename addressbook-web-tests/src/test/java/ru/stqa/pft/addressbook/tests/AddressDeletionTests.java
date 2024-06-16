package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class AddressDeletionTests extends TestBase {

    @Test
    public void testDeletionAddress(){
        app.getAddressHelper().selectAddress();
        app.getAddressHelper().deleteSelectedAddress();
        app.getAddressHelper().returnToHomePage();
    }

}
