package test;

import highlighter.Highlighter;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Configuration.browserSize;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class BaseTest {
  private static  final boolean defaultStartMaximized = true;
  private static  final String defaultBrowser = "chrome";
  public static final String url = "https://ok.ru/";

  @BeforeEach
  public void setupBrowser() {
    startMaximized = defaultStartMaximized;
    browser = defaultBrowser;
   // addListener(new Highlighter());
    open(url);
  }

  @AfterEach
  public void logout() {
    closeWebDriver();
  }

  }

