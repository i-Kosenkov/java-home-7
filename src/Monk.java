public class Monk extends BaseHero {
    int magic;

    public Monk() {
        super(String.format("%d", ++Monk.number), 30, 12, 7, new int[]{-4, 0}, 5);
        this.magic = 1;
    }

    @Override
    public String toString() {
        return super.toString() + " Magic: " + magic;
    }
}
