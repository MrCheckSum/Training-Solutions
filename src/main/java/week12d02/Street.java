package week12d02;

import java.util.ArrayList;
import java.util.List;

public class Street {

    private List<Site> sites = new ArrayList<>();

    public void sellSite(Site site) {
        sites.add(site);
    }

    public int lastSold() {
        Site lastSite = sites.get(sites.size() - 1);
        int nrOfSite = 0;
        if (lastSite.getSide() == 0) {
            nrOfSite = 0;
        } else {
            nrOfSite = -1;
        }
        for (Site site : sites) {
            if (lastSite.getSide() == site.getSide()) {
                nrOfSite += 2;
            }
        }
        return nrOfSite;
    }

    public List<FenceStatistic> fenceStatistics() {
        List<FenceStatistic> result = new ArrayList<>();

        for (Site site : sites) {
            FenceStatistic returned = returnFenceIfContains(result, site.getFence());
            if (returned == null) {
                result.add(new FenceStatistic(site.getFence()));
            } else {
                returned.increase();
            }
        }
        return result;
    }

    public FenceStatistic returnFenceIfContains(List<FenceStatistic> fenceStatistics, Fence fence) {
        for (FenceStatistic fenceStatistic : fenceStatistics) {
            if (fenceStatistic.getFence() == fence) {
                return fenceStatistic;
            }
        }
        return null;
    }

}