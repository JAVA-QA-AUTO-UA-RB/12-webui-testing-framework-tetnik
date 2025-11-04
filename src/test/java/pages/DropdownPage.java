package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class DropdownPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "dropdown")
    private WebElement dropdown;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public DropdownPage open() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        wait.until(ExpectedConditions.visibilityOf(dropdown));
        return this;
    }

    public void selectOption(String visibleText) {
        new Select(dropdown).selectByVisibleText(visibleText);
    }

    public String getSelected() {
        return new Select(dropdown).getFirstSelectedOption().getText().trim();
    }
}

