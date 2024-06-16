package ru.stqa.pft.addressbook.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.BrowserType;


import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final String brouser;
    WebDriver wd;
    private GroupHelper groupHelper;
    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private AddressHelper addressHelper;

    public ApplicationManager(String brouser) {
        this.brouser = brouser;
    }

    public void init() {
        if (brouser == BrowserType.OPERA) {
            System.setProperty("webdriver.opera.driver", "C:\\Users\\user\\IdeaProjects\\operadriver_win32\\operadriver.exe");
            wd = new OperaDriver();
        } else if (brouser == BrowserType.EDGE) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\IdeaProjects\\edgedriver_win64\\msedgedriver.exe");
            wd = new EdgeDriver();
        } else if (brouser == BrowserType.IE) {
            wd = new ChromeDriver();
            WebDriverManager.chromedriver().setup();
        }


        //System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\IdeaProjects\\edgedriver_win64\\msedgedriver.exe");
        //wd = new EdgeDriver();
        wd.get("http://localhost/addressbook/");
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        addressHelper = new AddressHelper(wd);


        sessionHelper.login("secret", "admin");
    }


    public void stop() {
        wd.findElement(By.linkText("Logout")).click();
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public AddressHelper getAddressHelper() {
        return addressHelper;
    }

}
