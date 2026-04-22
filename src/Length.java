public class Length {

    private double value;
    private LengthUnit unit;

    // ✅ Extended Enum
    public enum LengthUnit {
        FEET(12.0),          // 1 ft = 12 in
        INCHES(1.0),         // base unit
        YARDS(36.0),         // 1 yd = 36 in
        CENTIMETERS(0.393701); // 1 cm = 0.393701 in

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    // Convert everything → inches
    private double toBaseUnit() {
        return this.value * this.unit.getConversionFactor();
    }

    public boolean compare(Length other) {
        return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Length other = (Length) obj;
        return this.compare(other);
    }
}