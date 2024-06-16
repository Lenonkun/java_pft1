package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.AddressData;

public class AddressCreationTests extends TestBase {

  @Test
  public void testCreationAddress() throws Exception {
    app.getNavigationHelper().goToAddressPage();//переходим на ЭФ создание адреса
    app.getAddressHelper().fillAddressForm(new AddressData("ivan", "ivanov", "ivanovich", "123", "999"
            , "123@ya.ru", "11", "January", "1990", "123123"));
    app.getAddressHelper().submitAddressCreation();
    app.getAddressHelper().returnToHomePage();

  }
}
