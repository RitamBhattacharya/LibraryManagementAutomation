package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AdvancedSearchActions {
    WebDriver driver;

    By authorName = By.id("authorName");
    By subject = By.id("subject");
    By edition = By.id("edition");
    By bookFormat = By.id("format");
    By kidsRadio = By.id("ageGroup_kids");
    By teenRadio = By.id("ageGroup_teen");
    By adultRadio = By.id("ageGroup_adult");
    By submitBtn = By.id("searchSubmit");
//    By ageGrp = By.name("ageGroup");
    public AdvancedSearchActions(WebDriver driver) {
        this.driver = driver;
    }

    public void setAuthorName(String name) {
        driver.findElement(authorName).clear();
        driver.findElement(authorName).sendKeys(name);
    }

    public void setSubject(String sub) {
        driver.findElement(subject).clear();
        driver.findElement(subject).sendKeys(sub);
    }

    public void selectEdition(String ed) {
        Select sel = new Select(driver.findElement(edition));
        sel.selectByVisibleText(ed);
    }

    public void selectBookFormat(String format) {
        Select sel = new Select(driver.findElement(bookFormat));
        sel.selectByVisibleText(format);
    }

    public void selectAgeGroup(String group) {
        switch (group.toLowerCase()) {
            case "teen":	
                driver.findElement(teenRadio).click();
                break;
            case "kids":
                driver.findElement(kidsRadio).click();
                break;
            case "adult":
                driver.findElement(adultRadio).click();
                break;
//            default:
//            	driver.findElement(ageGrp).click();
        }
    }

    public void submit() {
        driver.findElement(submitBtn).click();
    }
}