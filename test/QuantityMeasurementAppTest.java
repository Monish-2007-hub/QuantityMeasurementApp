import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // Equality
    @Test
    void testFeetEquality() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(1.0, LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testFeetInchesEquality() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    void testInequality() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(2.0, LengthUnit.FEET);

        assertFalse(l1.equals(l2));
    }

    // Conversion
    @Test
    void convertFeetToInches() {
        Length result = new Length(1.0, LengthUnit.FEET)
                .convertTo(LengthUnit.INCHES);

        Length expected = new Length(12.0, LengthUnit.INCHES);

        assertTrue(result.equals(expected));
    }

    @Test
    void convertYardsToFeet() {
        Length result = new Length(1.0, LengthUnit.YARDS)
                .convertTo(LengthUnit.FEET);

        Length expected = new Length(3.0, LengthUnit.FEET);

        assertTrue(result.equals(expected));
    }

    // Addition UC6
    @Test
    void addFeetAndInches() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length result = l1.add(l2);
        Length expected = new Length(2.0, LengthUnit.FEET);

        assertTrue(result.equals(expected));
    }

    // Addition UC7 (target unit)
    @Test
    void addWithTargetInches() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length result = l1.add(l2, LengthUnit.INCHES);
        Length expected = new Length(24.0, LengthUnit.INCHES);

        assertTrue(result.equals(expected));
    }

    @Test
    void addWithTargetFeet() {
        Length l1 = new Length(12.0, LengthUnit.INCHES);
        Length l2 = new Length(12.0, LengthUnit.INCHES);

        Length result = l1.add(l2, LengthUnit.FEET);
        Length expected = new Length(2.0, LengthUnit.FEET);

        assertTrue(result.equals(expected));
    }

    // Edge cases
    @Test
    void nullComparison() {
        Length l1 = new Length(1.0, LengthUnit.FEET);

        assertFalse(l1.equals(null));
    }

    @Test
    void sameReference() {
        Length l1 = new Length(1.0, LengthUnit.FEET);

        assertTrue(l1.equals(l1));
    }
}