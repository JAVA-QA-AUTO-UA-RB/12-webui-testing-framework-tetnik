package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;

public class DropdownTest extends BaseTest {

    @Test
    public void optionOneShouldBeSelectable() {
        DropdownPage page = new DropdownPage(driver).open();

        page.selectOption("Option 1");
        String selected = page.getSelected();

        Assert.assertEquals(
                selected,
                "Option 1",
                "Після вибору 'Option 1' вона має бути вибрана"
        );
    }

    @Test
    public void optionTwoShouldBeSelectable() {
        DropdownPage page = new DropdownPage(driver).open();

        page.selectOption("Option 2");
        String selected = page.getSelected();

        Assert.assertEquals(
                selected,
                "Option 2",
                "Після вибору 'Option 2' вона має бути вибрана"
        );
    }
}

