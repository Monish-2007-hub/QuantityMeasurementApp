public class QuantityMeasurementApp {

    // Equality
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    // Comparison using raw values
    public static boolean demonstrateLengthComparison(double v1, LengthUnit u1,
                                                      double v2, LengthUnit u2) {
        Length l1 = new Length(v1, u1);
        Length l2 = new Length(v2, u2);
        return l1.equals(l2);
    }

    // Conversion (raw values)
    public static Length demonstrateLengthConversion(double value,
                                                     LengthUnit from,
                                                     LengthUnit to) {
        return new Length(value, from).convertTo(to);
    }

    // Conversion (object)
    public static Length demonstrateLengthConversion(Length length,
                                                     LengthUnit to) {
        return length.convertTo(to);
    }

    // Addition (UC6)
    public static Length demonstrateLengthAddition(Length l1, Length l2) {
        return l1.add(l2);
    }

    // Addition with target unit (UC7)
    public static Length demonstrateLengthAddition(Length l1,
                                                   Length l2,
                                                   LengthUnit targetUnit) {
        return l1.add(l2, targetUnit);
    }

    public static void main(String[] args) {

        // Equality
        System.out.println(demonstrateLengthComparison(1.0, LengthUnit.FEET,
                12.0, LengthUnit.INCHES));

        // Conversion
        System.out.println(demonstrateLengthConversion(1.0,
                LengthUnit.FEET,
                LengthUnit.INCHES));

        // Addition
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        System.out.println(demonstrateLengthAddition(l1, l2)); // 2 FEET

        // Addition with target
        System.out.println(demonstrateLengthAddition(l1, l2, LengthUnit.INCHES)); // 24 INCHES
    }
}