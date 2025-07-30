package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LibraryCardPage {

    WebDriver driver;

    public LibraryCardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By firstName = By.id("first");
    private By lastName = By.id("last");
    private By age = By.id("age");
    private By email = By.id("email");
    private By phone = By.id("phone");
    private By occupationStudent = By.id("work_0");
    private By occupationEmployee = By.id("work_1");
    private By schoolName = By.id("school");
    private By actionDropdown = By.id("action");
    private By submitButton = By.id("libraryCardSubmit");

    // Actions
    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void clearFirstName() {
        driver.findElement(firstName).clear();
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterAge(String ageVal) {
        driver.findElement(age).sendKeys(ageVal);
    }

    public void clearAge() {
        driver.findElement(age).clear();
    }

    public void enterEmail(String emailVal) {
        driver.findElement(email).sendKeys(emailVal);
    }

    public void enterPhone(String phoneVal) {
        driver.findElement(phone).sendKeys(phoneVal);
    }

    public void clearPhone() {
        driver.findElement(phone).clear();
    }

    public void selectOccupation(String occupation) {
        if (occupation.equalsIgnoreCase("Student")) {
            driver.findElement(occupationStudent).click();
        } else if (occupation.equalsIgnoreCase("Employee")) {
            driver.findElement(occupationEmployee).click();
        }
    }

    public void enterSchoolName(String school) {
        driver.findElement(schoolName).sendKeys(school);
    }

    public void selectAction(String action) {
        Select dropdown = new Select(driver.findElement(actionDropdown));
        dropdown.selectByVisibleText(action);
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    public boolean isErrorMessagePresent(String expectedMessage) {
        return driver.getPageSource().contains(expectedMessage);
    }
    public void selectCard(String cardType) {
        Select cardDropdown = new Select(driver.findElement(By.id("action")));

        if (cardType == null || cardType.trim().isEmpty() || cardType.equalsIgnoreCase("Select")) {
            // Select the default invalid option
            cardDropdown.selectByVisibleText("Select"); // 
        } else {
            cardDropdown.selectByVisibleText(cardType);
        }
    }
    public boolean isErrorMessageDisplayed(String expectedMessage) {
        List<WebElement> errorLabels = driver.findElements(By.tagName("label"));
        for (WebElement label : errorLabels) {
            if (label.isDisplayed() && label.getText().trim().equalsIgnoreCase(expectedMessage.trim())) {
                return true;
            }
        }
        return false;
    }

    
}