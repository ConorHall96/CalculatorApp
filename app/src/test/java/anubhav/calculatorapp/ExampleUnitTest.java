package anubhav.calculatorapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

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
    public void multiplicationTest() throws Exception {
        StandardCal stdCal = new StandardCal();
        LayoutInflater vi = (LayoutInflater) stdCal.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = vi.inflate(R.layout.activity_standard_cal, null);
        String Expected = "4.0";
        v.setId(R.id.num2);
        stdCal.onClick(v);
        v.setId(R.id.multiply);
        stdCal.onClick(v);
        v.setId(R.id.num2);
        stdCal.onClick(v);
        v.setId(R.id.equal);
        stdCal.onClick(v);
        assertEquals(Expected, stdCal.getE2());
    }
}