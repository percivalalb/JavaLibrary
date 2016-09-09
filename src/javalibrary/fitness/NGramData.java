package javalibrary.fitness;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Alex Barter (10AS)
 */
public class NGramData {

	//public HashMap<String, Double> mapping;
	public double[] valueMapping;
	public int nGram;
	public int[] powValues;
	public double floor;
	public double fitnessPerChar;

	public NGramData(HashMap<String, Double> mapping, double floor, double fitnessPerChar, int nGram) {
		//this.mapping = mapping;
		this.floor = floor;
		this.fitnessPerChar = fitnessPerChar;
		this.nGram = nGram;
		this.powValues = new int[nGram + 1];
		for(int i = 0; i < this.powValues.length; i++)
			this.powValues[i] = (int)Math.pow(26, i);
		
		this.valueMapping = new double[this.powValues[nGram]];
		Arrays.fill(this.valueMapping, floor);
		
		for(String key : mapping.keySet()) {

			int value = 0;
			for(int i = 0; i < this.nGram; i++)
				value += (key.charAt(i) - 'A') * this.powValues[this.powValues.length - 2 - i];
			
			if(value < 0 || value > this.valueMapping.length - 1)
				continue;
		
			if(this.valueMapping[value] != this.floor)
				System.err.println("Mapping overlap ngramdata");
			else
				this.valueMapping[value] = mapping.get(key);
		}
	}
	

	
	public double getValue(char[] gram, int startIndex) {
		int intConversion = 0;
		for(int i = startIndex; i < startIndex + this.nGram; i++)
			intConversion += (gram[i] - 'A') * this.powValues[this.powValues.length - 2 - i + startIndex];

		if(intConversion < 0 || intConversion > this.valueMapping.length - 1)
			return this.floor;
		return this.valueMapping[intConversion];
	}
	
	//public double getValue(String gram) {
	//	return valueMapping.get((gram.charAt(0) - 65) * 17576 + (gram.charAt(1) - 65) * 676 + (gram.charAt(2) - 65) * 26 + gram.charAt(3) - 65);
	//}
}
