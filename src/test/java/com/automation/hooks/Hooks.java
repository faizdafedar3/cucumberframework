package com.automation.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @Before
    public void setUp() {
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        driver.set(webDriver);
    }

    // ✅ THIS METHOD IS REQUIRED
    public static WebDriver getDriver() {
        return driver.get();
    }

    @After
    public void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
