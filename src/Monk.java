import java.util.ArrayList;

public class Monk extends Healers {

    public Monk(ArrayList<BaseHero> myTeam, int x, int y) {
        super(myTeam, String.format("%02d", ++Monk.number), 30, 12, 7, new int[]{-4, 0}, 5, 1, x, y);
    }
}