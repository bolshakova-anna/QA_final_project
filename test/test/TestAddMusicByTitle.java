package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import page.FeedPage;
import page.LoginPage;
import page.MusicLayerPage;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.junit.Assert.assertTrue;


@DisplayName("После логина добавленный трек из леера музыки отображается в музыке пользователя")
public class TestAddMusicByTitle extends BaseTest {
    private static final String OKUsername = System.getProperty("OK.username", "technoPol27");
    private static final String OKPassword = System.getProperty("OK.password", "technoPolis2022");
    private static final String OKMusicRequest = System.getProperty("OK.musicRequest", "Звери - для тебя");
    private static final String OKMusicName = System.getProperty("OK.musicName", "Для тебя");

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
        LoginPage loginpage = new LoginPage();
        FeedPage feedPage = loginpage.login(OKUsername,OKPassword);
        MusicLayerPage musicLayerPage = feedPage.openMusicFromToolbar(); //возвращает MusicLayerPage
        musicLayerPage.searchMusic(OKMusicRequest)
        .addMusic()
        .openMyMusic();
        assertTrue("Тип праздника и имя человека отображаются верно", musicLayerPage.isMusicListContain(OKMusicName));
    }

}
