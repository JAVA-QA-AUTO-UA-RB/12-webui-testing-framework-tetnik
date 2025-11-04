package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

public class HorizontalSliderTest extends BaseTest {

    @Test
    public void sliderShouldReachGivenValue() {
        HorizontalSliderPage page = new HorizontalSliderPage(driver)
                .open()
                .setValue(3.5);

        Assert.assertEquals(
                page.getValue(),
                "3.0",
                "Слайдер мав показати значення 3.0"
        );
    }
}

