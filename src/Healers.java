import java.util.ArrayList;

public class Healers extends BaseHero {
    private int magic;

    public Healers(ArrayList<BaseHero> myTeam, String name, int hp, int attack, int defence, int[] damage, int speed, int magic, int x, int y) {
        super(myTeam, name, hp, attack, defence, damage, speed, x, y);
        this.magic = magic;
    }

    @Override
    public String toString() {
        return String.format("%s %s %-3s", super.toString(), "\uD83E\uDD84", magic);
    }

    public void step(ArrayList<BaseHero> teamList) {
        if (this.hp <= 0) {
            System.out.println(this.name + " " + this.getClass().getSimpleName() + " is dead ❌☠️");
        } else {
            int index = getIndexPlayerMinHp(myTeam);
            if (index != -1 && myTeam.get(index).hp != myTeam.get(index).maxHp) {
                if (myTeam.get(index).hp - this.damage[0] > myTeam.get(index).maxHp) {
                    myTeam.get(index).hp = myTeam.get(index).maxHp;
                } else {
                    myTeam.get(index).hp -= this.damage[0];
                }
                System.out.println(this.name + " " + this.getClass().getSimpleName() + " healed \uD83D\uDC9A " + myTeam.get(index));
            } else {
                System.out.println(this.name + " " + this.getClass().getSimpleName() + " \uD83D\uDE34");
            }
        }
    }
}
