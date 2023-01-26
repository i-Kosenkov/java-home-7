import java.util.ArrayList;

public class Crossbowman extends Shooters {

    public Crossbowman(ArrayList<BaseHero> myTeam, int x, int y) {
        super(myTeam, String.format("%02d", ++Crossbowman.number), 6, 3, 10, new int[]{2, 3}, 4, 16, x, y);
    }
}