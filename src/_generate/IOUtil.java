package _generate;
import java.util.*;
import java.io.*;
public class IOUtil {
	public static String readFile(String fileName) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"));
		StringBuilder fin = new StringBuilder();
		for (;;){
			String nx = in.readLine();
			if (nx == null) break;
			fin.append(nx+"\n");
		}
		return fin.toString();
	}
	
	public static void writeFile(String fileName, String cont) throws Exception {
		PrintWriter f1 = new PrintWriter(fileName,"UTF-8");
		f1.write(cont);
		f1.flush();
	}
	
	public static void writeListFile(String fileName, ArrayList<String> list) throws Exception {
		PrintWriter f1 = new PrintWriter(fileName);
		for (String e: list){
			f1.println(e);
		}
		f1.flush();
	}
}
