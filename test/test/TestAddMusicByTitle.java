package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import page.FeedPage;
import page.LoginPage;
import page.MusicLayerPage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;


@DisplayName("После логина добавленный трек из леера музыки отображается в музыке пользователя")
public class TestAddMusicByTitle extends BaseTest {
    private static String OKUsername = System.getProperty("OK.username", "technoPol27");
    private static String OKPassword = System.getProperty("OK.password", "technoPolis2022");
    private static String OKMusicRequest = System.getProperty("OK.musicRequest", "Звери - для тебя");
    private static String OKMusicName = System.getProperty("OK.musicName", "Для тебя");
    public static final String url = "https://ok.ru/";

    /*Тест, проверяющий сценарий:
    * Залогиниться на OK.ru,
    * зайти в раздел "Музыка",
    * найти песню "Звери - для тебя",
    * добавить его
    * и проверить, отображается ли трек во вкладке "Моя музыка"
    * */
    @DisplayName("Проверка сценария добавления юзером трека Звери - Для тебя после логина")
    @Test
    public void addMusicTest(){
        openPage(url);
        LoginPage loginpage = new LoginPage();
        FeedPage feedPage = new FeedPage();

        loginpage.login(OKUsername,OKPassword);

        MusicLayerPage musicLayerPage = feedPage.openMusicFromToolbar(); //возвращает MusicLayerPage
        musicLayerPage.searchMusic(OKMusicRequest)
        .addMusic()
        .openMyMusic();
        musicLayerPage.getMusicListElement()
            .shouldHave(text(OKMusicName))
            .shouldBe(visible);
    }

}
