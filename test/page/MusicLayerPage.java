package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MusicLayerPage extends BasePage<MusicLayerPage>{
    private static final By MUSIC_SEARCH_FIELD = By.xpath("//*[@placeholder=\"Поиск\" and @data-l=\"t,input\"]");
    private static final By MUSIC_SEARCH_FIELD_2 = By.xpath("//*[@id=\"music_layer\"]/header/div/wm-search-form/wm-search-input/input");
    private static final By MUSIC_LIST_ELEMENT = By.xpath("//a[contains(@data-payload, \"artistName=Звери\")]/../..");
    private static final By ADD_MUSIC_BUTTON = By.xpath("//*[@title=\"В мою музыку\"]");
    private static final By MY_MUSIC_BUTTON = By.xpath("//div[text()=\"Моя музыка\"]");
    private static final By MY_MUSIC_LIST_INFO = By.xpath("//*[@id='music_layer']//wm-tracks-list//wm-track//wm-card-details/slot");

    public MusicLayerPage(){
        super();
    }

    @Override
    protected void check() {
    $(MUSIC_SEARCH_FIELD).shouldBe(Condition.visible);
    }

    public MusicLayerPage searchMusic(String name){
        $(MUSIC_SEARCH_FIELD).click();
        $(MUSIC_SEARCH_FIELD_2).val(name).pressEnter();
        return this;

    }

    public MusicLayerPage addMusic(){
        $(MUSIC_LIST_ELEMENT).click();
        $(ADD_MUSIC_BUTTON).click();
        return this;
    }

    public MusicLayerPage openMyMusic(){
        $(MY_MUSIC_BUTTON).click();
        return this;
    }

    public static SelenideElement getMusicListElement() {
        return $(MY_MUSIC_LIST_INFO);
    }
}
