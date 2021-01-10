package methodstructure.pendrives;

import java.util.List;

public class Pendrives {

    public Pendrive bestpricepercapacity(List<Pendrive> pendrives) {
        Pendrive pendrive = pendrives.get(0);
        for (int idx = 0; idx < pendrives.size(); idx++) {
            if (pendrive.comparePricePerCapacity(pendrives.get(idx)) == 1) {
                pendrive = pendrives.get(idx);
            }
        }
        return pendrive;
    }

    public Pendrive cheapestbyprice(List<Pendrive> pendrives) {
        Pendrive pendrive = pendrives.get(0);
        for (int idx = 0; idx < pendrives.size(); idx++) {
            if (pendrives.get(idx).cheaperThan(pendrive)) {
                pendrive = pendrives.get(idx);
            }
        } return pendrive;
    }

    public void risePriceWhereCapacity(List<Pendrive> pendrives, int percent, int capacity) {
        for (Pendrive pendrive : pendrives) {
            if (pendrive.getCapacity() == capacity) {
                pendrive.risePrice(percent);
            }
        }
    }

}
