package com.automation.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.automation.pages.LoginPage;
import com.automation.hooks.Hooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver = Hooks.getDriver();   // ✅ FIX HERE
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage("https://www.saucedemo.com/");
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("clicks on login button")
    public void clicks_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        Assert.assertTrue(loginPage.isLoginSuccessful(),
                "User was not logged in successfully");
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertTrue(loginPage.isErrorDisplayed(),
                "Error message not displayed");
    }
}
