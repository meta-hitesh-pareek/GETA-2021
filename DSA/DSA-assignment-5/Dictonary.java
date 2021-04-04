package GETA2021.DSA.DSAAssignment5;

/**
 * Declare function of Dictonary 
 * 
 * @since 14-03-2021
 * @author Hitesh Pareek
 */
public interface Dictonary<K extends Comparable<K>,T> {
	
	public void add(K key,T value);
	
	public boolean delete(K key);
	
	public T get(K key);
	
	public List<KeyValue<K,T>> sortAccordingToKeys(KeyValue<Integer, String> root);
	
	public List<KeyValue<K,T>> sortCondition(K key1,K key2);
}