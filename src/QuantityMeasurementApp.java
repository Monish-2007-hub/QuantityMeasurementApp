public class QuantityMeasurementApp {

    // Equality
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    // Comparison (wrapper)
    public static boolean demonstrateLengthComparison(double v1, Length.LengthUnit u1,
                                                      double v2, Length.LengthUnit u2) {
        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);
        return demonstrateLengthEquality(l1, l2);
    }

    // ✅ METHOD 1 (RAW VALUES)
    public static Length demonstrateLengthConversion(double value,
                                                     Length.LengthUnit from,
                                                     Length.LengthUnit to) {
        Length l = new Length(value, from);
        return l.convertTo(to);
    }

    // ✅ METHOD 2 (OVERLOADED)
    public static Length demonstrateLengthConversion(Length length,
                                                     Length.LengthUnit to) {
        return length.convertTo(to);
    }

    public static void main(String[] args) {

        // Example usage
        Length result1 = demonstrateLengthConversion(1.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        System.out.println(result1); // 12.00 INCHES

        Length yard = new Length(2.0, Length.LengthUnit.YARDS);
        Length result2 = demonstrateLengthConversion(yard,
                Length.LengthUnit.INCHES);

        System.out.println(result2); // 72.00 INCHES
    }
}