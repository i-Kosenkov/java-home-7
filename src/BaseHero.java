import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class BaseHero implements Face {
    protected static int number;
    protected static Random r;

    static {
        BaseHero.number = 0;
        BaseHero.r = new Random();
    }

    protected String name;
    protected int maxHp;
    protected int hp;
    protected int attack;
    protected int defence;
    protected int[] damage;
    protected int speed;

    public BaseHero(String name, int hp, int attack, int defence, int[] damage, int speed) {
        this.name = name;
        this.maxHp = hp;
        this.hp = hp - new Random().nextInt(0, maxHp);
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("Player %s - Type: %s HP: %d Attack: %d Defence: %d Damage: %s  Speed: %d",
                name, this.getClass().getSimpleName(), hp, attack, defence, Arrays.toString(damage), speed);
    }

    public void GetDamage(int d) {
        System.out.println("Damage: " + d + " Defence: " + this.defence);
        if (this.hp + this.defence - d > 0) {
            this.hp -= d - this.defence;
            if (this.hp > this.maxHp) {
                this.hp = this.maxHp;
            }
        } else {
            System.out.println("❌ Bye Bye ❌");
            this.hp = 0;
        }
    }

    public void Attack(BaseHero target) {
        int d = BaseHero.r.nextInt(damage[0], damage[1] + 1);
        target.GetDamage(d);
    }

    @Override
    public void step(ArrayList<BaseHero> teamList) {
    }

    @Override
    public String getInfo() {
        return String.valueOf(hp * 100 / maxHp);
    }
}