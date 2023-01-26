import java.util.ArrayList;

public class Magician extends Healers {
    public Magician(ArrayList<BaseHero> myTeam, int x, int y) {
        super(myTeam, String.format("%02d", ++Magician.number), 30, 17, 12, new int[]{-5, 0}, 9, 1, x, y);
    }
}