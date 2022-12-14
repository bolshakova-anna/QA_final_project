package test;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import page.LoginPage;
import utils.UserTestBot;

import static com.codeborne.selenide.Selenide.$;

@DisplayName("Невозможность логина юзера при неверном пароле")
public class TestFailedLoginWithWrongPassword extends BaseTest{
    private static String OKUsername = System.getProperty("OK.username", "technoPol27");
    private static String OKPassword = System.getProperty("OK.password", "technoPolis2022");
    private static String OKName = System.getProperty("OK.idName", "technoPol27 technoPol27");
    private static By USERNAME_IN_NAVIGATION = By.xpath("//div[@class='tico ellip']");
    public static final String url = "https://ok.ru/";

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"technoPolis", "aaawda"})
    @DisplayName("Проверка невозможности логина юзера при неверном пароле/пустом вводе")
    public void testFailedLoginWithWrongPassword(String password) {
        openPage(url);
        UserTestBot bot = new UserTestBot(OKUsername, password, OKName);
        LoginPage loginpage = new LoginPage();
        loginpage.login(bot);
        if(password == null || password.equals(""))
            Assert.assertEquals(loginpage.getLoginErrorText(),"Введите пароль");
        else
            Assert.assertEquals(loginpage.getLoginErrorText(),"Неправильно указан логин и/или пароль");
    }

}