package camargo.ronan.generics.utils.filter;

import java.util.Collection;

import camargo.ronan.generics.utils.function.Function;

public class Filter<T extends Collection<E>,E> {
	
	private T collection;
	
	private Filter(T collection) {		
		this.collection = collection;
	}
	
	public static<T extends Collection<E>,E> Filter<T,E> itemsIn(T collection) {
		return new Filter<T,E>(collection);
	}
	
	@SuppressWarnings("unchecked")
	public T thatMatch(Function<E, Boolean> condition) {
		T filteredCollection = null;
		
		try {
			filteredCollection = (T) collection.getClass().newInstance();
			for (E element : collection) {
				if (condition.apply(element)) {
					filteredCollection.add(element);
				}
			}
		
			
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return filteredCollection;		
	}

}
