package methodoverloading.pub;

import java.util.List;

public class ListOfGoodPubs {
    private List<Pub> goodPubs;

    public ListOfGoodPubs(List<Pub> goodPubs) {
        if (goodPubs == null || goodPubs.isEmpty()) throw new IllegalArgumentException("Pub list can not be empty!");
        this.goodPubs = goodPubs;
    }

    public Pub findTheBestPub() {
        Pub best = goodPubs.get(0);
        for (int idx = 0; idx < goodPubs.size(); idx++) {
            if (goodPubs.get(idx).getOpenFrom().isEarlier(best.getOpenFrom())) {
                best = goodPubs.get(idx);
            }
        }
        return best;
    }
}
