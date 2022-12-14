package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.openqa.selenium.*;
import utils.UserTestBot;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginPage extends BasePage<LoginPage>{
  @Rule
  public ScreenShooter screenShooter = ScreenShooter.failedTests();

  private static final String url = "https://ok.ru/";
  private static final By LOGIN_ERROR_TEXT = By.xpath("//*[@class='input-e login_error']");
  private static final By LOGIN_FIELD = By.xpath("//*[@id='field_email']");
  private static final By PASSWORD_FIELD = By.xpath("//*[@id='field_password']");
  private static final By LOGIN_BUTTON = By.xpath("//*[@class='button-pro __wide']");


  public LoginPage(){
    super();
  }

  @Override
  protected void check(){
    $(LOGIN_FIELD).shouldBe(Condition.visible.because("Не отобралились поля ввода"));
    $(PASSWORD_FIELD).shouldBe(Condition.visible.because("Не отобралились поля ввода"));
  }

  public LoginPage login(String OKUsername,String OKPassword) {
    $(LOGIN_FIELD).val(OKUsername);
    $(PASSWORD_FIELD).val(OKPassword);
    $(LOGIN_BUTTON).shouldBe(Condition.visible.because("Нет кнопки входа")).click();
    return this;
  }

  public LoginPage login(UserTestBot userTestBot) {
    $(LOGIN_FIELD).val(userTestBot.getLogin());
    $(PASSWORD_FIELD).val(userTestBot.getPassword());
    $(LOGIN_BUTTON).shouldBe(Condition.visible.because("Нет кнопки входа")).click();
    return this;
  }

  public String getLoginErrorText(){
    return $(LOGIN_ERROR_TEXT).text();
  }
}
