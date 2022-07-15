package regressdirectfarm;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepAnnotated {

    @Step("Открытие сайта test.direct.farm")
    public void openDirectFarm() {
            open("https://test.direct.farm/");

    }

/*    @Step("Параметры запуска Selenide")
    public void parameters(){




    }

    @Step("Авторизация на площадке")
    public void authorization(){


    }*/




}
