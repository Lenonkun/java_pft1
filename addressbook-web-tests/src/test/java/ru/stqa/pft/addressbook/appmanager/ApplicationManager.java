package ru.stqa.pft.addressbook.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.Browser;



import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private final Browser brouser;
    WebDriver wd;
    private GroupHelper groupHelper;
    private NavigationHelper navigationHelper;
    private SessionHelper sessionHelper;
    private ContactHelper addressHelper;
    public ApplicationManager(Browser brouser) {
        this.brouser = brouser;
    }

    public void init() {
        if (Objects.equals(brouser, Browser.OPERA)) {
            System.setProperty("webdriver.opera.driver", "C:\\Users\\user\\IdeaProjects\\operadriver_win32\\operadriver.exe");
            wd = new OperaDriver();
        } else if (Objects.equals(brouser, Browser.EDGE)) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\IdeaProjects\\edgedriver_win64\\msedgedriver.exe");
            wd = new EdgeDriver();
        } else if (Objects.equals(brouser, Browser.IE)) {
            wd = new InternetExplorerDriver();
            WebDriverManager.iedriver().setup();
        }
        wd.get("http://localhost/addressbook/");
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        addressHelper = new ContactHelper(wd);

        sessionHelper.login("secret", "admin");
    }
    public void stop() {
        wd.findElement(By.linkText("Logout")).click();
        wd.quit();
    }
    public GroupHelper group() {
        return groupHelper;
    }
    public NavigationHelper goTo() {
        return navigationHelper;
    }
    public ContactHelper contact() {
        return addressHelper;
    }

}
