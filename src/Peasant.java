import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Peasant extends BaseHero {
    private int delivery;

    public Peasant(ArrayList<BaseHero> myTeam, int x, int y) {
        super(myTeam, String.format("%02d", ++Peasant.number), 1, 1, 1, new int[]{0, 1}, 3, x, y);
        this.delivery = 1;
    }

    @Override
    public String toString() {
        return String.format("%s %s %-7s", super.toString(), "\uD83E\uDD19", delivery);
    }

    public void step(ArrayList<BaseHero> teamList) {
        if (this.hp == 0) {
            System.out.println(AnsiColors.ANSI_RED + this.name + " " + this.getClass().getSimpleName() + " is dead ❌☠️" + AnsiColors.ANSI_RESET);
        } else {
            Map<Integer, Integer> mapInfoShot = new HashMap<>();
            for (int i = 0; i < myTeam.size(); i++) {
                if (myTeam.get(i) instanceof Sniper && ((Shooters) myTeam.get(i)).shots < ((Shooters) myTeam.get(i)).maxShots ||
                        myTeam.get(i) instanceof Crossbowman && ((Shooters) myTeam.get(i)).shots < ((Shooters) myTeam.get(i)).maxShots) {
                    mapInfoShot.put(i, Integer.parseInt(((Shooters) myTeam.get(i)).getInfoShots()));
                }
            }
            if (!mapInfoShot.isEmpty()) {
                int minShotPlayer = Collections.min(mapInfoShot.values());
                for (Map.Entry<Integer, Integer> entry : mapInfoShot.entrySet()) {
                    if (entry.getValue() == minShotPlayer) {
                        ((Shooters) myTeam.get(entry.getKey())).shots += 1;
                        System.out.println(this.name + " " + this.getClass().getSimpleName() + " give arrow \uD83C\uDF7A " + myTeam.get(entry.getKey()));
                        break;
                    }
                }
            } else {
                System.out.println(this.name + " " + this.getClass().getSimpleName() + " \uD83D\uDE34");
            }
        }
    }
}
