import java.awt.*;

public class Sprite {

    int frameFirst;
    int frameLast;
    int frameCurrent;
    int frameTime = 80;
    int elapsedTime = 0;
    double speed, alpha, _speed;
    double x, y, _x, _y;

    public void stop() {
        if (speed > 0) {
            _speed = speed;
            speed = 0;
        }
    }
    public void go() {
        speed = _speed ;
    }

    public double getAlpha() {
        return alpha;
    }

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }



    public Sprite(int frameFirst, int frameLast, int frameTime, double speed, double alpha, double x, double y) {
        this.frameFirst = frameFirst;
        this.frameLast = frameLast;
        this.frameCurrent = frameFirst;
        this.frameTime = frameTime;
        this.speed = speed;
        this._speed = speed;
        this.alpha = alpha;
        this.x = x;
        this.y = y;
    }

    public void paint (Graphics g) {
        Camera c = Camera.getInstance();

        ImageHelper.paint(g,frameCurrent, c.getScreenX(x), c.getScreenY(y) );
    }

    public void update(int ms) {
        _x = x;
        _y = y;
        x += speed * Math.cos(alpha) * ms/1000.0;
        y += speed * Math.sin(alpha) * ms/1000.0;

        elapsedTime += ms;
        if(elapsedTime >= frameTime) {
            nextFrame();
            elapsedTime = 0;
        }

    }

    private void nextFrame() {
        frameCurrent ++;
        if (frameCurrent > frameLast) {
            frameCurrent = frameFirst;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void unDo() {
        x = _x;
        y = _y;
    }
}
