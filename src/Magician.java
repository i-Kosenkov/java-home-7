public class Magician extends BaseHero {
    int magic;

    public Magician() {
        super(String.format("%d", ++Magician.number), 30, 17, 12, new int[]{-5, 0}, 9);
        this.magic = 1;
    }

    @Override
    public String toString() {
        return super.toString() + " Magic: " + magic;
    }
}