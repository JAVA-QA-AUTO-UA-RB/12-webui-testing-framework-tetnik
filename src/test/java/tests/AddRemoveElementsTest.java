package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRemoveElementsPage;
import base.BaseTest;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void testAddRemoveElements() {
        AddRemoveElementsPage page = new AddRemoveElementsPage(driver).open();

        page.clickAdd();
        Assert.assertEquals(page.getDeleteButtonsCount(), 1);

        page.clickDelete();
        Assert.assertEquals(page.getDeleteButtonsCount(), 0);
    }
}

