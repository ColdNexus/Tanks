public class StupidBot extends Bot {

    Unit tagret = null;

    public StupidBot(Unit owner) {
        super(owner);
    }

    @Override
    public void update(int ms) {
        super.update(ms);
        int orient = (int)(Math.random() * 100);
        if (orient == 0) {
            randomOrientation();
        }
        else if(orient > 95) {
            tagret = UnitCollection.getTargetUnit(owner);
            followTarget();
        }

    }

    private void followTarget() {
        if(tagret == null) {
            return;
        }


    }

    @Override
    public void onMapCollision(HitBoxEvent event) {
        randomOrientation();
    }

    private void randomOrientation() {
        int orient = (int)(Math.random() * 4);
        owner.setOrientation(orient * Math.PI/2);
    }
}
