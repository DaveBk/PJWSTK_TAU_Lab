package s15720.bmiCalculator;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AppTest 
{
	private CalculateBmi calculateBMI;
	private CalculateBmi displayBMI;
	private CalculateBmi calculateBHC;

	@Before
	public void setUp() {
		calculateBMI = new CalculateBmi();
		displayBMI = new CalculateBmi();
		calculateBHC = new CalculateBmi();
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
	public void bmiDataIsNotNull() {
		float result = calculateBMI.CalculateBMI(182.0f, 80.0f, 20.0f);
		assertNotNull("Result ", result);
	}
	
	@Test
	public void bmiInfo_isCorrect() {
		String result = displayBMI.DisplayBMI(26.0f);
		assertEquals("nadwaga", result);
	}
	
	//New
	
	@Test
    public void bhc_isCorrect() {
        float result = calculateBHC.CalculateBHC("160", "50", "20", "female");
		assertEquals(1335.73f, result, 0);
		System.out.println("Test bhc_isCorrect result: " + result);
    }
	
	@Test
	public void bhcDataIsNotNull() {
		float result = calculateBHC.CalculateBHC("160", "50", "20", "male");
		assertNotNull("Result ", result);
	}
	
	
}
