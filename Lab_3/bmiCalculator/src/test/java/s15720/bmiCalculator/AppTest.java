package s15720.bmiCalculator;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AppTest 
{
	private CalculateBmi calculateBMI;
	private CalculateBmi displayBMI;

	@Before
	public void setUp() {
		calculateBMI = new CalculateBmi();
		displayBMI = new CalculateBmi();
	}
	
	@After
	public void tearDown() {
		calculateBMI = null;
		displayBMI = null;
	}
	
	@Test
    public void bmi_isCorrect() {
        float result = calculateBMI.CalculateBMI(182.0f, 80.0f, 20.0f);
		assertEquals(24.151672f, result, 0);
		System.out.println("Test bmi_isCorrect result: " + result);
    }
	
	@Test
	public void DataIsNotNull() {
		float result = calculateBMI.CalculateBMI(182.0f, 80.0f, 20.0f);
		assertNotNull("Result ", result);
	}
	
	@Test
	public void BmiInfo_isCorrect() {
		String result = displayBMI.DisplayBMI(26.0f);
		assertEquals("nadwaga", result);
	}
}
