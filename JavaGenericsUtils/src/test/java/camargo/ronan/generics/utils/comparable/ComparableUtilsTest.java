package camargo.ronan.generics.utils.comparable;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import camargo.ronan.generics.utils.comparable.ComparableUtils;

public class ComparableUtilsTest {

	@Test
	public void bigDecimalOneIsLessThanBigDecimalTen() {
		Assert.assertTrue(ComparableUtils.isLessThan(BigDecimal.ONE, BigDecimal.TEN));		
	}
	
	@Test
	public void doubleFiveIsGreatherThanDoubleTwo() {
		Assert.assertTrue(ComparableUtils.isGreaterThan(new Double(5), new Double(2)));
	}
	
	@Test
	public void intOneIsEqualToIntOne() {
		Assert.assertTrue(ComparableUtils.isEqualTo(1, 1));
	}

}
