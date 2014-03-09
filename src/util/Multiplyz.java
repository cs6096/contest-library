
package util;
import java.util.*;
import java.math.*;

import _main.Main;

public class Multiplyz {
	public static BigInteger karatsuba(BigInteger n1, BigInteger n2) throws Exception {
		if (n1.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0
				&&
				n2.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0
				){
			long qwe1 = n1.longValue();
			long qwe2= n2.longValue();
			return BigInteger.valueOf(qwe1 * qwe2);
		}
		int dig1 = (n1.toString().length()>> 1) + 1;
		int dig2 = (n2.toString().length()>> 1) + 1;
		int finDig = Math.max(dig1, dig2);
		
		
		BigInteger mod1 = BigInteger.valueOf(10).pow(finDig);
		BigInteger x1 = n1.divide(mod1);
		BigInteger x0 = n1.mod(mod1);
		
		
		BigInteger y1 = n2.divide(mod1);
		BigInteger y0 = n2.mod(mod1);
		
		
		BigInteger z2 = karatsuba(x1, y1);
		BigInteger z0 = karatsuba(x0, y0);
		BigInteger f1 = x1.add(x0);
		BigInteger f2 = y1.add(y0);
		BigInteger z1 = karatsuba(f1, f2).subtract(z2).subtract(z0);
		
//		Main.px(n1,n2,f1,f2);
		BigInteger w2 = z2.multiply(mod1).multiply(mod1);
		BigInteger w1 = z1.multiply(mod1);
		BigInteger w0 = z0;
		
		return w2.add(w1).add(w0);
	}
}
