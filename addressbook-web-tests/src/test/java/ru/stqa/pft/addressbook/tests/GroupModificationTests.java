package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size()==0) {
            app.group().create(new GroupData().withName("group1"));
        }

    }
    @Test
    public void testGroupModification(){
        Groups before = app.group().all();
        GroupData modifiedGroup=before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("group1").wihtFooter("group1").withHeader("group1");
        app.group().modify(group);

        Assert.assertEquals(app.group().count(),before.size());
        Groups after = app.group().all();
        MatcherAssert.assertThat(after, CoreMatchers.equalTo(
                before.without(modifiedGroup).withAdded(group)));
    }
}
