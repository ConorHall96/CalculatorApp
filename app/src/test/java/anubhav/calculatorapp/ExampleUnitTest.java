package anubhav.calculatorapp;

import android.view.View;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void multiplicationTest(View v) throws Exception {
        StandardCal stdCal = new StandardCal();
        Double Expected = 4.0;
        v.setId(R.id.num2);
        stdCal.onClick(v);
        v.setId(R.id.multiply);
        stdCal.onClick(v);
        v.setId(R.id.num2);
        stdCal.onClick(v);
        v.setId(R.id.equal);
        stdCal.onClick(v);
        assertEquals(Expected, ((Double) stdCal.getResult()));
    }
}