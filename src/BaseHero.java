import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class BaseHero implements Face {
    protected ArrayList<BaseHero> myTeam;
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
    protected Vector2 position;

    public BaseHero(ArrayList<BaseHero> myTeam, String name, int hp, int attack, int defence, int[] damage, int speed, int x, int y) {
        this.position = new Vector2(x, y);
        this.name = name;
        this.maxHp = hp;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.speed = speed;
        this.myTeam = myTeam;
    }

    @Override
    public String toString() {
        return String.format("%s %s \uD83D\uDC94%02d/%02d  \uD83D\uDDE1️%d  \uD83D\uDD30%d  \uD83D\uDCAA%s  \uD83C\uDFC3%d ",
                name, getClass().getSimpleName(), hp, maxHp, attack, defence, Arrays.toString(damage), speed);
    }

    public float getDistance(int x2, int y2) {
        float dx = x2 - position.x;
        float dy = y2 - position.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    public void getDamage(int d) {
        if (this.hp - d > 0) {
            this.hp -= d;
            if (this.hp > this.maxHp) {
                this.hp = this.maxHp;
            }
        } else {
            this.hp = 0;
        }
    }

    public int attack(ArrayList<BaseHero> teamList, float minDistance, int indexPlayer) {
        int damage;
        if (minDistance > 4) {
            if (teamList.get(indexPlayer).defence < this.attack) {
                teamList.get(indexPlayer).getDamage(this.damage[0] + 1);
                damage = this.damage[0] + 1;
            } else {
                teamList.get(indexPlayer).getDamage(this.damage[0] - 1);
                damage = this.damage[0] - 1;
            }
        } else {
            if (teamList.get(indexPlayer).defence < this.attack) {
                teamList.get(indexPlayer).getDamage(this.damage[1] + 1);
                damage = this.damage[1] + 1;
            } else {
                teamList.get(indexPlayer).getDamage(this.damage[1] - 1);
                damage = this.damage[1] - 1;
            }
        }
        return damage;
    }


    @Override
    public void step(ArrayList<BaseHero> teamList) {
    }

    public Vector2 getPosition() {
        return position;
    }

    @Override
    public int getInfo() {
        return (hp * 100 / maxHp);
    }

    public String getName() {
        return name;
    }

    public int getIndexPlayerMinHp(ArrayList<BaseHero> teamList) {
        int max = 101;
        int index = -1;
        for (int i = 0; i < teamList.size(); i++) {
            if (teamList.get(i).hp != 0) {
                if (teamList.get(i).getInfo() < max) {
                    max = teamList.get(i).getInfo();
                    index = i;
                }
            }
        }
        return index;
    }
}