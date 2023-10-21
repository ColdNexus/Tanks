import java.awt.*;
import java.awt.image.BufferedImage;

public class Animation {

    BufferedImage[] animation;
    private int x;
    private int y;
    private int frameLast;
    private int frameCurrent = 0;
    private int frameTime = 80;
    private int elapsedTime = 0;


    private boolean directSequence = true;
    private boolean reverseSequence = false;
    private boolean pingPong = false;

    private boolean pingPongDirect = true;

    private boolean infinitely = false;
    private int cnt = 1;

    private boolean isActive = true;

    public Animation(int x, int y) {
        this.animation = TextureRegion.CropRectangular(3, 4, 7,8);
        this.x = x;
        this.y = y;
        frameLast = animation.length - 1;
        makePingPongSequence();
    }

    public void paint (Graphics g) {
        if (isActive) {
            Camera c = Camera.getInstance();
            g.drawImage(animation[frameCurrent], c.getScreenX(x), c.getScreenY(y), null);
        }
    }

    public void update(int ms) {
        if (isActive) {
            elapsedTime += ms;
            if (elapsedTime >= frameTime) {
                nextFrame();
                elapsedTime = 0;
            }
        }

    }

    private void nextFrame() {
        if (cnt > 0 || infinitely) {
            if (directSequence) {
                frameCurrent++;
                if (frameCurrent > frameLast) {
                    frameCurrent = 0;
                    countDown();
                }
            }

            if (reverseSequence){
                frameCurrent--;
                if (frameCurrent < 0){
                    frameCurrent = frameLast;
                    countDown();
                }
            }

            if (pingPong){
                if (pingPongDirect){
                    frameCurrent++;
                    if (frameCurrent >= frameLast) {
                        pingPongDirect = false;
                        frameCurrent = frameLast;
                    }
                }else{
                    frameCurrent--;
                    if (frameCurrent <= 0){
                        countDown();
                        pingPongDirect = true;
                        frameCurrent = 0;
                    }
                }
            }

        }
    }

    private void countDown(){
        if (!infinitely){
            cnt--;
        }
        if (cnt == 0) isActive = false;
    }

    public void setFrameTime(int frameTime) {
        this.frameTime = frameTime;
    }

    public void makeDirectSequence(){
        directSequence = true;
        reverseSequence = false;
        pingPong = false;

        frameCurrent = 0;
    }

    public void makeReverseSequence(){
        reverseSequence = true;
        directSequence = false;
        pingPong = false;

        frameCurrent = frameLast;
    }

    public void makePingPongSequence(){
        pingPong = true;
        directSequence = false;
        reverseSequence = false;

        pingPongDirect = true;
        frameCurrent = 0;
    }

    public void setCounter(int cnt) {
        this.cnt = cnt;
    }

    public void setInfinitely(boolean infinitely) {
        this.infinitely = infinitely;
        if (infinitely) cnt = 1;
    }
}
