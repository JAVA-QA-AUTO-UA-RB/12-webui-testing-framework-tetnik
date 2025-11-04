package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AbTestingPage;

public class AbTestingTest extends BaseTest {

    @Test
    public void shouldDisplayAbTestHeader() {
        String text = new AbTestingPage(driver)
                .open()
                .getHeaderText();
        Assert.assertTrue(text.contains("A/B Test"), "Очікували, що заголовок міститиме 'A/B Test'");
    }
}