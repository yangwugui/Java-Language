package ruandao.text;

import java.util.*;

public class TextParagraph {

	// һ��Ӣ�ģ�
	// 1. ͳ�Ƴ����˵��ٵ��ʣ�ÿ�����ʳ��ֵĴ��������Ұ�ͳ�ƽ����ӡ������
	// 2. ͳ��26����ĸ����λ��еĳ��ִ��������Ұ�ͳ�ƽ����ӡ������
	public static void main(String[] args) {
		TextParagraph tp = new TextParagraph();
		String paragraph = "SortedMap<String, Integer> wordMap = new "
				+ "TreeMap<String,Integer>();SortedMap<Character, Integer>"
				+ " charMap = new TreeMap<Character,Integer>()";
		
		int numWords = tp.wordStatistics(paragraph);
		
		System.out.println("һ����" + numWords + "�����ʡ�");
		for(String key: tp.wordMap.keySet()){
			System.out.println(key + ": " + tp.wordMap.get(key));
		}
		
		int numChars = tp.charStatistics(paragraph);
		
		System.out.println("һ����" + numChars + "����ĸ��");
		for(char key: tp.charMap.keySet()){
			System.out.println(key + ": " + tp.charMap.get(key));
		}
	}

	SortedMap<String, Integer> wordMap = new TreeMap<String,Integer>();
	SortedMap<Character, Integer> charMap = new TreeMap<Character,Integer>(); 
	
	// �����ܵ��ַ�����
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
	// �����ܵ��ַ�����
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
