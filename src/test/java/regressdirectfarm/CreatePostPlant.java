package regressdirectfarm;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CreatePostPlant {
    @Step("Создание поста Растениеводство")
    public void createPostPlant(){
        $(".write-post-button").click();
    }
}
