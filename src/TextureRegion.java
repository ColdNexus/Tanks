import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TextureRegion {

    private static BufferedImage texture = null;


    public static BufferedImage[] CropRectangular(int startRow, int startColumn, int endRow, int endColumn){
        BufferedImage[] images = new BufferedImage[(endRow-startRow+1)*(endColumn-startColumn+1)];
        int cnt = 0;
        for (int i = startRow; i <= endRow; ++i){
            for(int j = startColumn; j <= endColumn; ++j){
                images[cnt] = texture.getSubimage( j * Map.BLOCK_SIZE, i * Map.BLOCK_SIZE  , Map.BLOCK_SIZE , Map.BLOCK_SIZE);
                cnt+=1;
            }
        }
        return images;
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
}
