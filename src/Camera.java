public class Camera {

    static Camera instance = null;
    private int speed = 300;
    private int speed_ = 300;
    private double angle = 0;

    public int sizex = 100;
    public int sizey = 50;

    public static Camera getInstance () {
        if (instance == null) {
            instance = new Camera();
        }
        return instance;
    }

    private Camera () {

    }


    private  double x = 0, y = 0;
    private  int w, h;

    public  double getX() {
        return x;
    }

    public  double getY() {
        return y;
    }

    public  int getW() {
        return w;
    }

    public  void setW(int w) {
        this.w = w;
    }

    public  int getH() {
        return h;
    }

    public  void setH(int h) {
        this.h = h;
    }

    public  int getScreenY(double yW) {
        return (int)(yW - y);
    }

    public  int getScreenX(double xW) {
        return (int)(xW - x);
    }

    public  void move (double dx, double dy) {
        setPosition(x + dx, y + dy);
    }

    public  void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void stop (){
        speed = 0;
    }

    public void update(int ms){
        go(angle, ms);
    }
    public void move (double angle){
        this.angle = angle;
        speed = speed_;
    }
    public void  go (double angle, int ms){
        double dx, dy;

        dx = speed * Math.cos(angle) * ms/1000.0;
        dy = speed * Math.sin(angle) * ms/1000.0;
        x = x + dx;
        y = y + dy;
    }

    public void setSizex(int sizex) {
        this.sizex = sizex;
    }

    public void setSizey(int sizey) {
        this.sizey = sizey;
    }
}
