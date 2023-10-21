public class Tank extends Unit {



    public Tank (int x, int y, int team) {
        super(new Sprite(10+team*20, 19+team*20, 80, Map.BLOCK_SIZE*2,0, x, y),
                new Sprite(20+team*20, 20+team*20, 80, Map.BLOCK_SIZE*2,0, x, y),
                team
        );


    }


}
