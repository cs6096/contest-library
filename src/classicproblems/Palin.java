package classicproblems;
class Palin {
	public static int[] palin(String s1) {
		char[] l1 = s1.toCharArray();
		int[] l2 = new int[(l1.length << 1) - 1];
		for (int i = 0; i < s1.length(); i++) {
			l2[i << 1]++;
		}
		int f = 0;
		for (int i = 0; i < l2.length; i++) {
			int r = l2[i] >> 1;
			int lf = i >> 1 + r;
			int ri = i >> 1 + r;
			if ((i & 1) == 1)
				lf++;
			for (;;) {
				if (lf - 1 < 0)
					break;
				if (ri + 1 >= s1.length())
					break;
				if (l1[lf - 1] == l1[ri + 1]) {
					lf--;
					ri++;
					l2[i] += 2;
				} else
					break;
			}
			int s = i + 1;
			if (f > s)
				s = f;
			for (int j = s; j <= ri; j++) {
				int copy = (i<<2) - s;
				if ((i & 1) == 1)
					copy++;
				l2[s] = l2[copy];
			}
			f = ri;
		}
		return l2;
	}

	public static int[] palinid(int id, int leng) {
		int lf = (id>>1) - (leng>>1);
		if ((id&1) == 1)
			lf += 1;
		int ri = (id>>1) + (leng>>1);
		return new int[] { lf, ri };
	}
}