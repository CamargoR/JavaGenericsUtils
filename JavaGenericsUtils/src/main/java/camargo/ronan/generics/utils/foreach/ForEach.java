package camargo.ronan.generics.utils.foreach;

import java.util.Collection;

import camargo.ronan.generics.utils.function.Function;

public class ForEach<T extends Collection<E>, E> {

	T collection;
	
	private ForEach(T collection) {
		this.collection = collection;
	}
	
	public static<T extends Collection<E>,E> ForEach<T,E> itemIn(T collection) {
		return new ForEach<T, E>(collection);
	}

	@SuppressWarnings("unchecked")
	public T apply(Function<E,E> function) {
		T newCollection = null;
		try {
			 newCollection = (T) collection.getClass().newInstance();
			
			 for (E item : collection) {
				newCollection.add(function.apply(item)); 
			}
			
		} catch (InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return newCollection;
	
	}
}
