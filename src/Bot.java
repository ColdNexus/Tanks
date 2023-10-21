public abstract class Bot implements HitboxListener {

    Unit owner;



    public Bot (Unit owner) {
        this.owner = owner;
    }

    public abstract void onMapCollision(HitBoxEvent event) ;

    public void update (int ms) {

    }

}
