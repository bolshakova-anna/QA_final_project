package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.junit.ScreenShooter;
import org.junit.Rule;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class FeedPage extends BasePage<FeedPage> {
    @Rule
    public ScreenShooter screenShooter = ScreenShooter.failedTests();
    private static By TOOLBAR_MUSIC_BUTTON = By.xpath("//*[@id=\"music_toolbar_button\"]");
    private static final By TOOLBAR_DECOR = By.xpath("//*[@class='toolbar_decor']");
    private static final By NAVIGATION = By.xpath("//*[@class='navigation']");
    private static final By BLOCK_LEFT_COLUMN_TOP_CARD = By.xpath("//*[@id=\"hook_Block_LeftColumnTopCard\"]");
    private static final By BLOCK_LEFT_COLUMN_THIRD_MENU_SECTION = By.xpath("//*[@id=\"hook_Block_LeftColumnThirdMenuSection\"]");
    private static final By LAYOUT_MAIN = By.xpath("//*[@class=\"layout-main __width-wide-additional-column\"]");
    private static final By EVENT_MENU_BUTTON = By.xpath("//*[@href='/events']");


    public FeedPage(){
        super();
    }

    @Override
    protected void check() {
        $(TOOLBAR_MUSIC_BUTTON).shouldBe(Condition.visible);
        $(TOOLBAR_DECOR).shouldBe(visible.because("Не отобразился тулбар"));
        $(NAVIGATION).shouldBe(visible.because("Не отобразился блок навигации"));
        $(BLOCK_LEFT_COLUMN_TOP_CARD).shouldBe(visible.because("Не отобразился блок навигации"));
        $(BLOCK_LEFT_COLUMN_THIRD_MENU_SECTION).shouldBe(visible.because("Не отобразился блок навигации"));
        $(LAYOUT_MAIN).shouldBe(visible.because("Не отобразился основной блок"));
    }

    public MusicLayerPage openMusicFromToolbar(){
        $(TOOLBAR_MUSIC_BUTTON).click();
        return new MusicLayerPage();
    }

    public EventPage openEventPage(){
        $(EVENT_MENU_BUTTON).click();
        return new EventPage();
    }
}
