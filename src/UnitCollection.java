import java.awt.*;
import java.util.ArrayList;

public class UnitCollection {

    private static final int initialBots = 100;
    private static ArrayList <Unit> units = new ArrayList<>(initialBots);


    public static Unit getTargetUnit(Unit predator) {

        double minDistance = Double.MAX_VALUE;
        Unit curVictim = null;
        for (Unit victim  : units ) {
            if (victim.getTeam() != predator.getTeam()) {
                double d = Point.distance(predator.getX(), predator.getY(), victim.getX(), victim.getY());
                if (d < minDistance) {
                    minDistance = d;
                    curVictim = victim;
                }
            }
        }
        return curVictim;

    }


    static {
        for (int i = 0; i < initialBots; i++) {
            spawn(i%2);
        }
    }

    public static void add (Unit u) {
        units.add(u);
    }

    public static void spawn (int team) {
        units.add(new Tank(Map.BLOCK_SIZE * 10, Map.BLOCK_SIZE * 10, team));
    }

    public static void update (int ms) {
        for (int i = units.size() - 1; i >= 0; i--) {
            Unit u = units.get(i);
            if (!u.isActive()) {
                units.remove(i);
            }
            else {
                u.update(ms);
            }
        }
    }

    public static void paint (Graphics g) {
        for (Unit t : units ) {
            t.paint(g);
        }
    }





}
