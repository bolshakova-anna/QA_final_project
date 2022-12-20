package page;

import static com.codeborne.selenide.Selenide.refresh;


public abstract class BasePage<T> {

    public BasePage() {
        check();
    }

    protected abstract void check();

    public void refreshCheckedPage(){
        check();
        refresh();
    }
}
