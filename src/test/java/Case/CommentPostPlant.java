package Case;

import static com.codeborne.selenide.Selenide.$;
public class CommentPostPlant {
    public void commentPostPlant(){
String CommentText = "Мой комментарий";
        $("#comment-writer-field").setValue(CommentText);

    }
}
