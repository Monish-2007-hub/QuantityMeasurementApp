public class Length {

    double value;
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
    // Convert to target unit
    public Length convertTo(LengthUnit targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        if (!Double.isFinite(this.value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        // Step 1: Convert to base unit (inches)
        double baseValue = this.value * this.unit.getConversionFactor();

        // Step 2: Convert to target unit
        double convertedValue = baseValue / targetUnit.getConversionFactor();

        // Round to 2 decimal places
        convertedValue = Math.round(convertedValue * 100.0) / 100.0;

        return new Length(convertedValue, targetUnit);
    }
    public Length add(Length thatLength) {

        if (thatLength == null) {
            throw new IllegalArgumentException("Length cannot be null");
        }

        if (!Double.isFinite(this.value) || !Double.isFinite(thatLength.value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        // Step 1: Convert both to base unit (inches)
        double base1 = this.value * this.unit.getConversionFactor();
        double base2 = thatLength.value * thatLength.unit.getConversionFactor();

        // Step 2: Add
        double sumBase = base1 + base2;

        // Step 3: Convert back to this unit
        double resultValue = sumBase / this.unit.getConversionFactor();

        // Step 4: Round
        resultValue = Math.round(resultValue * 100.0) / 100.0;

        return new Length(resultValue, this.unit);
    }
    public Length add(Length thatLength, LengthUnit targetUnit) {

        if (thatLength == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        if (!Double.isFinite(this.value) || !Double.isFinite(thatLength.value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        // Step 1: Convert both → base (inches)
        double base1 = this.value * this.unit.getConversionFactor();
        double base2 = thatLength.value * thatLength.unit.getConversionFactor();

        // Step 2: Add
        double sumBase = base1 + base2;

        // Step 3: Convert → target unit
        double result = sumBase / targetUnit.getConversionFactor();

        // Step 4: Round
        result = Math.round(result * 100.0) / 100.0;

        return new Length(result, targetUnit);
    }
}