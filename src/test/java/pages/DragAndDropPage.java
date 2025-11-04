package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragAndDropPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "column-a")
    private WebElement columnA;

    @FindBy(id = "column-b")
    private WebElement columnB;

    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public DragAndDropPage open() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        wait.until(ExpectedConditions.visibilityOf(columnA));
        return this;
    }

    public DragAndDropPage dragAtoB() {
        String js = """
            function simulateDragDrop(sourceNode, destinationNode) {
                const DATA_TRANSFER = new DataTransfer();
                const dragStartEvent = new DragEvent('dragstart', { dataTransfer: DATA_TRANSFER });
                sourceNode.dispatchEvent(dragStartEvent);
                
                const dropEvent = new DragEvent('drop', { dataTransfer: DATA_TRANSFER });
                destinationNode.dispatchEvent(dropEvent);
                
                const dragEndEvent = new DragEvent('dragend', { dataTransfer: DATA_TRANSFER });
                sourceNode.dispatchEvent(dragEndEvent);
            }
            simulateDragDrop(arguments[0], arguments[1]);
        """;

        ((JavascriptExecutor) driver).executeScript(js, columnA, columnB);
        return this;
    }

    public String getColumnAText() {
        return columnA.getText().trim();
    }

    public String getColumnBText() {
        return columnB.getText().trim();
    }
}
