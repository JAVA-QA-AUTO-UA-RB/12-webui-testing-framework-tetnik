package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@SuppressWarnings("unused")
public class AddRemoveElementsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "button[onclick='addElement()']")
    private WebElement addButton;

    @SuppressWarnings("unused")
    @FindBy(css = "button.added-manually")
    private List<WebElement> deleteButtons;

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public AddRemoveElementsPage open() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        wait.until(ExpectedConditions.visibilityOf(addButton));
        return this;
    }

    public AddRemoveElementsPage clickAdd() {
        addButton.click();
        wait.until(d -> !deleteButtons.isEmpty());
        return this;
    }

    public int getDeleteButtonsCount() {
        return deleteButtons.size();
    }

    public AddRemoveElementsPage clickDelete() {
        wait.until(d -> !deleteButtons.isEmpty());
        deleteButtons.get(0).click();
        return this;
    }
}

