import java.awt.*;
import java.util.HashMap;
import java.util.Random;

public class Map {

    //public static int [][] matrix;
    private static Random r;
    public static java.util.Map<Cell, Integer> matrix = new HashMap<>();
    public static BlockReader br = new BlockReader();

    public static final int GROUND     = 0;
    public static final int BRICK      = 1;
    public static final int WALL       = 2;
    public static final int WATER      = 3;
    public static final int EMPTY      = 4;
    public static final int WHITE      = 5;
    public static final int ORANGE     = 6;
    // заменить green на ground
    public static final int GREEN      = 7;
    public static final int BUNKER     = 8;
    public static final int PURPLEBRICK= 9;
    public static final int PURPLEWALL = 10;
    public static final int ROCKET     = 11;
    public static final int AMMO       = 12;
    public static final int BLOCK_SIZE = 32;

    public static int _X_;
    public static int _Y_;

    private Map () {

    }

    static {
        r = new Random();
    }

    public static void generate(int yyy, int xxx) {
        matrix = new HashMap<>();
        _X_ = xxx;
        _Y_ = yyy;
        for (int col = 0; col < xxx; col++ ) {
            matrix.put(new Cell (yyy/2, col), br.set(0, BRICK, 0));

            matrix.put(new Cell (yyy/2+1, col), br.set(0, BRICK, 0));

            matrix.put(new Cell (0, col), br.set(0, WALL, 0));

            matrix.put(new Cell (yyy-1, col), br.set(0, WALL, 0));
        }
        for (int i = 0; i < yyy; i++){
            matrix.put(new Cell (i, 0), br.set(0, WALL, 0));

            matrix.put(new Cell (i, xxx - 1), br.set(0, WALL, 0));
        }

        matrix.put(new Cell(yyy/2, xxx-1), br.set(0, WALL, 0));

        matrix.put(new Cell(yyy/2+1, xxx-1), br.set(0, WALL, 0));


        int[][] pool = {
                {0, 3, 3, 3, 0},
                {3, 3, 3, 3, 3},
                {3, 3, 3, 3, 3},
                {0, 3, 3, 3, 0}
        };
        int n = 10;
        for (int k = 0; k < n; ++k){
            int cordx = r.nextInt(xxx - 2 - 6) + 1;
            int cordy = r.nextInt(yyy - 2 - 5) + 1;
            for (int i = cordy, a = 0; a < pool.length; ++i, ++a){
                for (int j = cordx, b = 0; b < pool[a].length; ++j, ++b){
                    if (pool[a][b] != GROUND) matrix.put(new Cell(i, j), br.set(0, pool[a][b], 0));
                }
            }
        }
        int[][] barricade = {
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0}
        };
        n = 10;
        for (int k = 0; k < n; ++k){
            int cordx = r.nextInt(xxx - 2 - 6) + 1;
            int cordy = r.nextInt(yyy - 2 - 6) + 1;
            for (int i = cordy, a = 0; a < barricade.length; ++i, ++a){
                for (int j = cordx, b = 0; b < barricade[a].length; ++j, ++b){
                    if (barricade[a][b] != GROUND) matrix.put(new Cell(i, j), br.set(0, barricade[a][b], 0));
                }
            }
        }
        int[][] river = {
                {3, 0, 0, 0, 0},
                {3, 3, 0, 0, 0},
                {0, 3, 3, 0, 0},
                {0, 0, 3, 3, 3},
                {0, 0, 0, 0, 3}
        };
        n = 10;
        for (int k = 0; k < n; ++k){
            int cordx = r.nextInt(xxx - 2 - 6) + 1;
            int cordy = r.nextInt(yyy - 2 - 6) + 1;
            for (int i = cordy, a = 0; a < river.length; ++i, ++a){
                for (int j = cordx, b = 0; b < river[a].length; ++j, ++b){
                    if (river[a][b] != GROUND) matrix.put(new Cell(i, j), br.set(0, river[a][b], 0));
                }
            }
        }
        int[][] wallOfBricks = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1}
        };
        n = 10;
        for (int k = 0; k < n; ++k){
            int cordx = r.nextInt(xxx - 2 - 10) + 1;
            int cordy = r.nextInt(yyy - 2 - 6) + 1;
            for (int i = cordy, a = 0; a < wallOfBricks.length; ++i, ++a){
                for (int j = cordx, b = 0; b < wallOfBricks[a].length; ++j, ++b){
                    if (wallOfBricks[a][b] != GROUND) matrix.put(new Cell(i, j), br.set(0, wallOfBricks[a][b], 0));
                }
            }
        }
        int[][] bricks = {
                {1, 0, 1, 0, 1},
                {0, 1, 1, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 1, 1, 1, 0},
                {1, 0, 1, 0, 1}
        };
        n = 10;
        for (int k = 0; k < n; ++k){
            int cordx = r.nextInt(xxx - 2 - 6) + 1;
            int cordy = r.nextInt(yyy - 2 - 6) + 1;
            for (int i = cordy, a = 0; a < bricks.length; ++i, ++a){
                for (int j = cordx, b = 0; b < bricks[a].length; ++j, ++b){
                    if (bricks[a][b] != GROUND) matrix.put(new Cell(i, j), br.set(0, bricks[a][b], 0));
                }
            }
        }
        int[][] box = {
                {0, 1, 1, 1, 0},
                {1, 0, 1, 0, 1},
                {1, 1, 0, 1, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 1, 0}
        };
        n = 10;
        for (int k = 0; k < n; ++k){
            int cordx = r.nextInt(xxx - 2 - 6) + 1;
            int cordy = r.nextInt(yyy - 2 - 6) + 1;
            for (int i = cordy, a = 0; a < box.length; ++i, ++a){
                for (int j = cordx, b = 0; b < box[a].length; ++j, ++b){
                    if (box[a][b] != GROUND) matrix.put(new Cell(i, j), br.set(0, box[a][b], 0));
                }
            }
        }
    }

    public static int getBlock (int row, int col) {
        if (matrix.get(new Cell(row, col)) == null){
            return GROUND;
        }
        return matrix.get(new Cell(row, col));
    }

    public static int getRowByY (double yW) {
        return (int)yW / BLOCK_SIZE;
    }
    public static int getColByX (double xW) {
        return (int)xW / BLOCK_SIZE;
    }

    public static void paint(Graphics g) {

        int row1, row2, col1, col2;

        Camera c = Camera.getInstance();
        row1 = getRowByY (c.getY());
        col1 = getColByX (c.getX());

        row2 = row1 + c.sizey;
        col2 = col1 + c.sizex;

        int x, y;
        for (int row = row1; row <= row2; row++) {
            for (int col = col1; col <= col2; col++) {
                int block = getBlock(row, col);
                if (block == EMPTY) {
                    continue;
                }
                x = BLOCK_SIZE * col;
                y = BLOCK_SIZE * row;
                for (int i = 3; i >=0 ; --i) {
                    ImageHelper.paint(g, br.get(i, block), c.getScreenX(x), c.getScreenY(y));
                }
            }
        }
    }
    public static void AllToBlock(int block){
        matrix.clear();
        for (int i = 0; i < _X_; ++i){
            for (int j = 0; j < _Y_; ++j){
                if (block != GROUND) matrix.put(new Cell (i, j), block);
            }
        }
    }
}
