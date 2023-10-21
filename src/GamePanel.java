import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Console;

import javax.swing.JPanel;

public class GamePanel extends JPanel  {

    long t1, t2;
    KeyState keyState;
    Editor editor;

    Animation a = new Animation(100, 100);

    public GamePanel(KeyState keyState, Editor editor) {
        this.keyState = keyState;
        this.editor = editor;
        setBackground(Color.BLACK );
        t1 = System.currentTimeMillis();
        Camera c = Camera.getInstance();
        c.setH(getHeight());
        c.setW(getWidth());
    }

    private void updateGame(int ms) {
        Camera c = Camera.getInstance();
        c.update(ms);
        a.update(ms);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        t2 = System.currentTimeMillis();
        int ms = (int)(t2 - t1);

        controlGame();
        updateGame(ms);

        Map.paint(g);
        editor.paint(g);

        a.paint(g);
        t1 = t2;
        repaint();
    }

    private void controlGame (){
        Camera c = Camera.getInstance();
        c.stop();
        if (keyState.isKeyDown(KeyEvent.VK_D) && keyState.isKeyDown(KeyEvent.VK_W)){
            c.move(-Math.PI/4);
        }else if (keyState.isKeyDown(KeyEvent.VK_D) && keyState.isKeyDown(KeyEvent.VK_S)){
            c.move(Math.PI/4);
        }else if (keyState.isKeyDown(KeyEvent.VK_A) && keyState.isKeyDown(KeyEvent.VK_W)){
            c.move(-Math.PI*3/4);
        }else if (keyState.isKeyDown(KeyEvent.VK_A) && keyState.isKeyDown(KeyEvent.VK_S)){
            c.move(Math.PI*3/4);
        }else if (keyState.isKeyDown(KeyEvent.VK_A)){
            c.move(Math.PI);
        }else if (keyState.isKeyDown(KeyEvent.VK_D)){
            c.move(0);
        }else if (keyState.isKeyDown(KeyEvent.VK_W)){
            c.move(-Math.PI/2);
        }else if (keyState.isKeyDown(KeyEvent.VK_S)){
            c.move(Math.PI/2);
        }
        if (keyState.isKeyDown(KeyEvent.VK_ESCAPE)){
            System.exit(0);
        }
        if (keyState.isKeyDown(KeyEvent.VK_ENTER)){
            editor.editing = false;
        }
    }

}
