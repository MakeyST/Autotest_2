package regressdirectfarm;

import AttachFile.Attach;
import Authorization.Authorization;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.description;
import static io.qameta.allure.Allure.step;

public class RegressDirectFarm {

    @BeforeEach
    public void setup(){
        description("LoggerAllure включен");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        SelenideLogger.addListener("allure", new AllureSelenide());

        description("Вызываю метод из другого класса");
        DesiredCapabilities capabilities = new DesiredCapabilities();


        description("Возможности(Запись)");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        description("Конфигурация системы");
        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://test.direct.farm";
        open("/");
        Configuration.browserSize = "1920x1080";
        /*Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";*/

        description("Аттачи в Allure");
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();


    }


    @DisplayName("Авторизация")
    @Test
    public void authorization(){
        Authorization signin = new Authorization();
        SelenideLogger.addListener("allure", new AllureSelenide());
       step("Запуск Авторизации", () -> {
            signin.authorization();
            Allure.getLifecycle().addAttachment("Screnshot", "image/png", "png",
                    ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES));
        });
    }
}
