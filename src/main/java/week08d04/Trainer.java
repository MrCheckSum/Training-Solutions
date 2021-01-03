package week08d04;

public class Trainer {

    private CanMark canMark;

    public Trainer(CanMark canMark) {
        this.canMark = canMark;
    }

    public int giveMark() {
        return canMark.giveMark();
    }

    public static void main(String[] args) {
        Trainer t1bad = new Trainer(new BadMood());
        Trainer t2good = new Trainer(new GoodMood());

        System.out.println(t1bad.giveMark());
        System.out.println(t2good.giveMark());
    }
}
