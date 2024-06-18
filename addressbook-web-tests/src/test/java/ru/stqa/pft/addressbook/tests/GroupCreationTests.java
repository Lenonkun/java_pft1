package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("group2", null, null);
        app.getGroupHelper().createGroup(group);

        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);

        //вычисление максимального идентификатора
        Comparator<? super GroupData> byId = Comparator.comparingInt(GroupData::getId);
        before.add(group);

        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before,after);
}

}

