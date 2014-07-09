package ruandao.text;

import java.util.*;

public class TextParagraph {

	// 一段英文，
	// 1. 统计出现了到少单词，每个单词出现的次数，并且把统计结果打印出来。
	// 2. 统计26个字母在这段话中的出现次数，并且把统计结果打印出来。
	public static void main(String[] args) {
		TextParagraph tp = new TextParagraph();
		String paragraph = "SortedMap<String, Integer> wordMap = new "
				+ "TreeMap<String,Integer>();SortedMap<Character, Integer>"
				+ " charMap = new TreeMap<Character,Integer>()";
		
		int numWords = tp.wordStatistics(paragraph);
		
		System.out.println("一共有" + numWords + "个单词。");
		for(String key: tp.wordMap.keySet()){
			System.out.println(key + ": " + tp.wordMap.get(key));
		}
		
		int numChars = tp.charStatistics(paragraph);
		
		System.out.println("一共有" + numChars + "个字母。");
		for(char key: tp.charMap.keySet()){
			System.out.println(key + ": " + tp.charMap.get(key));
		}
	}

	SortedMap<String, Integer> wordMap = new TreeMap<String,Integer>();
	SortedMap<Character, Integer> charMap = new TreeMap<Character,Integer>(); 
	
	// 返回总的字符数。
	public int wordStatistics(String paragraph){
        String[] words = paragraph.split("[^a-zA-Z]+");  // Split the line into words
        int numWords = 0;
        for (String word : words) {
			if (word != "") {	// Don't count empty strings
				numWords++;
				if (!wordMap.containsKey(word)) {
                    // If we've never seen this word before, add it to the sorted list with a count of 1
                    wordMap.put(word, 1);
                } else {
                    // If we have seen this word before, just increment its count
                    wordMap.put( word, wordMap.get(word) + 1 );
                }
			}
        } // for word in words
        return numWords;
	}
	// 返回总的字符数。
	public int charStatistics(String paragraph){
        int numChars = 0;
        for(char c : paragraph.toUpperCase().toCharArray()){
        	if( c >= 'A' && c <= 'Z'){
				numChars ++;
				if (!charMap.containsKey(c)) {
                    // If we've never seen this word before, add it to the sorted list with a count of 1
					charMap.put(c, 1);
                } else {
                    // If we have seen this word before, just increment its count
                	charMap.put( c, charMap.get(c) + 1 );
                }
        	}
        }
        return numChars;
	}
	
}
