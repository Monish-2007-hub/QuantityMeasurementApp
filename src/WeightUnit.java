public enum WeightUnit {

    MILLIGRAM(0.001),
    GRAM(1.0),
    KILOGRAM(1000.0),
    POUND(453.592),
    TONNE(1_000_000.0);

    private final double factor; // base = GRAM

    WeightUnit(double factor) {
        this.factor = factor;
    }

    public double toBase(double value) {
        return Math.round(value * factor * 100.0) / 100.0;
    }

    public double fromBase(double base) {
        return Math.round(base / factor * 100.0) / 100.0;
    }
}