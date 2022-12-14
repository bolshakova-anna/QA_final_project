package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.BeforeClass;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.refresh;

public class EventPage extends BasePage<EventPage>{
    private static final By TOOLBAR_DECOR = By.xpath("//*[@class='toolbar_decor']");
    private static final By NAVIGATION = By.xpath("//*[@class='navigation']");
    private static final By BLOCK_LEFT_COLUMN_TOP_CARD = By.xpath("//*[@id=\"hook_Block_LeftColumnTopCard\"]");
    private static final By BLOCK_LEFT_COLUMN_THIRD_MENU_SECTION = By.xpath("//*[@id=\"hook_Block_LeftColumnThirdMenuSection\"]");
    private static final By LAYOUT_MAIN = By.xpath("//*[@class=\"layout-main __width-wide-additional-column\"]");
    private static final By ADD_EVENT_BUTTON = By.xpath("//*[@class='button-pro __small']");
    private static final By EVENTS_CARDS = By.xpath(".//*[@class='events-calendar-day_type __myHolidays']");


    public EventPage(){
        super();
    }

    @Override
    protected void check() {
    $(TOOLBAR_DECOR).shouldBe(visible.because("Не отобразился тулбар"));
    $(NAVIGATION).shouldBe(visible.because("Не отобразился блок навигации"));
    $(BLOCK_LEFT_COLUMN_TOP_CARD).shouldBe(visible.because("Не отобразился блок навигации"));
    $(BLOCK_LEFT_COLUMN_THIRD_MENU_SECTION).shouldBe(visible.because("Не отобразился блок навигации"));
    $(LAYOUT_MAIN).shouldBe(visible.because("Не отобразился основной блок"));
    $(EVENTS_CARDS).shouldBe(visible.because("Не отображен блок праздников"));
    }


    public AddEventLayer pressAddEvent() {
        $(ADD_EVENT_BUTTON).click();
        return new AddEventLayer();
    }

    public boolean isEventsConsistThatEvent(String personName, String eventType){
        check();
        refreshPage();
        ElementsCollection events = $$(EVENTS_CARDS);
        for(SelenideElement element: events){
            if(element.has(text(personName)) && element.has(text(eventType))){
                return true;
            }
        }
        return false;
    }

}
