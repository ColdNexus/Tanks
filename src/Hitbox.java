import java.awt.*;

public class Hitbox {
    private HitboxListener listener;
    private Sprite owner;
    private int padding;
    private int [] blackList = new int[] {Map.WALL, Map.BRICK, Map.WATER};

    public Hitbox(HitboxListener listener, Sprite owner, int padding) {
        this.listener = listener;
        this.owner = owner;
        this.padding = padding;
    }

    public void update () {
        checkMapCollision();

    }


    private void checkMapCollision() {

        Point [] points = getCornerPoints();

        for (int i = 0; i < points.length ; i++) {

            Point p = points[i];
            int row = Map.getRowByY(p.getY());
            int col = Map.getColByX(p.getX());
            int block = Map.getBlock(row, col);

            for (int curBlock   : blackList ) {
                if (curBlock == block) {

                    HitBoxEvent event = new HitBoxEvent(p.getX(), p.getY(), block);

                    listener.onMapCollision(event);
                    return;
                }
            }
        }

    }

    private Point [] getCornerPoints() {
        double x0, y0;
        x0 = owner.getX() + padding;
        y0 = owner.getY() + padding;

        Point p0 = new Point((int)x0, (int)y0);

        Point [] points = new Point[] {p0};

        return points;
    }


}
