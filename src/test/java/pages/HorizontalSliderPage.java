package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HorizontalSliderPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "input[type='range']")
    private WebElement slider;

    @FindBy(id = "range")
    private WebElement valueLabel;

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public HorizontalSliderPage open() {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");
        wait.until(ExpectedConditions.visibilityOf(slider));
        return this;
    }

    public HorizontalSliderPage setValue(double target) {
        double min = 0.0;
        double max = 5.0;
        double step = 0.5;

        if (target < min || target > max) {
            throw new IllegalArgumentException("Значення поза межами 0.0–5.0: " + target);
        }

        slider.click();
        for (int i = 0; i < 20; i++) slider.sendKeys(Keys.ARROW_LEFT);

        int steps = (int) Math.round(target / step);

        for (int i = 0; i < steps; i++) {
            slider.sendKeys(Keys.ARROW_RIGHT);
        }

        return this;
    }

    public String getValue() {
        return valueLabel.getText().trim();
    }
}
