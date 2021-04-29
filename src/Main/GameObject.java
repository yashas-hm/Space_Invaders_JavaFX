package Main;

import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class GameObject extends Rectangle {
    final String type;
    boolean dead = false;
    ImagePattern imagePattern;
    boolean isExploding = false;
    double speed;

    // change directory to where your project is stored
    static final String directory = "D:\\Programming\\JAVA\\";

    // do not change this
    static final String projectDirectory = "Space_Invaders_JavaFX\\src\\Main\\images\\";
    
    private static final Image[] images = {
            new Image("file:"+directory+projectDirectory+"explosion_0.png"),
            new Image("file:"+directory+projectDirectory+"explosion_1.png"),
            new Image("file:"+directory+projectDirectory+"explosion_2.png"),
            new Image("file:"+directory+projectDirectory+"explosion_3.png"),
            new Image("file:"+directory+projectDirectory+"explosion_4.png"),
            new Image("file:"+directory+projectDirectory+"explosion_5.png"),
            new Image("file:"+directory+projectDirectory+"explosion_6.png"),
            new Image("file:"+directory+projectDirectory+"explosion_7.png"),
            new Image("file:"+directory+projectDirectory+"explosion_8.png"),
            new Image("file:"+directory+projectDirectory+"explosion_9.png"),
            new Image("file:"+directory+projectDirectory+"explosion_10.png"),
            new Image("file:"+directory+projectDirectory+"explosion_11.png"),
            new Image("file:"+directory+projectDirectory+"explosion_12.png"),
            new Image("file:"+directory+projectDirectory+"explosion_13.png"),
            new Image("file:"+directory+projectDirectory+"explosion_14.png"),
    };

    GameObject(int x, int y, int w, int h, String type, Image image, double speed) {
        super(w, h, Color.TRANSPARENT);
        imagePattern = new ImagePattern(image);
        super.setFill(imagePattern);
        this.type = type;
        setTranslateX(x);
        setTranslateY(y);
        this.speed = speed;
    }

    public void blast() {
        Transition animation = new Transition() {
            {
                setCycleDuration(Duration.millis(1000));
            }

            @Override
            protected void interpolate(double fraction) {
                int step = (int) (fraction * 14);
                imagePattern = new ImagePattern(images[step]);
                setFill(imagePattern);
                if (step >= 14) {
                    dead = true;
                }
            }
        };
        animation.play();
    }

    public void moveLeft() {
        if (getTranslateX() > 0 && !isExploding)
            setTranslateX(getTranslateX() - 5);
    }

    public void moveRight() {
        if (getTranslateX() < 530 && !isExploding)
            setTranslateX(getTranslateX() + 5);
    }

    public void moveUp() {
        if (getTranslateY() > 0)
            setTranslateY(getTranslateY() - 5);
        else
            dead = true;
    }

    public void setXAxis(double x) {
        if (0 < x && x < 530 && !isExploding)
            setTranslateX(x);
    }

    public void moveDown() {
        if (!isExploding && getTranslateY() < 780)
            setTranslateY(getTranslateY() + speed);
        else if (getTranslateY() > 780)
            dead = true;
    }
}
