package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class AuthenticationTest extends BaseTest {

    @Test
    public void userCanLoginSuccessfully() {
        LoginPage loginPage = new LoginPage(driver).open();

        SecureAreaPage secureArea = loginPage.login("tomsmith", "SuperSecretPassword!");

        Assert.assertTrue(
                secureArea.getFlashMessageText().contains("You logged into a secure area!"),
                "Повідомлення про успішний логін має містити очікуваний текст"
        );
    }
}

