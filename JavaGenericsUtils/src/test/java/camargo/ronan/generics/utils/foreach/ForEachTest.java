package camargo.ronan.generics.utils.foreach;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import camargo.ronan.generics.utils.function.Function;

public class ForEachTest {

	@Test
	public void testForEachMultiplyingByTenAList() {
//		List<Integer> integerList = Arrays.asList(new Integer(5), new Integer(10));
		List<Integer> integerList = new ArrayList<>();
		integerList.add(new Integer(5));
		integerList.add(new Integer(10));
		
		List<Integer> list = ForEach.itemIn(integerList).apply(value -> value*5);	
		Assert.assertArrayEquals(new Object[] {25,50}, list.toArray());
	}
	
	@Test
	public void testForEachMultiplyingByTenASet() {
		Set<Integer> integerSet = new HashSet<>();
		integerSet.add(5);
		integerSet.add(10);
		
		Set<Integer> set = ForEach.itemIn(integerSet).apply(new MultiplyByTen());
		Assert.assertArrayEquals(new Object[] {50,100}, set.toArray());
		
	}
	
	private class MultiplyByTen implements Function<Integer, Integer> {
		@Override
		public Integer apply(Integer input) {
			return input*10;
		}		
	}

}
