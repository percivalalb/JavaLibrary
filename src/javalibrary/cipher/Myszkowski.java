package javalibrary.cipher;

public class Myszkowski {

	public static String encode(String plainText, String keyword) {
		String cipherText = "";
		
		int rows = (int)Math.ceil(plainText.length() / (double)keyword.length());
		
		for(char c = 'A'; c <= 'Z'; c++) {
			if(keyword.indexOf(c) == -1)
				continue;
			
			for(int row = 0; row < rows; row++)
				for(int i = 0; i < keyword.length(); i++)
					if(c == keyword.charAt(i)) 
						if(row * keyword.length() + i < plainText.length())
							cipherText += plainText.charAt(row * keyword.length() + i);
		}
		
		return cipherText;
	}
	
	public static String decode(String cipherText, String keyword) {
		char[] plainText = new char[cipherText.length()];
		
		int rows = (int)Math.ceil(cipherText.length() / (double)keyword.length());
		
		int index = 0;
		for(char c = 'A'; c <= 'Z'; c++) {
			if(keyword.indexOf(c) == -1)
				continue;
			
			for(int row = 0; row < rows; row++)
				for(int i = 0; i < keyword.length(); i++) 
					if(c == keyword.charAt(i))
						if(row * keyword.length() + i < cipherText.length())
							plainText[row * keyword.length() + i] = cipherText.charAt(index++);
		}
		
		return new String(plainText);	
	}
}