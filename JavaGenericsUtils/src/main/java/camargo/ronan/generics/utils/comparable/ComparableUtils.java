package camargo.ronan.generics.utils.comparable;

public final class ComparableUtils {

	private ComparableUtils() {}
	
	public static<T extends Comparable<T>> boolean isGreaterThan(T value, T anotherValue) {
		return value.compareTo(anotherValue) > 0;
	}
	
	public static<T extends Comparable<T>> boolean isLessThan(T value, T anotherValue) {
		return value.compareTo(anotherValue) < 0;
	}
	
	public static<T extends Comparable<T>> boolean isEqualTo(T value, T anotherValue) {
		return value.compareTo(anotherValue) == 0;
	}
}
