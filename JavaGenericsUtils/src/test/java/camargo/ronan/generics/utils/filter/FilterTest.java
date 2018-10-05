package camargo.ronan.generics.utils.filter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import camargo.ronan.generics.utils.comparable.ComparableUtils;
import camargo.ronan.generics.utils.function.Function;

public class FilterTest {

	@Test
	public void testFilterElementsGreaterThanFive() {
		List<BigDecimal> numbers = new ArrayList<>();
		numbers.add(BigDecimal.ZERO);
		numbers.add(BigDecimal.ONE);
		numbers.add(BigDecimal.TEN);
		
		List<BigDecimal> numbersGreaterThanFive = Filter.itemsIn(numbers).thatMatch(new GreaterThanFive());
		
		Assert.assertNotSame(numbers, numbersGreaterThanFive);
		Assert.assertTrue(numbersGreaterThanFive.size() == 1);
		Assert.assertTrue(ComparableUtils.isEqualTo(numbersGreaterThanFive.get(0), BigDecimal.TEN));;
	}
	
	private class GreaterThanFive implements Function<BigDecimal, Boolean>{

		@Override
		public Boolean apply(BigDecimal input) {
			return ComparableUtils.isGreaterThan(input, new BigDecimal(5));
		}
		
	}

}
