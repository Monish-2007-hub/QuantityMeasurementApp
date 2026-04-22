import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // WEIGHT TESTS
    @Test
    void kgEqualsGram() {
        assertTrue(new Weight(1, WeightUnit.KILOGRAM)
                .equals(new Weight(1000, WeightUnit.GRAM)));
    }

    @Test
    void poundEqualsGram() {
        assertTrue(new Weight(1, WeightUnit.POUND)
                .equals(new Weight(453.592, WeightUnit.GRAM)));
    }

    @Test
    void addWeight() {
        Weight result = new Weight(1, WeightUnit.KILOGRAM)
                .add(new Weight(1000, WeightUnit.GRAM));

        assertTrue(result.equals(new Weight(2, WeightUnit.KILOGRAM)));
    }

    // LENGTH TESTS
    @Test
    void feetEqualsInches() {
        assertTrue(new Length(1, LengthUnit.FEET)
                .equals(new Length(12, LengthUnit.INCHES)));
    }

    @Test
    void addLength() {
        Length result = new Length(1, LengthUnit.FEET)
                .add(new Length(12, LengthUnit.INCHES));

        assertTrue(result.equals(new Length(2, LengthUnit.FEET)));
    }
}