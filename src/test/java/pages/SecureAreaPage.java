package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SecureAreaPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "flash")
    private WebElement flashMessage;

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getFlashMessageText() {
        wait.until(ExpectedConditions.visibilityOf(flashMessage));
        return flashMessage.getText().trim();
    }
}

