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
}
