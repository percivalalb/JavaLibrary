package javalibrary.math;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Alex Barter (10AS)
 */
public class ArrayHelper {

	public static int[] range(int start, int end){
	    int[] arr = new int[end - start];
	    for(int i = 0; i < end - start; i++)
	        arr[i] = start + i;
	    return arr;
	}
	
	public static Integer[] rangeInt(int start, int end){
		Integer[] arr = new Integer[end - start];
	    for(int i = 0; i < end - start; i++)
	        arr[i] = start + i;
	    return arr;
	}
	
	public static char[] charRange(char start, char end){
		char[] arr = new char[end - start];
	    for(int i = 0; i < end - start; i++)
	        arr[i] = (char)(start + i);
	    return arr;
	}
	
	public static <T> int indexOf(T[] array, T target) {
		for(int i = 0; i < array.length; i++)
	        if(array[i] != null && array[i].equals(target) || target == null && array[i] == null) 
	        	return i;

	    return -1;
	}
	
	public static  int indexOf(char[] array, char target) {
		for(int i = 0; i < array.length; i++)
	        if(array[i] == target) 
	        	return i;

	    return -1;
	}
	
	public static <T> T[] fill(T filler, int length){
	    T[] arr = (T[])Array.newInstance(filler.getClass(), length);
	    for(int i = 0; i < length; i++)
	        arr[i] = filler;
	    return arr;
	}
	
	public static <T> T[] concat(T[] first, T[] second) {
		T[] result = Arrays.copyOf(first, first.length + second.length);
		System.arraycopy(second, 0, result, first.length, second.length);
		return result;
	}
	
	public static char[] concat(char[] a, char[] b) {
		int aLen = a.length;
		int bLen = b.length;
		char[] c = new char[aLen + bLen];
		System.arraycopy(a, 0, c, 0, aLen);
		System.arraycopy(b, 0, c, aLen, bLen);
		return c;
	}
	
	public static char[] copyOfRange(char[] array, int startIndex, int length) {
		return Arrays.copyOfRange(array, startIndex, startIndex + length);
	}
}
