import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    void testFeetToFeet_SameValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testInchesToInches_SameValue() {
        Length l1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testFeetToInches_Equal() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testInchesToFeet_Equal() {
        Length l1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testFeetDifferent() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(2.0, Length.LengthUnit.FEET);

        assertFalse(l1.equals(l2));
    }

    @Test
    void testNullComparison() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);

        assertFalse(l1.equals(null));
    }

    @Test
    void testSameReference() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(l1.equals(l1));
    }
    @Test
    void testYardToFeet() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(3.0, Length.LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testYardToInches() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testCentimeterToInches() {
        Length l1 = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length l2 = new Length(0.393701, Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testYardNotEqual() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(2.0, Length.LengthUnit.FEET);

        assertFalse(l1.equals(l2));
    }

    @Test
    void testComplexTransitive() {
        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }
    @Test
    void testFeetToInches() {
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(
                1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);

        assertEquals(12.0, result.convertTo(Length.LengthUnit.INCHES).value, 0.01);
    }

    @Test
    void testYardsToFeet() {
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(
                3.0, Length.LengthUnit.YARDS, Length.LengthUnit.FEET);

        assertEquals(9.0, result.convertTo(Length.LengthUnit.FEET).value, 0.01);
    }

    @Test
    void testRoundTripConversion() {
        Length original = new Length(5.0, Length.LengthUnit.FEET);

        Length inches = original.convertTo(Length.LengthUnit.INCHES);
        Length back = inches.convertTo(Length.LengthUnit.FEET);

        assertEquals(original.convertTo(Length.LengthUnit.FEET).value,
                back.convertTo(Length.LengthUnit.FEET).value, 0.01);
    }

    @Test
    void testZeroConversion() {
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(
                0.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);

        assertEquals(0.0, result.convertTo(Length.LengthUnit.INCHES).value, 0.01);
    }

    @Test
    void testNegativeConversion() {
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(
                -1.0, Length.LengthUnit.FEET, Length.LengthUnit.INCHES);

        assertEquals(-12.0, result.convertTo(Length.LengthUnit.INCHES).value, 0.01);
    }

    @Test
    void testInvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Length(1.0, Length.LengthUnit.FEET).convertTo(null);
        });
    }
    @Test
    void addFeetAndInches() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);
        Length expected = new Length(2.0, Length.LengthUnit.FEET);

        assertTrue(result.equals(expected));
    }

    @Test
    void addInchesAndFeet() {
        Length l1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);
        Length expected = new Length(24.0, Length.LengthUnit.INCHES);

        assertTrue(result.equals(expected));
    }

    @Test
    void addYardsAndFeet() {
        Length l1 = new Length(1.0, Length.LengthUnit.YARDS);
        Length l2 = new Length(3.0, Length.LengthUnit.FEET);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);
        Length expected = new Length(2.0, Length.LengthUnit.YARDS);

        assertTrue(result.equals(expected));
    }

    @Test
    void addWithZero() {
        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(0.0, Length.LengthUnit.INCHES);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);

        assertTrue(result.equals(l1));
    }

    @Test
    void addNegativeValues() {
        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(-2.0, Length.LengthUnit.FEET);

        Length result = QuantityMeasurementApp.demonstrateLengthAddition(l1, l2);
        Length expected = new Length(3.0, Length.LengthUnit.FEET);

        assertTrue(result.equals(expected));
    }

    @Test
    void addNullShouldThrow() {
        Length l1 = new Length(1.0, Length.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            l1.add(null);
        });
    }
}