package util;
import java.util.*;
import java.io.*;
import java.math.*;

public class Stringz {
	public static boolean isSubsequence(CharSequence checking, CharSequence pattern){
		int ptr = 0;
		for (int i =0; i < checking.length(); i++){
			if (ptr >= pattern.length()) break;
			if (checking.charAt(i) == pattern.charAt(ptr)){
				ptr++;
			}
		}
		return ptr == pattern.length();
	}
}
