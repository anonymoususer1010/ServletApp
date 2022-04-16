package testing;

import static org.junit.Assert.*;
import org.junit.Test;

import controller.CalculateBMI;

public class TestCalculateBMI {

	@Test
	public void testCalculateMethod() {
		double result1 = CalculateBMI.calculate(160, 65);
		System.out.println(result1);
		double result2= CalculateBMI.calculate(150, 55);
		assertEquals(25.39, result1,0);
		assertEquals(24.44, result2,0);
		try {
			CalculateBMI.calculate(0, 55);
			CalculateBMI.calculate(150, 0);
			CalculateBMI.calculate(0, 0);
			CalculateBMI.calculate(-5, -5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testDescriptionMethod() {
		String description1 = CalculateBMI.description(26);
		String description2 = CalculateBMI.description(40);
		assertEquals("Over Weight", description1);
		assertEquals("Extremely Obese", description2);
		try {
			CalculateBMI.description(0);
			CalculateBMI.description(-10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

