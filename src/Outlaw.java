import java.util.ArrayList;

public class Outlaw extends Warriors {
    public Outlaw(ArrayList<BaseHero> myTeam, int x, int y) {
        super(myTeam, String.format("%02d", ++Outlaw.number), 10, 8, 3, new int[]{2, 4}, 6, x, y);
    }
}
