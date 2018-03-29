package anubhav.calculatorapp;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void  milliToMeterTest() throws Exception {
        assertThat(0.02,equalTo(ConvertingUnits.Area.sqMilliToMeter(20000.00)));
    }
    @Test
    public void  meterToMilliTest() throws Exception {
        assertThat(20000.00,equalTo(ConvertingUnits.Area.sqMeterToMilli(0.020)));
    }
    @Test
    public void factorialMultiplyTest() throws Exception {
        CalculateFactorial calcFact = new CalculateFactorial();
        assertEquals(3,calcFact.multiply(9,3));
    }
    @Test
    public void factorialTest () throws Exception {
        CalculateFactorial calcFact = new CalculateFactorial();
        calcFact.factorial(10);
        assertEquals(7,calcFact.getRes());
    }
    @Test
    public void test() throws Exception {
        ExtendedDoubleEvaluator EDE = new ExtendedDoubleEvaluator();
        assertThat(9.00,equalTo(EDE.evaluate("9")));
    }
}