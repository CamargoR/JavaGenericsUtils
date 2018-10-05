package camargo.ronan.generics.utils.convert;

import java.util.Collection;

import camargo.ronan.generics.utils.function.Function;

public class Convert<T extends Collection<I>,I,U extends Collection<O>, O> {
	
	private T collection;
	
	private Convert(T collection) {
		this.collection = collection;
	}
	
	public static<T extends Collection<I>,I,U extends Collection<O>,O> Convert<T,I,U,O> itemsIn(T collection){
		return new Convert<T, I, U, O>(collection);
	}
	
	@SuppressWarnings("unchecked")
	public U apply(Function<I,O> function) {
		U newCollection = null;
		try {
			 newCollection = (U) collection.getClass().newInstance();
			for (I item : collection) {
				newCollection.add(function.apply(item)); 
			}
			
		} catch (InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return newCollection;
	
	}
}
