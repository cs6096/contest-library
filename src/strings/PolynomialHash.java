
package strings;

import util.Modz;
import numbertheory.NT;

import java.math.*;

import _main.Main;
public class PolynomialHash {
	public static long[] backupBases = {277, 281, 283, 293, 307};
	public long usingBase = 269;
	public long[] hashes;
	public long mod = 1_000_000_007l;
	public long inverse = -1;
	public PolynomialHash (String s1, long customBase){
		usingBase = customBase;
		this.initialize(s1);
	}
	public PolynomialHash (String s1){
		this.initialize(s1);
	}
	public void initialize(String s1){
		hashes = new long[s1.length() + 1];
		long cur = 0;
		long pow = 1;
		for (int i =0; i < s1.length(); i++){
			pow *= usingBase;
			pow %= mod;
			cur += (long)s1.charAt(i) * pow;
			cur %= mod;
			hashes[i + 1] = cur;
		}
		inverse = BigInteger.valueOf(usingBase)
				.modInverse(BigInteger.valueOf(mod)).longValue();
	}
	
	public long hashForPrefix(int n1){
		return hashes[n1];
	}
	
	public long hashForSubString(int inclusiveStart, int exclusiveEnd){
		long temp = Modz.subtract(hashes[exclusiveEnd], hashes[inclusiveStart], mod);
		long pow = Modz.pow(inverse, inclusiveStart, mod);
		return Modz.times(temp, pow, mod);
	}
}

