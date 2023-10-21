import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Editor implements MouseListener {

    private int block;
    private boolean IsBlock = false;
    public boolean editing = true;
    public void paint (Graphics g){
        if (editing) {
            g.fillRect(1300, 0, 250, 838);

            // заменить green на ground
            g.setColor(Color.lightGray);
            ImageHelper.paint(g, Map.BRICK, 1400, 50);
            ImageHelper.paint(g, Map.WALL, 1400, 100);
            ImageHelper.paint(g, Map.WATER, 1400, 150);
            ImageHelper.paint(g, Map.GREEN, 1400, 200);
            ImageHelper.paint(g, Map.ORANGE, 1400, 250);
            ImageHelper.paint(g, Map.WHITE, 1400, 300);
            ImageHelper.paint(g, Map.BUNKER, 1400, 350);
            ImageHelper.paint(g, Map.PURPLEBRICK, 1400, 400);
            ImageHelper.paint(g, Map.PURPLEWALL, 1400, 450);
            ImageHelper.paint(g, Map.ROCKET, 1400, 500);
            ImageHelper.paint(g, Map.AMMO, 1400, 550);
            g.drawImage(ImageHelper.editor, 1350, 600, null);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (editing) {
            int x = e.getX();
            int y = e.getY();
            //System.out.println(x+ " " + y);
            // заменить green на ground
            if (x >= 1400 && x <= 1432 && y >= 50 && y <= 82) {
                System.out.println("BRICK");
                block = Map.BRICK;
                IsBlock = true;
            } else if (x >= 1400 && x <= 1432 && y >= 100 && y <= 132) {
                System.out.println("WALL");
                block = Map.WALL;
                IsBlock = true;
            } else if (x >= 1400 && x <= 1432 && y >= 150 && y <= 182) {
                System.out.println("WATER");
                block = Map.WATER;
                IsBlock = true;
            } else if (x >= 1400 && x <= 1432 && y >= 200 && y <= 232) {
                System.out.println("GREEN");
                block = Map.GREEN;
                IsBlock = true;
            } else if (x >= 1400 && x <= 1432 && y >= 250 && y <= 282) {
                System.out.println("ORANGE");
                block = Map.ORANGE;
                IsBlock = true;
            } else if (x >= 1400 && x <= 1432 && y >= 300 && y <= 332) {
                System.out.println("WHITE");
                block = Map.WHITE;
                IsBlock = true;
            } else if (x >= 1400 && x <= 1432 && y >= 350 && y <= 382) {
                System.out.println("Bunker");
                block = Map.BUNKER;
                IsBlock = true;
            } else if (x >= 1400 && x <= 1432 && y >= 400 && y <= 432) {
                System.out.println("Purplebrick");
                block = Map.PURPLEBRICK;
                IsBlock = true;
            } else if (x >= 1400 && x <= 1432 && y >= 450 && y <= 482) {
                System.out.println("purplewall");
                block = Map.PURPLEWALL;
                IsBlock = true;
            } else if (x >= 1400 && x <= 1432 && y >= 500 && y <= 532) {
                System.out.println("rocket");
                block = Map.ROCKET;
                IsBlock = true;
            } else if (x >= 1400 && x <= 1432 && y >= 550 && y <= 582) {
                System.out.println("ammo");
                block = Map.AMMO;
                IsBlock = true;
            } else if (x >= 1350 && x <= 1500 && y >= 600 && y <= 675) {
                System.out.println("Generate New map");
                Map.generate(100, 100);
                IsBlock = false;
            } else if (x >= 1350 && x <= 1500 && y >= 675 && y <= 750) {
                System.out.println("all to grass");
                Map.AllToBlock(Map.GROUND);
                IsBlock = false;
            } else if (x >= 1350 && x <= 1500 && y >= 750 && y <= 825) {
                System.out.println("all to water");
                Map.AllToBlock(Map.WATER);
                IsBlock = false;
            }
            if (x >= 0 && x <= 1300 && y >= 0 && y <= 838) {
                Camera c = Camera.getInstance();
                if (IsBlock) {
                    Map.matrix.put(new Cell ((int) ((c.getY() + y) / 32),(int) ((c.getX() + x) / 32)), block);
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
