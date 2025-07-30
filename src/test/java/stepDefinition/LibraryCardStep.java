package stepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import driver.DriverSetup;
import pages.LibraryCardPage;

public class LibraryCardStep {

    WebDriver driver;
    LibraryCardPage libraryCardPage;

    @Given("the user is on the Get a Library Card form page")
    public void the_user_is_on_the_get_a_library_card_form_page() {
        driver = DriverSetup.getWebDriver();
        driver.manage().window().maximize();
        driver.get("https://webapps.tekstac.com/SeleniumApp2/Library/LibraryCard.html");
        libraryCardPage = new LibraryCardPage(driver);
    }

    @When("the user enters {string} as the first name")
    public void the_user_enters_as_the_first_name(String firstName) {
        libraryCardPage.enterFirstName(firstName);
    }

    @When("enters {string} as the last name")
    public void enters_as_the_last_name(String lastName) {
        libraryCardPage.enterLastName(lastName);
    }

    @When("enters {string} as the age")
    public void enters_as_the_age(String age) {
        libraryCardPage.enterAge(age);
    }

    @When("enters {string} as the email")
    public void enters_as_the_email(String email) {
        libraryCardPage.enterEmail(email);
    }

    @When("enters {string} as the phone number")
    public void enters_as_the_phone_number(String phone) {
        libraryCardPage.enterPhone(phone);
    }

    @When("selects {string} as the occupation")
    public void selects_as_the_occupation(String occupation) {
        libraryCardPage.selectOccupation(occupation);
    }

    @When("enters {string} as the school name")
    public void enters_as_the_school_name(String school) {
        libraryCardPage.enterSchoolName(school);
    }

    @When("selects {string} as the action")
    public void selects_as_the_action(String action) {
        libraryCardPage.selectAction(action);
    }

    @When("the user leaves the first name field blank")
    public void the_user_leaves_the_first_name_field_blank() {
        libraryCardPage.clearFirstName();
    }

    @When("leaves the age field blank")
    public void leaves_the_age_field_blank() {
        libraryCardPage.clearAge();
    }

    @When("leaves the phone number field blank")
    public void leaves_the_phone_number_field_blank() {
        libraryCardPage.clearPhone();
    }

    @When("submits the form")
    public void submits_the_form() {
        libraryCardPage.submitForm();
    }

    @Then("no error message should appear for the first name")
    public void no_error_message_should_appear_for_the_first_name() {
        Assert.assertFalse("Unexpected error message appeared for first name",
            libraryCardPage.isErrorMessagePresent("Please Enter first name"));
    }

    @Then("no error message should appear for the last name")
    public void no_error_message_should_appear_for_the_last_name() {
        Assert.assertFalse("Unexpected error message appeared for last name",
            libraryCardPage.isErrorMessagePresent("Please Enter last name"));
    }

    @Then("an error message should appear saying {string}")
    public void an_error_message_should_appear_saying(String expectedMessage) {
        Assert.assertTrue("Expected error message not displayed: " + expectedMessage,
            libraryCardPage.isErrorMessagePresent(expectedMessage));
    }


    @Then("the browser should close")
    public void the_browser_should_close() {
        driver.quit();
    }
}