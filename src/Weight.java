public class Weight {

    private final double value;
    private final WeightUnit unit;

    public Weight(double value, WeightUnit unit) {
        if (unit == null) throw new IllegalArgumentException();
        this.value = value;
        this.unit = unit;
    }

    public Weight convertTo(WeightUnit target) {
        double base = unit.toBase(value);
        double result = target.fromBase(base);
        return new Weight(result, target);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Weight)) return false;

        Weight other = (Weight) o;

        double b1 = unit.toBase(value);
        double b2 = other.unit.toBase(other.value);

        return Double.compare(b1, b2) == 0;
    }

    public Weight add(Weight other) {
        double sum = unit.toBase(value) + other.unit.toBase(other.value);
        return new Weight(unit.fromBase(sum), unit);
    }

    public Weight add(Weight other, WeightUnit target) {
        double sum = unit.toBase(value) + other.unit.toBase(other.value);
        return new Weight(target.fromBase(sum), target);
    }
}