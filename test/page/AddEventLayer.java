package page;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class AddEventLayer extends BasePage<AddEventLayer> {
    private static final By ADD_EVENT_LAYER = By.xpath("//*[@class=\"modal-new_hld\"]");
    private static final By CHOOSE_WEDDING_AS_EVENT = By.xpath("//*[@class='text__2vfa1 __right__2vfa1'][contains(text(),'День свадьбы')]");
    private static final By ADD_PESRONAL_EVENT = By.xpath("//*[@class=\"add-holiday-popup_add-private-holiday payment-button\"]");
    private static final By CHOOSE_NOT_REGISTER_PERSON = By.xpath("//*[@class='choose-person__ze0c1'][contains(text(),'Родственника нет в ОК')]");
    private static final By NAME_OF_PERSON_PLACEHOLDER = By.xpath("//*[@class='input__prt1l __size-m__prt1l']");
    private static final By SAVE_EVENT_BUTTON = By.xpath("//*[@type='button']//*[contains(text(),'Сохранить')]");

    private static final String CALENDAR_DAY_WRAPPER = "//*[@class=\"day__2b6dp root__x4bwf\"]";
    private static final String CALENDAR_MONTH_WRAPPER = "//*[@class=\"month__2b6dp root__x4bwf\"]";
    private static final String CALENDAR_YEAR_WRAPPER = "//*[@class=\"year__2b6dp root__x4bwf\"]";

    @Override
    protected void check() {
        $(ADD_EVENT_LAYER).shouldBe(visible.because("Не отобразиля слой выбора ивента"));
    }

    public AddEventLayer(){
        super();
    }

    public AddEventLayer choosePersonalEventOption(){
        $(ADD_PESRONAL_EVENT).click();
        return this;
    }

    public AddEventLayer chooseWeddingAsEventOption(){
        $(CHOOSE_WEDDING_AS_EVENT).click();
        return this;
    }

    public AddEventLayer setNameForNotRegisteredPerson(String personName){
        $(CHOOSE_NOT_REGISTER_PERSON).click();
        $(NAME_OF_PERSON_PLACEHOLDER).val(personName);
        return this;
    }

    public AddEventLayer setCalendarDay(int day){
        String wrapperValue = "//*[@value = " + day + "]";
        $(By.xpath(CALENDAR_DAY_WRAPPER + wrapperValue)).click();
        return this;
    }

    public AddEventLayer setCalendarMonth(int month){
        String wrapperValue = "//*[@value = " + month + "]";
        $(By.xpath(CALENDAR_MONTH_WRAPPER + wrapperValue)).click();
        return this;
    }

    public AddEventLayer setCalendarYear(int year){
        String wrapperValue = "//*[@value = " + year + "]";
        $(By.xpath(CALENDAR_YEAR_WRAPPER + wrapperValue)).click();
        return this;
    }

    public EventPage saveEvent(){
        $(SAVE_EVENT_BUTTON).shouldBe(visible.because("Нет кнопки сохранения праздника")).click();
        return new EventPage();
    }

}

