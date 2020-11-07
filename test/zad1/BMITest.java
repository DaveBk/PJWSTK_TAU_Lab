package zad1;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import zadanie.Calculator;


public class BMITest {
	private Calculator calculateBMI;

	@Before
	public void setUp() {
		calculateBMI = new Calculator();
	}
	
	@After
	public void tearDown() {
		calculateBMI = null;
	}
	
	@Test
    public void bmi_isCorrect() {
        float result = calculateBMI.calculateBMI(182.0f, 80.0f, 20.0f);
		assertEquals(24.151672f, result, 0);
		System.out.println(result);
    }

}
