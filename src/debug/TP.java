
package debug;
import java.io.OutputStream;
import java.util.*;

import util.*;
import java.io.*;
public class TP {
	public static PrintStream out = System.out;
	public static void PLine(int len){
		for (int i = 0 ; i < len; i++){
			out.print('-');
		}
		out.println();
	}
	public static void PArrayInt(int[] l1){
		int max = Intz.decDigitNo(-1);
		for (int e: l1){
			max = Math.max(Intz.decDigitNo(e), max);
		}
		for (int i =0; i < l1.length; i++){
			max = Math.max(Intz.decDigitNo(i), max);
		}
		
		max++;
		String pat = "%"+max+"d";
		for (int i =0; i < l1.length; i++){
			out.printf(pat, i);
		}
		out.println();
		PLine(l1.length*max);
		for (int i =0; i < l1.length; i++){
			out.printf(pat, l1[i]);
		}
		out.println();
	}
	public static void PMatrixInt(int[][] l1){
		int max = Intz.decDigitNo(-1);
		for (int[] e: l1){
			for (int f: e){
				max = Math.max(Intz.decDigitNo(f), max);
			}
		}
		String pat = "%"+(max+1)+"d";
		
		for (int i =-1; i < l1[0].length; i++){
			System.out.printf(pat, i);
			if (i == -1) System.out.printf("|");
			
		}
		System.out.println();
		for (int i =-1; i < l1[0].length; i++){
			for (int j =0; j < max + 1; j++){
				System.out.print("-");
			}
			if (i == -1)System.out.print("+");
		}
		System.out.println();
		for (int i =0; i < l1.length; i++){
			System.out.printf(pat, i);
			System.out.printf("|");
			for (int j = 0; j < l1[i].length; j++){
				System.out.printf(pat, l1[i][j]);
			}
			System.out.println();
		}
	}
}
