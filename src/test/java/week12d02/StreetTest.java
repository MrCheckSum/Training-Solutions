package week12d02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreetTest {

    private List<Site> sellSites;
    private Street street;

    @BeforeEach
    public void setUp() {
        sellSites = new ArrayList<>();
        street = new Street();
        street.sellSite(new Site(0, 1, Fence.PERFECT));
        street.sellSite(new Site(1, 2, Fence.NEED_UPGRADE));
        street.sellSite(new Site(0, 3, Fence.NEED_UPGRADE));
        street.sellSite(new Site(1, 3, Fence.PERFECT));
        street.sellSite(new Site(0, 4, Fence.NO_FENCE));
        street.sellSite(new Site(1, 1, Fence.NO_FENCE));
        street.sellSite(new Site(1, 2, Fence.NO_FENCE));
    }

    @Test
    void lastSold() {
        assertEquals(7, street.lastSold());
    }

    @Test
    void fenceStatistics() {
        List<FenceStatistic> fenceStatistics = street.fenceStatistics();

        assertEquals(3, fenceStatistics.get(0).getCount());
        assertEquals(Fence.PERFECT, fenceStatistics.get(0).getFence());

        assertEquals(2, fenceStatistics.get(1).getCount());
        assertEquals(Fence.NEED_UPGRADE, fenceStatistics.get(1).getFence());

        assertEquals(2, fenceStatistics.get(2).getCount());
        assertEquals(Fence.NO_FENCE, fenceStatistics.get(2).getFence());

        assertEquals(7, fenceStatistics.size());
    }
}