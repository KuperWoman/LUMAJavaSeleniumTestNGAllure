package com.lumatest.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    private WebDriver driver;

    @BeforeMethod
    protected void setup() {
        WebDriverManager.chromedriver().setup();

       createChromeDriver();
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        if (this.driver != null) {
            getDriver().quit();
            this.driver = null;
        }
    }

    private void createChromeDriver() {
        if (this.driver == null) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--window-size=1920,1080", "--headless", "--disable-gpu");
            this.driver = new ChromeDriver(chromeOptions);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
