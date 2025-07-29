package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.DriverSetup;

public class ServicePage {

    WebDriver driver;

    public ServicePage() {
        driver = DriverSetup.getWebDriver();
    }

    public void openSite() {
        driver.get("http://webapps.tekstac.com/SeleniumApp2/Library/Library.html");
        driver.manage().window().maximize();
    }

    public void goToServicesPage() {
        driver.findElement(By.linkText("Services")).click();
    }

    public void selectServiceOption(String option) {
        switch(option.toLowerCase()) {
            case "email":
                driver.findElement(By.id("medium_email")).click();
                break;
            case "call":
                driver.findElement(By.id("medium_call")).click();
                break;
            case "chat":
                driver.findElement(By.id("medium_chat")).click();
                break;
        }
    }

    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.id("fromEmail"));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPhone(String phone) {
        WebElement phoneField = driver.findElement(By.id("yourphone"));
        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    public void enterName(String name) {
        WebElement nameField = driver.findElement(By.id("chatname"));
        nameField.clear();
        nameField.sendKeys(name);
    }

    public void enterQueryemail(String queryText) {
        WebElement queryField = driver.findElement(By.id("queryemail"));
        queryField.clear();
        queryField.sendKeys(queryText);
    }

    public void enterQuerychat(String queryText) {
        WebElement queryField1 = driver.findElement(By.id("querychat"));
        queryField1.clear();
        queryField1.sendKeys(queryText);
    }

    public void clickSubmit() throws InterruptedException {
        driver.findElement(By.id("QuerySubmit")).click();
        Thread.sleep(5000);
    }

    public int getSelectedOptionCount() {
        int count = 0;
        if(driver.findElement(By.id("medium_email")).isSelected()) count++;
        if(driver.findElement(By.id("medium_call")).isSelected()) count++;
        if(driver.findElement(By.id("medium_chat")).isSelected()) count++;
        return count;
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(By.id("mediummailoutput")).isDisplayed();
    }

    public String isPhoneSuccessMessageDisplayed() {
        String calloutput = driver.findElement(By.id("mediumchatoutput")).getText();
        System.out.println(calloutput);
        return calloutput;
    }

    public String isInvalidEmailMessageDisplayed() {
        return driver.findElement(By.id("mediummailoutput")).getText();
    }

    public boolean isBlankEmailMessageDisplayed() {
        return driver.findElement(By.id("fromemailError")).isDisplayed();
    }

    public String isInvalidPhoneMessageDisplayed() {
        return driver.findElement(By.id("mediumchatoutput")).getText();
    }

    public boolean isBlankPhoneMessageDisplayed() {
        return driver.findElement(By.id("yourphoneError")).isDisplayed();
    }

    public String isInvalidNameMessageDisplayed() {
        return driver.findElement(By.id("mediumchatoutput")).getText();
    }

    public boolean isBlankNameMessageDisplayed() {
        return driver.findElement(By.id("chatnameError")).isDisplayed();
    }
}


/*
 * package pages;
 * 
 * import java.time.Duration; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.WebElement; import org.openqa.selenium.support.FindBy;
 * import org.openqa.selenium.support.PageFactory; import
 * org.openqa.selenium.support.ui.ExpectedConditions; import
 * org.openqa.selenium.support.ui.WebDriverWait; import driver.DriverSetup;
 * 
 * public class ServicePage {
 * 
 * WebDriver driver; WebDriverWait wait;
 * 
 * public ServicePage() { this.driver = DriverSetup.getWebDriver();
 * PageFactory.initElements(driver, this); this.wait = new WebDriverWait(driver,
 * Duration.ofSeconds(10)); }
 * 
 * // ---------- Page Elements ----------
 * 
 * @FindBy(linkText = "Services") WebElement servicesLink;
 * 
 * @FindBy(id = "medium_email") WebElement emailOption;
 * 
 * @FindBy(id = "medium_call") WebElement callOption;
 * 
 * @FindBy(id = "medium_chat") WebElement chatOption;
 * 
 * @FindBy(id = "fromEmail") WebElement emailField;
 * 
 * @FindBy(id = "yourphone") WebElement phoneField;
 * 
 * @FindBy(id = "chatname") WebElement nameField;
 * 
 * @FindBy(id = "queryemail") WebElement emailQueryField;
 * 
 * @FindBy(id = "querychat") WebElement chatQueryField;
 * 
 * @FindBy(id = "QuerySubmit") WebElement submitButton;
 * 
 * @FindBy(id = "mediummailoutput") WebElement emailOutput;
 * 
 * @FindBy(id = "mediumchatoutput") WebElement chatOutput;
 * 
 * @FindBy(id = "fromemailError") WebElement blankEmailError;
 * 
 * @FindBy(id = "yourphoneError") WebElement blankPhoneError;
 * 
 * @FindBy(id = "chatnameError") WebElement blankNameError;
 * 
 * // ---------- Page Actions ----------
 * 
 * public void openSite() {
 * driver.get("http://webapps.tekstac.com/SeleniumApp2/Library/Library.html");
 * driver.manage().window().maximize(); }
 * 
 * public void goToServicesPage() { servicesLink.click(); }
 * 
 * public void selectServiceOption(String option) { switch
 * (option.toLowerCase()) { case "email": emailOption.click(); break; case
 * "call": callOption.click(); break; case "chat": chatOption.click(); break; }
 * }
 * 
 * public void enterEmail(String email) { emailField.clear();
 * emailField.sendKeys(email); }
 * 
 * public void enterPhone(String phone) { phoneField.clear();
 * phoneField.sendKeys(phone); }
 * 
 * public void enterName(String name) { nameField.clear();
 * nameField.sendKeys(name); }
 * 
 * public void enterQueryemail(String queryText) { emailQueryField.clear();
 * emailQueryField.sendKeys(queryText); }
 * 
 * public void enterQuerychat(String queryText) { chatQueryField.clear();
 * chatQueryField.sendKeys(queryText); }
 * 
 * public void clickSubmit() { submitButton.click();
 * wait.until(ExpectedConditions.or(
 * ExpectedConditions.visibilityOf(emailOutput),
 * ExpectedConditions.visibilityOf(chatOutput) )); }
 * 
 * public int getSelectedOptionCount() { int count = 0; if
 * (emailOption.isSelected()) count++; if (callOption.isSelected()) count++; if
 * (chatOption.isSelected()) count++; return count; }
 * 
 * public boolean isSuccessMessageDisplayed() { return
 * emailOutput.isDisplayed(); }
 * 
 * public String isPhoneSuccessMessageDisplayed() { String message =
 * chatOutput.getText(); System.out.println("Phone success message: " +
 * message); return message; }
 * 
 * public String isInvalidEmailMessageDisplayed() { return
 * emailOutput.getText(); }
 * 
 * public boolean isBlankEmailMessageDisplayed() { return
 * blankEmailError.isDisplayed(); }
 * 
 * public String isInvalidPhoneMessageDisplayed() { return chatOutput.getText();
 * }
 * 
 * public boolean isBlankPhoneMessageDisplayed() { return
 * blankPhoneError.isDisplayed(); }
 * 
 * public String isInvalidNameMessageDisplayed() { return chatOutput.getText();
 * }
 * 
 * public boolean isBlankNameMessageDisplayed() { return
 * blankNameError.isDisplayed(); } }
 */