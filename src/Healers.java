import java.util.ArrayList;

public class Healers extends BaseHero {
    private int magic;

    public Healers(String name, int hp, int attack, int defence, int[] damage, int speed, int magic) {
        super(name, hp, attack, defence, damage, speed);
        this.magic = magic;
    }

    @Override
    public String toString() {
        return super.toString() + " Magic: " + magic;
    }

    public void step(ArrayList<BaseHero> teamList) {
        int min;
        int index = 0;
        min = Integer.parseInt(teamList.get(0).getInfo());
        for (int i = 1; i < teamList.size(); i++) {
            if (min > Integer.parseInt(teamList.get(i).getInfo())) {
                min = Integer.parseInt(teamList.get(i).getInfo());
                index = i;
            }
        }
        if (teamList.get(index).hp == maxHp) {
            return;
        }
        else if (teamList.get(index).hp - damage[0] > maxHp) {
            teamList.get(index).hp = maxHp;
            System.out.println("Player " + this.name + " (" + this.getClass().getSimpleName() + ")" + " healed ♥ " + teamList.get(index));
        }
        else {
            teamList.get(index).hp -= damage[0];
            System.out.println("Player " + this.name + " (" + this.getClass().getSimpleName() + ")" + " healed ♥ " + teamList.get(index));
        }
    }
}
