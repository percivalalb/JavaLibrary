package javalibrary.cipher;

import javalibrary.math.MathHelper;

/**
 * @author Alex Barter (10AS)
 */
public class CadenusTransposition {
	
	public static String decode(String cipherText, String key) {
		int keyLength = key.length();

		int[] order = new int[keyLength];
		
		int p = 0;
		for(char ch = 'A'; ch <= 'Z'; ++ch) {
			int index = key.indexOf(ch);
			if(index != -1)
				order[p++] = index;
		}
		
		//Creates grid
		char[] start_grid = cipherText.toCharArray();
		char[] temp_grid = new char[cipherText.length()];
		
		for(int j = 0; j < 25; j++) {
			for(int i = 0; i < keyLength; i++) {
				int newColumn = order[i];
				int move = MathHelper.wrap(25 - charValue(key.charAt(newColumn)), 0, 25);
				int newIndex = MathHelper.wrap(j + move, 0, 25);
				temp_grid[newIndex * keyLength + newColumn] = start_grid[j * keyLength + i];
			}
		}

		return new String(temp_grid);
	}
	
	public static int charValue(char character) {
		if(character < 'V')
			return character - 65;
		else if(character > 'W')
			return character - 66;
		else
			return 21;
	}
}