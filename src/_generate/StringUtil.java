package _generate;
import java.util.*;
public class StringUtil {
	public static ArrayList<String> tokenize(String s1){
		ArrayList<String> fin = new ArrayList();
		StringTokenizer st1 = new StringTokenizer(s1);
		for (;st1.hasMoreTokens();){
			fin.add(st1.nextToken());
		}
		return fin;
	}
	public static String removePunctuation(String s1){
		StringBuilder fin = new StringBuilder();
		for (int i = 0 ; i < s1.length(); i++){
			char cur = s1.charAt(i);
			if (Character.isAlphabetic(cur)){
				fin.append(cur);
			}
		}
		return fin.toString();
	}
	public static String canonize1(String s1){
		return removePunctuation(s1).toLowerCase();
	}
	public static boolean nonEmpty(String s1){
		for (int i = 0 ; i < s1.length(); i++){
			if (!Character.isWhitespace(s1.charAt(i))) return true;
		}
		return false;
	}
}
