import java.util.ArrayList;

public class Sniper extends Shooters {

    public Sniper(ArrayList<BaseHero> myTeam, int x, int y) {
        super(myTeam, String.format("%02d", ++Sniper.number), 15, 12, 10, new int[]{8, 10}, 9, 32, x, y);
    }
}