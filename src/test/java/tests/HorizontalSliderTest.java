package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

public class HorizontalSliderTest extends BaseTest {

    @Test
    public void sliderShouldReachGivenValue() {
        String expectedValue = "3.5";

        HorizontalSliderPage page = new HorizontalSliderPage(driver)
                .open()
                .setValue(Double.valueOf(expectedValue));

        Assert.assertEquals(
                page.getValue(),
                expectedValue,
                "Слайдер мав показати значення " + expectedValue
        );
    }
}

