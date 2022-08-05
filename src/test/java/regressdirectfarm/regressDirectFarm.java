package regressdirectfarm;

import AttachFile.Attach;
import Authorization.Authorization;
import Case.CommentPostPlant;
import Case.CreatePostPlant;
import Case.DeletePostPlant;
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

public class regressDirectFarm {

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
           Attach.browserConsoleLogs();
        });
    }

    @DisplayName("Растениеводство создание поста")
    @Test
    public void createPostPlant(){
        CreatePostPlant cpt = new CreatePostPlant();
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Создание поста Растениеводство", () -> {
        cpt.createPostPlant();
            Allure.getLifecycle().addAttachment("Screnshot", "image/png", "png",
                    ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES));
            Attach.browserConsoleLogs();
        });
        }

    @DisplayName("Растениеводство создание комментария")
    @Test
    public void commentPostPlant(){
        CommentPostPlant cpt = new CommentPostPlant();
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Создание комментария в моем посте", () -> {
        cpt.commentPostPlant();
            Allure.getLifecycle().addAttachment("Screnshot", "image/png", "png",
                    ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES));
            Attach.browserConsoleLogs();
        });
    }
    
    @DisplayName("Растениеводство удаление")
    @Test
    public void deletePostPlant(){
        DeletePostPlant dpt = new DeletePostPlant();
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Удаление поста Растениеводство", () -> {
        dpt.deletePostPlant();
            Allure.getLifecycle().addAttachment("Screnshot", "image/png", "png",
                    ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES));
            Attach.browserConsoleLogs();
        });
    }
}



