package regressdirectfarm;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class RegressDirectFarm {

    @Test
    public void regressDirectFarm(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Запуск настроек и сайта", () -> {
            StepAnnotated start = new StepAnnotated();
            /*start.authorization();
            start.parameters();*/
            start.openDirectFarm();
            Allure.getLifecycle().addAttachment("Screnshot", "image/png", "png",
                    ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES));
        });
    }


    @Test
    public void createPostplantRegress(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Запуск создания поста Растениеводство", () ->{
            CreatePostPlant plant = new CreatePostPlant();
            plant.createPostPlant();
            Allure.getLifecycle().addAttachment("Screnshot", "image/png", "png",
                    ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES));
        });
    }
}
