import java.text.DecimalFormat;
import java.util.ArrayList;

public class Spearman extends Warriors {
    public Spearman(ArrayList<BaseHero> myTeam, int x, int y) {
        super(myTeam, String.format("%02d", ++Spearman.number), 10, 4, 5, new int[]{1, 3}, 4, x, y);
    }
}
