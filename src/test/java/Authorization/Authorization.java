package Authorization;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Authorization {

    @BeforeAll
    public void authorization() {
        $(".df-button").click();
    }
}
