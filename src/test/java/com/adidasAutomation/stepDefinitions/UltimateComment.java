package com.adidasAutomation.stepDefinitions;

import com.adidasAutomation.Pages.SamplePage;
import com.adidasAutomation.utilities.BrowserUtils;
import com.adidasAutomation.utilities.ConfigurationReader;
import com.adidasAutomation.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;


public class UltimateComment {

    SamplePage samplePage = new SamplePage();
    Faker faker = new Faker();
    String invalidEmail = faker.country().name();

    @Given("Open home page")
    public void open_home_page() {
        Driver.get().get(ConfigurationReader.getProperty("homePageUrl"));
    }

    @Given("Navigate to Sample page")
    public void navigate_to_Sample_page() {
        Driver.get().get(ConfigurationReader.getProperty("samplePageUrl"));
    }

    @When("Enter a comment with a wrong email")
    public void enter_a_comment_with_a_wrong_email() {
        BrowserUtils.scroll();
        Driver.get().switchTo().frame(samplePage.frame);

        samplePage.commentBox.sendKeys(faker.shakespeare().romeoAndJulietQuote());
        samplePage.emailBox.sendKeys(invalidEmail);
        samplePage.postCommentButton.click();


    }

    @Then("Check Error is displayed")
    public void check_Error_is_displayed() {

        String expectedMessage = "Please include an '@' in the email address. '"+ invalidEmail +"' is missing an '@'.";
        String actualMessage = samplePage.getInvalidEmailMessage();

        assertEquals(expectedMessage,actualMessage);
    }


    @Then("Enter a comment with a correct email")
    public void enter_a_comment_with_a_correct_email() {
        BrowserUtils.scroll();
        Driver.get().switchTo().frame(samplePage.frame);

        samplePage.commentBox.sendKeys(faker.harryPotter().quote());
        samplePage.emailBox.sendKeys(faker.internet().emailAddress());

        BrowserUtils.waitFor(3);
        samplePage.postCommentButton.click();
    }

    @Then("Check Comment is received")
    public void check_Comment_is_received() {
        BrowserUtils.waitFor(3);
        Driver.get().switchTo().frame(samplePage.frame);

        assertTrue(samplePage.newCommentBox.isDisplayed());

    }

}
