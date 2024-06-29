package ru.stqa.pft.mantis.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.Browser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private final Properties properties;

    private final String browser;
    WebDriver wd;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        if (Objects.equals(browser, Browser.OPERA.browserName())) {
//            System.setProperty("webdriver.opera.driver", "C:\\Users\\user\\IdeaProjects\\operadriver_win32\\operadriver.exe");
            WebDriverManager.operadriver().setup();
            wd = new OperaDriver();
        } else if (Objects.equals(browser, Browser.EDGE.browserName())) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\user\\IdeaProjects\\edgedriver_win64\\msedgedriver.exe");
            wd = new EdgeDriver();
        } else if (Objects.equals(browser, Browser.IE.browserName())) {
            WebDriverManager.iedriver().setup();
            wd = new InternetExplorerDriver();
        }
        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));

//        sessionHelper.login(properties.getProperty("web.login"), properties.getProperty("web.password"));

    }

    public void stop() {
        wd.findElement(By.linkText("Logout")).click();
        wd.quit();
    }
}
