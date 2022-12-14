package page;

import static com.codeborne.selenide.Selenide.refresh;


public abstract class BasePage<T> {

    protected abstract void check();

    public void refreshPage(){
        refresh();
    }
}
