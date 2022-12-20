package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import page.FeedPage;
import page.LoginPage;


@DisplayName("Логин юзера с правильным логином/паролем")
public class TestLoginShowsCorrectName extends BaseTest{
    private static final String OKUsername = System.getProperty("OK.username", "technoPol27");
    private static final String OKPassword = System.getProperty("OK.password", "technoPolis2022");
    private static final String OKName = System.getProperty("OK.idName", "technoPol27 technoPol27");

    @DisplayName("Проверка возможности логина юзера при верном логине/пароле")
    @Test
    public void testLoginShowsCorrectName() {
        LoginPage loginpage = new LoginPage();
        FeedPage feedPage = loginpage.login(OKUsername,OKPassword);
        feedPage.feedPageHasCorrectUsername(OKName);
    }
}
