package Authorization;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class Authorization {
String LoginMail = "i.makeenkov@direct.farm";
String LoginPassword = "12345678";
    @BeforeAll
    public void authorization() {
        $(".df-button").click();
        $("#modal-signin-button").click();
        $("#signin-email").setValue(LoginMail);
        $x("//button [@class=\"button _main green-button\"]").click();
        $("#signin-password").setValue(LoginPassword);
        $x("//button [@class=\"button _main m-b-20\"]").click();
    }
}
