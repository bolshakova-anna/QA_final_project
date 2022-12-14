package test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.AddEventLayer;
import page.EventPage;
import page.FeedPage;
import page.LoginPage;
import java.util.Calendar;

import static org.junit.Assert.assertTrue;

@DisplayName("Тест добавления Дня Свадьбы с незарегестрированнным пользователем на сегодня")
public class TestAddWeddingEventWithNoRegisterPersonForToday extends BaseTest{
    private static String username = "technoPol27";
    private static String password = "technoPolis2022";
    private static String personName = "Name Surname";
    private static String eventType = "День свадьбы";
    public static final String url = "https://ok.ru/";

    @DisplayName("Тест добавления Дня Свадьбы с незарегестрированнным пользователем на сегодня")
    @Test
    public void testAddWeddingEventWithNoRegisterPersonForToday(){
        openPage(url);
        LoginPage loginpage = new LoginPage();
        FeedPage feedPage = new FeedPage();
        loginpage.login(username, password);

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        EventPage eventPage = feedPage.openEventPage(); //возвращает EventPage
        AddEventLayer addEventLayer = eventPage.pressAddEvent() ;
        addEventLayer.choosePersonalEventOption()
                .chooseWeddingAsEventOption()
                .setNameForNotRegisteredPerson(personName)
                .setCalendarDay(day)
                .setCalendarMonth(month)
                .setCalendarYear(year);
        eventPage = addEventLayer.saveEvent();
        eventPage.refreshPage();
        assertTrue("Тип праздника и имя человека отображаются верно", eventPage.isEventsConsistThatEvent(personName,eventType));
    }

}
