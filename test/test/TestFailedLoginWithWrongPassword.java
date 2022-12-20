package test;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import page.LoginPage;


@DisplayName("Невозможность логина юзера при неверном пароле")
public class TestFailedLoginWithWrongPassword extends BaseTest{
    private static final String OKUsername = System.getProperty("OK.username", "technoPol27");

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"technoPolis", "aaawda"})
    @DisplayName("Проверка невозможности логина юзера при неверном пароле/пустом вводе")
    public void testFailedLoginWithWrongPassword(String password) {
        LoginPage loginpage = new LoginPage();
        loginpage.fillUsername(OKUsername)
                .fillPassword(password)
                .pressLoginButton();
        if(password == null || password.equals(""))
            Assert.assertEquals(loginpage.getLoginErrorText(),"Введите пароль");
        else
            Assert.assertEquals(loginpage.getLoginErrorText(),"Неправильно указан логин и/или пароль");
    }

}