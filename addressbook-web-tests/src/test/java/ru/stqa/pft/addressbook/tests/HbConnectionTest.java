package ru.stqa.pft.addressbook.tests;

import jdk.jfr.Event;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import static java.lang.System.out;

public class HbConnectionTest {
    private SessionFactory sessionFactory;
    @BeforeClass
    protected void setUp() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .build();
        try {
            sessionFactory =
                    new MetadataSources(registry)
                            .addAnnotatedClass(GroupData.class)
                            .buildMetadata()
                            .buildSessionFactory();
        }
        catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
    @Test
    public void testHbConnection(){
        sessionFactory.inTransaction(session -> {
            session.createSelectionQuery("from GroupData", GroupData.class)
                    .getResultList()
                    .forEach(group -> out.println(group));
        });

    }
}
