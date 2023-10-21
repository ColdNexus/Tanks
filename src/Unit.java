import java.awt.*;

public class Unit implements HitboxListener {

    Sprite master;
    Sprite slave;
    Hitbox hb;
    Bot    bot;

    public static final int RED = 0;
    public static final int BLUE = 1;

    int team;

    boolean active = true;

    public int getTeam() {
        return team;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void stop() {
        master.stop();
    }

    public void setOrientation(double alpha) {
        master.go();
        master.setAlpha(alpha);
    }

    public void up() {
        master.go();
        master.setAlpha(-Math.PI/2);
    }
    public void down() {
        master.go();
        master.setAlpha(Math.PI/2);
    }
    public void left() {
        master.go();
        master.setAlpha(Math.PI);
    }
    public void right() {
        master.go();
        master.setAlpha(0);
    }


    public double getX() {
        return master.getX();
    }

    public double getY() {
        return master.getY();
    }

    public Unit (Sprite master, Sprite slave, int team) {
        this (master, slave);
        this.team = team;
    }

    public Unit (Sprite master, Sprite slave) {
        this.master = master;
        this.slave = slave;
        this.hb = new Hitbox(this, master, 2);
        this.bot = new StupidBot(this);
        this.team = 0;
    }

    public void update (int ms) {
        master.update(ms);
        slave.update(ms);
        hb.update();
        bot.update(ms);
        slave.setX(master.getX());
        slave.setY(master.getY());
    }

    public void paint (Graphics g) {
        master.paint(g);
        slave.paint(g);
    }

    @Override
    public void onMapCollision(HitBoxEvent e) {
        if (e.getBlock() == Map.WATER) {

        }
        else {
            master.unDo();
            bot.onMapCollision(e);

        }
        // slave берет координаты мастера
    }
}
