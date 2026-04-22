public class QuantityMeasurementApp {

    // LENGTH
    public static boolean lengthEqual(Length l1, Length l2) {
        return l1.equals(l2);
    }

    public static Length lengthConvert(double v, LengthUnit f, LengthUnit t) {
        return new Length(v, f).convertTo(t);
    }

    public static Length lengthAdd(Length l1, Length l2) {
        return l1.add(l2);
    }

    public static Length lengthAdd(Length l1, Length l2, LengthUnit t) {
        return l1.add(l2, t);
    }

    // WEIGHT
    public static boolean weightEqual(Weight w1, Weight w2) {
        return w1.equals(w2);
    }

    public static Weight weightConvert(double v, WeightUnit f, WeightUnit t) {
        return new Weight(v, f).convertTo(t);
    }

    public static Weight weightAdd(Weight w1, Weight w2) {
        return w1.add(w2);
    }

    public static Weight weightAdd(Weight w1, Weight w2, WeightUnit t) {
        return w1.add(w2, t);
    }

    public static void main(String[] args) {

        System.out.println(weightEqual(
                new Weight(1, WeightUnit.KILOGRAM),
                new Weight(1000, WeightUnit.GRAM)
        ));

        System.out.println(lengthEqual(
                new Length(1, LengthUnit.FEET),
                new Length(12, LengthUnit.INCHES)
        ));
    }
}