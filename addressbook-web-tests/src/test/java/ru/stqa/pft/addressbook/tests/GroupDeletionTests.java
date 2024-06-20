package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;


public class GroupDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().list().size()==0) {
            app.group().create(new GroupData().withName("group1"));
        }

    }
    @Test
    public void testGroupDeletion() {
        Set<GroupData> before = app.group().all();
        GroupData deletedGroup=before.iterator().next();
        int index =before.size() - 1;

        app.group().delete(index);

        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(),before.size() - 1);

        before.remove(deletedGroup);
        Assert.assertEquals(before, after);

    }



}