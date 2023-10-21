public class Main {

    public static void main(String[] args) {

        ImageHelper.loadTexture("sprite.png");
        TextureRegion.loadTexture("sprite.png");
        ImageHelper.cropImage(0, 2, Map.GROUND);
        ImageHelper.cropImage(0, 3, Map.WATER);
        ImageHelper.cropImage(0, 0, Map.WHITE);
        ImageHelper.cropImage(0, 1, Map.ORANGE);
        // заменить green на ground
        ImageHelper.cropImage(0, 2, Map.GREEN);
        ImageHelper.cropImage(1, 1, Map.BRICK);
        ImageHelper.cropImage(1, 0, Map.WALL);
        ImageHelper.cropImage(1, 4, Map.BUNKER);
        ImageHelper.cropImage(1, 2, Map.PURPLEBRICK);
        ImageHelper.cropImage(1, 3, Map.PURPLEWALL);
        ImageHelper.cropImage(4, 3, Map.ROCKET);
        ImageHelper.cropImage(4, 2, Map.AMMO);

        Map.generate(100, 100);
        new Window();

    }
}
