import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class FactorsTester {

	@Test
	void testPerfect1() {
		// TEST 1: should throw the exception because the parameter value is less than 1
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.perfect(0));
	}

	@Test
	void testPerfect2() {
		// TEST 2: should succeed because 1 is a valid parameter value, but is not a
		// perfect number
		assertFalse(FactorsUtility.perfect(1));
	}

	@Test
	void testPerfect3() {
		// TEST 3: should succeed because 6 is a valid parameter value, and is a perfect
		// number
		assertTrue(FactorsUtility.perfect(6));
	}

	@Test
	void testPerfect4() {
		// TEST 4: should succeed because 7 is a valid parameter value, but is not a
		// perfect number
		// I've coded this using assertEquals to show that there's often more than one
		// way to write a test
		boolean expected = false;
		assertEquals(expected, FactorsUtility.perfect(7));
	}

	@Test
	void testGetFactors1() {
		// TEST 1: should return factors of 2, not including itself
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		assertEquals(expected, FactorsUtility.getFactors(2));
	}

	@Test
	void testGetFactors2() {
		// TEST 2: should return empty list for a = 1
		ArrayList<Integer> expected = new ArrayList<Integer>();
		assertEquals(expected, FactorsUtility.getFactors(1));
	}

	@Test
	void testGetFactors3() {
		// TEST 3: should return empty list for a = 0
		ArrayList<Integer> expected = new ArrayList<Integer>();
		assertEquals(expected, FactorsUtility.getFactors(0));
	}

	@Test
	void testGetFactors4() {
		// TEST 4: should throw the exception because the parameter value is less than 0
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.getFactors(-1));
	}

	@Test
	void testGetFactors5() {
		// TEST 5: should return factors of 12, not including itself
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		expected.add(6);
		assertEquals(expected, FactorsUtility.getFactors(12));
	}

	@Test
	void testFactors1() {
		// TEST 1: should throw the exception because the parameter a < 0
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.factor(-1, 5));
	}

	@Test
	void testFactor2() {
		// TEST 2: should throw the exception because the parameter b < 1
		assertThrows(IllegalArgumentException.class, () -> FactorsUtility.factor(5, 0));
	}

	@Test
	void testFactor3() {
		// TEST 3: should succeed without any exception since a > 0 and b > 1
		assert(FactorsUtility.factor(4, 2));
	}
	
	@Test
	void testFactor4() {
		// TEST 4: should succeed since 2 is a factor of 10
		assertTrue(FactorsUtility.factor(10, 2));
	}

	@Test
	void testFactor5() {
		// TEST 5: should succeed since 4 is a not a factor of 10
		assertFalse(FactorsUtility.factor(10, 4));
	}

}