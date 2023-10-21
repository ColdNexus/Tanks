import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageHelper {

    private static boolean high = true;

    private static Color [] colors = new Color[] {Color.GREEN, Color.ORANGE, Color.LIGHT_GRAY, Color.BLUE };

    private static BufferedImage[] images = new BufferedImage[100];

    private static BufferedImage texture = null;

    public static BufferedImage editor = null;
    static  {
        if (editor == null) {
            try {
                editor = ImageIO.read(new File("editor.png"));
            } catch (IOException e) {
                System.out.println("Не смогли загрузить " + "editor.png");
                System.exit(1);
            }
        }
    }

    public static void cropImage (int row, int col, int block ) {
        BufferedImage miniImage = texture.getSubimage( col * Map.BLOCK_SIZE, row * Map.BLOCK_SIZE  , Map.BLOCK_SIZE , Map.BLOCK_SIZE) ;
        images[block] = miniImage;
    }

    public static void loadTexture (String fileName) {
        if (texture == null) {
            try {
                texture = ImageIO.read(new File(fileName));
            } catch (IOException e) {
                System.out.println("Не смогли загрузить " + fileName);
                System.exit(1);
            }
        }
    }

    public static void paint (Graphics g, int block, int screenX, int screenY) {
        if(high) {
            g.drawImage(images[block], screenX, screenY, null );
        }
        else {
            g.setColor(colors[block]);
            g.fillRect(screenX, screenY, Map.BLOCK_SIZE, Map.BLOCK_SIZE);
        }
    }

}
