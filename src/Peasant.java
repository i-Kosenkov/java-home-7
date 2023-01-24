import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Peasant extends BaseHero {
    private int delivery;

    public Peasant() {
        super(String.format("%d", ++Peasant.number), 1, 1, 1, new int[]{0, 1}, 3);
        this.delivery = 1;
    }

    @Override
    public String toString() {
        return super.toString() + " Delivery: " + delivery;
    }

    public void step(ArrayList<BaseHero> teamList) {
        Map<Integer, Integer> mapInfoShot = new HashMap<>();
        for (int i = 0; i < teamList.size(); i++) {
            if (teamList.get(i) instanceof Sniper && ((Shooters) teamList.get(i)).shots < ((Shooters) teamList.get(i)).maxShots ||
                    teamList.get(i) instanceof Crossbowman && ((Shooters) teamList.get(i)).shots < ((Shooters) teamList.get(i)).maxShots) {
                mapInfoShot.put(i, Integer.parseInt(((Shooters) teamList.get(i)).getInfoShots()));
            }
        }
        if (!mapInfoShot.isEmpty()) {
            int minShotPlayer = Collections.min(mapInfoShot.values());
            for (Map.Entry<Integer, Integer> entry : mapInfoShot.entrySet()) {
                if (entry.getValue() == minShotPlayer) {
                    ((Shooters) teamList.get(entry.getKey())).shots += 1;
                    System.out.println("Player " + this.name + " (" + this.getClass().getSimpleName() + ")" + " give arrow " + teamList.get(entry.getKey()));
                    break;
                }
            }
        }
    }
}
