package immutable.satellite;

import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {

    private List<Satellite> traceSatellites = new ArrayList<>();

    public void registerSatellite(Satellite satellite) {
        if (satellite == null) {
            throw new NullPointerException("Satellite is empty!");
        }
        traceSatellites.add(satellite);
    }

    public Satellite findSatellitebyRegisterIdent(String registerIdent) {
        for (Satellite satellite : traceSatellites) {
            if (satellite.getRegisterIdent().equals(registerIdent)) {
                return satellite;
            }
        }
        throw new IllegalArgumentException("Satellite is not found with " + registerIdent);
    }

    @Override
    public String toString() {
        return traceSatellites.toString();
    }
}
