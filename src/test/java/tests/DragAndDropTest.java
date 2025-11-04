package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DragAndDropPage;

public class DragAndDropTest extends BaseTest {

    @Test
    public void elementsShouldSwapAfterDragAndDrop() {
        DragAndDropPage page = new DragAndDropPage(driver).open();

        Assert.assertEquals(page.getColumnAText(), "A", "Перед перетягуванням у колонці A має бути 'A'");
        Assert.assertEquals(page.getColumnBText(), "B", "Перед перетягуванням у колонці B має бути 'B'");

        page.dragAtoB();

        Assert.assertEquals(page.getColumnAText(), "B", "Після перетягування колонка A має містити 'B'");
        Assert.assertEquals(page.getColumnBText(), "A", "Після перетягування колонка B має містити 'A'");
    }
}
