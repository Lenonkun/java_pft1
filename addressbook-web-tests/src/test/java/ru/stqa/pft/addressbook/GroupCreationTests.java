package ru.stqa.pft.addressbook;

import org.testng.annotations.*;
//import org.apache.commons.io.FileUtils;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        goToGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("group3", "group3 header", "group3 footer"));
        submitGroupCreation();
        returnToGroupPage();

    }

}

