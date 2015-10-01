package javalibrary.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class RandomUtil {

	private static Random DEFAULT_RAND = new Random();
	
	public static int pickRandomInt(int range) {
		return pickRandomInt(range, DEFAULT_RAND);
	}
	
	public static int pickRandomInt(int range, Random random) {
		return random.nextInt(range);
	}
	
	public static <K, V> V pickRandomValue(Map<K, V> map) {
		return pickRandomElement(new ArrayList<V>(map.values()), DEFAULT_RAND);
	}
	
	public static <K, V> V pickRandomValue(Map<K, V> map, Random random) {
		return pickRandomElement(new ArrayList<V>(map.values()), random);
	}
	
	public static <K, V> K pickRandomKey(Map<K, V> map) {
		return pickRandomElement(new ArrayList<K>(map.keySet()), DEFAULT_RAND);
	}
	
	public static <K, V> K pickRandomKey(Map<K, V> map, Random random) {
		return pickRandomElement(new ArrayList<K>(map.keySet()), random);
	}
	
	public static <K, V> Entry<K, V> pickRandomEntry(Map<K, V> map) {
		return pickRandomElement(new ArrayList<Entry<K, V>>(map.entrySet()), DEFAULT_RAND);
	}
	
	public static <K, V> Entry<K, V> pickRandomEntry(Map<K, V> map, Random random) {
		return pickRandomElement(new ArrayList<Entry<K, V>>(map.entrySet()), random);
	}
	
	public static <T> T pickRandomElement(List<T> list) {
		return pickRandomElement(list, DEFAULT_RAND);
	}
	
	public static <T> T pickRandomElement(List<T> list, Random random) {
		return list.get(pickRandomInt(list.size(), random));
	}
	
	public static <T> T pickRandomElement(T... array) {
		return pickRandomElement(DEFAULT_RAND, array);
	}
	
	public static <T> T pickRandomElement(Random random, T... array) {
		return array[pickRandomInt(array.length, random)];
	}
}