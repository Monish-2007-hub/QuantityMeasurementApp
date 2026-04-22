public class Length {

    private double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        if (unit == null || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Length other = (Length) o;

        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        return Double.compare(base1, base2) == 0;
    }

    public Length convertTo(LengthUnit targetUnit) {
        double base = this.unit.convertToBaseUnit(this.value);
        double converted = targetUnit.convertFromBaseUnit(base);
        return new Length(converted, targetUnit);
    }

    public Length add(Length thatLength) {
        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = thatLength.unit.convertToBaseUnit(thatLength.value);

        double sum = base1 + base2;
        double result = this.unit.convertFromBaseUnit(sum);

        return new Length(result, this.unit);
    }

    public Length add(Length thatLength, LengthUnit targetUnit) {
        double base1 = this.unit.convertToBaseUnit(this.value);
        double base2 = thatLength.unit.convertToBaseUnit(thatLength.value);

        double sum = base1 + base2;
        double result = targetUnit.convertFromBaseUnit(sum);

        return new Length(result, targetUnit);
    }
}