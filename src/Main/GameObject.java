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

    private static final Image[] images = {
            new Image("file:D:\\Programming\\JAVA\\Space Invaders\\src\\Main\\images\\explosion_0.png"),
            new Image("file:D:\\Programming\\JAVA\\Space Invaders\\src\\Main\\images\\explosion_1.png"),
            new Image("file:D:\\Programming\\JAVA\\Space Invaders\\src\\Main\\images\\explosion_2.png"),
            new Image("file:D:\\Programming\\JAVA\\Space Invaders\\src\\Main\\images\\explosion_3.png"),
            new Image("file:D:\\Programming\\JAVA\\Space Invaders\\src\\Main\\images\\explosion_4.png"),
            new Image("file:D:\\Programming\\JAVA\\Space Invaders\\src\\Main\\images\\explosion_5.png"),
            new Image("file:D:\\Programming\\JAVA\\Space Invaders\\src\\Main\\images\\explosion_6.png"),
            new Image("file:D:\\Programming\\JAVA\\Space Invaders\\src\\Main\\images\\explosion_7.png"),
            new Image("file:D:\\Programming\\JAVA\\Space Invaders\\src\\Main\\images\\explosion_8.png"),
            new Image("file:D:\\Programming\\JAVA\\Space Invaders\\src\\Main\\images\\explosion_9.png"),
            new Image("file:D:\\Programming\\JAVA\\Space Invaders\\src\\Main\\images\\explosion_10.png"),
            new Image("file:D:\\Programming\\JAVA\\Space Invaders\\src\\Main\\images\\explosion_11.png"),
            new Image("file:D:\\Programming\\JAVA\\Space Invaders\\src\\Main\\images\\explosion_12.png"),
            new Image("file:D:\\Programming\\JAVA\\Space Invaders\\src\\Main\\images\\explosion_13.png"),
            new Image("file:D:\\Programming\\JAVA\\Space Invaders\\src\\Main\\images\\explosion_14.png"),
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
