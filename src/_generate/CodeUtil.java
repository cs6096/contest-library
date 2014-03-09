package _generate;
import java.util.*;
import java.io.*;
public class CodeUtil {
	public static String deleteComment(String code) throws IOException {
		String cur = clearBlockComment(code);
		BufferedReader in = new BufferedReader(new StringReader(cur));
		StringBuilder fin = new StringBuilder();
		for (;;){
			String line = in.readLine();
			if (line == null) break;
			String clean = clearLineComment(line);
			if (StringUtil.nonEmpty(clean)){
				fin.append(clean);
				fin.append('\n');
			}
		}
		return fin.toString();
	}
	
	public static String clearBlockComment(String f1){
		StringBuilder fin = new StringBuilder();
		boolean include = true;
		for (int i = 0  ; i < f1.length(); i++){
			if (i < f1.length()-1){
				if (f1.charAt(i) == '/' && f1.charAt(i+1) == '*'){
					include = false;
				}
				else if (f1.charAt(i) == '*' && f1.charAt(i+1) == '/'){
					i++;
					include = true;
					continue;
				}
			}
			if (include) fin.append(f1.charAt(i));
		}
		return fin.toString();
	}
	
	public static String clearLineComment(String f1){
		boolean inQuote = false;
		int end = 0;
		for (int i = 0  ; i < f1.length(); i++){
			char c1 = f1.charAt(i);
			if (c1 == '"'){
				if (i == 0 || f1.charAt(i-1) != '\\'){
					inQuote = !inQuote;
				}
			}
			end = i + 1;
			if (inQuote) continue;
			if (i < f1.length()-1){
				if (c1 == '/' && f1.charAt(i+1) == '/'){
					end = i;
					break;
				}
			}
		}
		return f1.substring(0,end);
	}
	
	
}

