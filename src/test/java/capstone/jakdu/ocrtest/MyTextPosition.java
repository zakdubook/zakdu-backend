package capstone.jakdu.ocrtest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MyTextPosition {
    public MyTextPosition(float fontSize, float x, String text) {
        this.fontSize = fontSize;
        this.x = x;
        this.text = text;
    }

    public MyTextPosition(float x, float y, float endX, float fontSize, float height, String text, int id) {
        this.x = x;
        this.y = y;
        this.endX = endX;
        this.fontSize = fontSize;
        this.height = height;
        this.text = text;
        this.id = id;
    }

    float x;
    float y;
    float endX;
    float fontSize;
    float height;
    String text;
    int id;
    int prefixId;
    int hierarchyNum;

}
