import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window () {

        setUndecorated(true);
        setExtendedState( MAXIMIZED_BOTH );
        setVisible(true);
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        this.setSize(1550, 838);

        KeyState keyState = new KeyState();
        addKeyListener(keyState);

        Editor editor = new Editor();
        addMouseListener(editor);

        GamePanel panel = new GamePanel(keyState, editor);

        add(panel);

        revalidate();
    }
}
