package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

public class CheckboxesTest extends BaseTest {

    @Test
    public void firstCheckboxCanBeToggled() {
        CheckboxesPage page = new CheckboxesPage(driver).open();

        boolean initialState = page.isChecked(0);
        page.toggle(0);
        boolean afterToggle = page.isChecked(0);

        Assert.assertNotEquals(
                initialState,
                afterToggle,
                "Статус чекбоксу має змінюватися після кліку"
        );
    }

    @Test
    public void secondCheckboxCanBeToggled() {
        CheckboxesPage page = new CheckboxesPage(driver).open();

        boolean initialState = page.isChecked(1);
        page.toggle(1);
        boolean afterToggle = page.isChecked(1);

        Assert.assertNotEquals(
                initialState,
                afterToggle,
                "Статус другого чекбоксу також має змінюватися після кліку"
        );
    }
}

