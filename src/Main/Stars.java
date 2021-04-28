package Main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Stars extends Circle {
    boolean dead = false;

    Stars(int x, int y, int r, double opacity){
        super(x,y,r, Color.WHITE);
        super.setOpacity(opacity);
    }

    void moveDown() {
        setTranslateY(getTranslateY() + 2);
        if(getTranslateY()>800)
            dead=true;
    }
}
