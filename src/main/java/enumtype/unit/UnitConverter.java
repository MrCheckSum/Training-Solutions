package enumtype.unit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class UnitConverter {

    public static final int DEF_SCALE = 4;

    public BigDecimal convert(BigDecimal length, LengthUnit convertFrom, LengthUnit convertTo) {
        return length.multiply(new BigDecimal(convertFrom.getLengthUnitInMillimeter())).divide(new BigDecimal(convertTo.getLengthUnitInMillimeter()), DEF_SCALE, RoundingMode.HALF_UP);
    }

    public List<LengthUnit> siUnits() {
        List<LengthUnit> units = new ArrayList<>();
        for (LengthUnit unit : LengthUnit.values()) {
            if (unit.isSiUnits()) {
                units.add(unit);
            }
        }
        return units;

    }
}
