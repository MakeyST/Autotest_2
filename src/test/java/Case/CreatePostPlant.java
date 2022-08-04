package Case;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
public class CreatePostPlant {
    public void createPostPlant(){
String Zagolovok = "Заголовок поле";
String Text = "Текст поле";
     $x("//button [@class=\"button green-button write-post-button feed-header_button__SDGRe\"]").click();
     $(".pecialization-agronomy").click();
     $("#post-writer-title-input").setValue(Zagolovok);
     $("#post-writer-text").setValue(Text);
     $("#post-writer-save").click();
    }
}
