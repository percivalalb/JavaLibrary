package javalibrary.dict;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javalibrary.cipher.stats.TraverseTree;

public class Dictionary {

	public static List<String> words = new ArrayList<String>();
	
	public static void onLoad() {
		try {
			BufferedReader updateReader3 = new BufferedReader(new InputStreamReader(TraverseTree.class.getResourceAsStream("/javalibrary/dict/english_wordlist.txt")));
			while(true) {
				String line = updateReader3.readLine();
				if(line == null) break;
				if(line.isEmpty() || line.startsWith("#")) continue;
	
				words.add(line.toUpperCase());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}