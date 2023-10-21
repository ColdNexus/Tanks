public class HitBoxEvent {

    private double x, y;
    private int    block;

    public HitBoxEvent(double x, double y, int block) {
        this.x = x;
        this.y = y;
        this.block = block;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }
}
