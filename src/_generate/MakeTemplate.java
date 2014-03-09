/**
 * Run this class to generated the Main.java used. Note that all
 *  other classes in the other packages are converted to "private static"
 *  so that Eclipse's clean up function can remove them when not used.
 *  <br>
 * The includingFolders array should contain the name of the packages
 *  that are intended to be included in the constructed Main.java file.
 */
package _generate;

import java.util.*;
import java.io.*;


public class MakeTemplate {
	static String[] includingFolders = {
		"classicproblems",
		"datastructures",
		"debug",
		"dynamicprogramming",
		"geometry2d",
		"graphs",
		"util",
		"iterators",
		"miscellaneous",
		"networks",
		"numbertheory",
		"numericalrepresentations",
		"strings"
		};
	public static void main (String[] args){
		makeTemplate2();
	}
	public static void makeTemplate(){
		PrintWriter out = null;
		try {
			out = new PrintWriter("./output/Main.java","UTF-8");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for (String dir : includingFolders){
			File f1 = new File("./src/"+dir+"");
			
			for (File e: f1.listFiles()){
				if (!e.isDirectory()){
					String s1 = null;
					try {
						s1 = IOUtil.readFile(e.getAbsolutePath());
						s1 = CodeUtil.deleteComment(s1);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					out.println(getRawClassString(s1));
				}
			}
		}
		out.flush();
	}
	public static void makeTemplate2(){
		StringBuilder libString = new StringBuilder();
		for (String dir : includingFolders){
			File f1 = new File("./src/"+dir+"");
			
			for (File e: f1.listFiles()){
				if (!e.isDirectory()){
					String s1 = null;
					try {
						s1 = IOUtil.readFile(e.getAbsolutePath());
						s1 = CodeUtil.deleteComment(s1);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					libString.append(getRawClassString(s1) + "\n");
				}
			}
		}
		StringBuilder fin = new StringBuilder();
		String mainClass = null;
		try {
			mainClass = IOUtil.readFile("./src/_main/Main.java");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		int id1 = mainClass.indexOf(";") + 1;
		String mainString = mainClass.substring(id1, lastEndingBracketIndex(mainClass));
		mainString += libString.toString();
		mainString += "}";
		PrintWriter out = null;
		try {
			out = new PrintWriter("./output/Main.java","UTF-8");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		out.println(mainString);
		out.flush();
	}
	public static int lastEndingBracketIndex(String s1){
		int fin = -1;
		for (int i =0 ; i < s1.length(); i++){
			if (s1.charAt(i) == '}'){
				fin = i;
			}
		}
		return fin;
	}
	public static String getRawClassString(String s1){
		ArrayList<Integer> id = new ArrayList();
		int in = 0;
		for (int i = 0; i < s1.length(); i++){
			char cur = s1.charAt(i);
			if (cur == '{'){
				in++;
			}
			else if (cur == '}'){
				in--;
			}
			if (in == 0){
				if (cur == ';') id.add(i);
			}
		}
		id.add(s1.length());
		int ptr = -1;
		String[] l1 = new String[id.size()];
		for (int i = 0;i < id.size(); i++){
			l1[i] = s1.substring(ptr + 1, id.get(i));
			ptr = id.get(i);
		}
		for (String e: l1){
			if (e.contains("class")){
				int lim = e.indexOf("{");
				int f1 = e.indexOf("public");
				String fin = e;
				if (f1 + 6 <= lim){
					fin = "private static " + e.replaceFirst("public", "");
				}
				else {
					fin = "private static " + e;
				}
				return fin;
			}
		}
		return "";
	}
	public static String removePublic (String s1){
		StringTokenizer st = new StringTokenizer(s1);
		StringBuilder fin = new StringBuilder();
		String temp1 = st.nextToken();
		if (!temp1.equals("public")) fin.append(temp1);
		return fin.toString();
	}
}
