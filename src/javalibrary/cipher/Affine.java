package javalibrary.cipher;

import java.math.BigInteger;
import java.util.Random;

import javalibrary.EncryptionData;
import javalibrary.ICipher;
import javalibrary.lib.EncryptionKeys;
import javalibrary.math.MathHelper;

/**
 * @author Alex Barter
 */
public class Affine implements ICipher {

	public static String encode(String plainText, int a, int b) {
		char[] charArray = plainText.toCharArray();
		
		String cipherText = "";
		
		String tempAlphabet = "";
		for(int i = 'A'; i <= 'Z'; ++i)
			tempAlphabet += (char)('A' + MathHelper.wrap(a * (i - 'A') + b, 0, 26));
		
		//Runs through all the characters from the array
		for(char ch : charArray) {
				
			if(!Character.isLetter(ch))
				cipherText += ch;
			else
				cipherText += (char)(tempAlphabet.indexOf(ch) + 'A');
		}
		
		return cipherText;
	}
	
	public static String decode(String cipherText, int a, int b) {
		char[] charArray = cipherText.toCharArray();
		
		String plainText = "";
		
		//Runs through all the characters from the array
		for(char ch : charArray) {
			int multiplicativeInverse = 0;
			multiplicativeInverse = BigInteger.valueOf((int)a).modInverse(BigInteger.valueOf(26)).intValue();
			
			plainText += (char)(MathHelper.wrap(multiplicativeInverse * (ch - 'A' - b), 0, 26) + 'A');
		}

		return plainText;
	}

	@Override
	public String encode(String plainText, EncryptionData data) {
		return encode(plainText, data.getData(EncryptionKeys.AFFINE_A, Integer.TYPE), data.getData(EncryptionKeys.AFFINE_B, Integer.TYPE));
	}

	@Override
	public String decode(String cipherText, EncryptionData data) {
		return decode(cipherText, data.getData(EncryptionKeys.AFFINE_A, Integer.TYPE), data.getData(EncryptionKeys.AFFINE_B, Integer.TYPE));
	}

	@Override
	public EncryptionData getRandomEncryptionData(Random rand) {
		//int a = rand.
		return new EncryptionData();
	}
}