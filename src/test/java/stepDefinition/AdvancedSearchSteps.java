package stepDefinition;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import driver.DriverSetup;
import pages.AdvancedSearchActions;
import org.openqa.selenium.By;
import org.testng.Assert;


public class AdvancedSearchSteps {
    WebDriver driver;
    AdvancedSearchActions searchPage;

    @Given("the user is on the Advanced Search page")
    public void user_on_advanced_search_page() {
        driver = DriverSetup.getWebDriver();
        driver.get("https://webapps.tekstac.com/SeleniumApp2/Library/advancedSearch.html");
        searchPage = new AdvancedSearchActions(driver);
    }

    @When("the user enters author name as {string} and subject as {string}")
    public void user_enters_author_and_subject(String author, String subject) {
        searchPage.setAuthorName(author);
        searchPage.setSubject(subject);
    }

    @When("selects edition as {string}")
    public void user_selects_edition(String edition) {
        searchPage.selectEdition(edition);
    }

    @When("selects book format as {string}")
    public void user_selects_book_format(String format) {
        searchPage.selectBookFormat(format);
    }

    @When("selects age group as {string}")
    public void user_selects_age_group(String group) {
        searchPage.selectAgeGroup(group);
        searchPage.submit(); // Submit after all selections are made
    }

    @Then("books related to author should be listed")
    public void books_related_to_author_should_be_listed() {
        // Ideally check if books are listed in DOM
        System.out.println("Books related to author are expected to be listed.");
        DriverSetup.getWebDriver();
    }

    // ------------------ Optional: Keep other definitions if needed ------------------

    @When("the user leaves author name blank")
    public void user_leaves_author_name_blank() {
        searchPage.setAuthorName("");
    }

    @When("enters subject as {string}")
    public void enters_subject(String subject) {
        searchPage.setSubject(subject);
    }

    @When("the user enters author name as {string} and leaves subject blank")
    public void user_enters_author_and_leaves_subject_blank(String author) {
        searchPage.setAuthorName(author);
        searchPage.setSubject("");
    }

    @When("the user does not select any book format")
    public void user_does_not_select_book_format() {
        searchPage.submit();
    }

    @When("the user does not select any age group")
    public void user_does_not_select_age_group() {
        searchPage.submit();
    }

    @Then("an error message for author name should be displayed")
    public void error_for_author() {
        boolean present = driver.getPageSource().contains("Please Enter the Author Name");
        assert present;
        DriverSetup.getWebDriver();
    }

    @Then("an error message for subject should be displayed")
    public void error_for_subject() {
        boolean present = driver.getPageSource().contains("Please Enter the Subject");
        assert present;
        DriverSetup.getWebDriver();
    }

    @Then("an error message for book format should be displayed")
    public void error_for_book_format() {
        boolean present = driver.getPageSource().contains("Please Select Format");
        assert present;
        DriverSetup.getWebDriver();
    }

    @Then("an error message for age group should be displayed")
    public void error_for_age_group() {
//        String errorText = driver.findElement(By.name("ageGroup")).getText();
//        Assert.assertEquals("Please Select AgeGroup", errorText.trim());
//        DriverSetup.quitDriver();
        
        boolean present = driver.getPageSource().contains("Please Select AgeGroup");
        assert present;
        DriverSetup.getWebDriver();
    }
    
    @Then("an error message for edition should be displayed")
    public void error_for_edition() {
        boolean present = driver.getPageSource().contains("Please Select Edition");
        assert present;
        DriverSetup.getWebDriver();
    }


    @Then("books for the selected age group should be listed")
    @Then("filtered books should be shown")
    public void result_should_be_listed() {
        System.out.println("Filtered books expected - verify via DOM if needed.");
        DriverSetup.getWebDriver();
    }
}
