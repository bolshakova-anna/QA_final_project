package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import page.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

@DisplayName("Логин юзера с правильным логином/паролем")
public class TestLoginShowsCorrectName extends BaseTest{
    private static String OKUsername = System.getProperty("OK.username", "technoPol27");
    private static String OKPassword = System.getProperty("OK.password", "technoPolis2022");
    private static String OKName = System.getProperty("OK.idName", "technoPol27 technoPol27");
    private static By USERNAME_IN_NAVIGATION = By.xpath("//div[@class='tico ellip']");
    public static final String url = "https://ok.ru/";

    @DisplayName("Проверка возможности логина юзера при верном логине/пароле")
    @Test
    public void testLoginShowsCorrectName() {
        openPage(url);
        LoginPage loginpage = new LoginPage();
        loginpage.login(OKUsername,OKPassword);
        $(USERNAME_IN_NAVIGATION)
                .shouldHave(text(OKName))
                .shouldBe(visible);
    }
}
