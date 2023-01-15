public class Outlaw extends BaseHero {
    public Outlaw() {

        super(String.format("%d", ++Outlaw.number), 10, 8, 3, new int[]{2, 4}, 6);
    }
}
