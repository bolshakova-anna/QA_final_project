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
    private static final String username = "technoPol27";
    private static final String password = "technoPolis2022";
    private static final String personName = "Name Surname";
    private static final String eventType = "День свадьбы";

    @DisplayName("Тест добавления Дня Свадьбы с незарегестрированнным пользователем на сегодня")
    @Test
    public void testAddWeddingEventWithNoRegisterPersonForToday(){
        LoginPage loginpage = new LoginPage();
        FeedPage feedPage = loginpage.login(username, password);

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
        eventPage.refreshCheckedPage();
        assertTrue("Тип праздника и имя человека отображаются верно", eventPage.isEventsConsistThatEvent(personName,eventType));
        //clean up
        eventPage.deleteEvent(personName,eventType);
    }
}
