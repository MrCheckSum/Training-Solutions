package enumtype.unit;

public enum LengthUnit {

    MILLIMETER(1, true),
    CENTIMETER(100, true),
    METER(1000, true),
    YARD(9144, false),
    FOOT(3048, false),
    INCH(254,false);

    private final int lengthUnitInMillimeter;
    private final boolean siUnits;

    LengthUnit(int lengthUnitInMillimeter, boolean siUnits) {
        this.lengthUnitInMillimeter = lengthUnitInMillimeter;
        this.siUnits = siUnits;
    }

    public int getLengthUnitInMillimeter() {
        return lengthUnitInMillimeter;
    }

    public boolean isSiUnits() {
        return siUnits;
    }
}
