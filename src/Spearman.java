public class Spearman extends BaseHero {
    public Spearman() {
        super(String.format("%d", ++Spearman.number), 10, 4, 5, new int[]{1, 3}, 4);
    }
}
