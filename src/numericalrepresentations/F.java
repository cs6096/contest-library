package numericalrepresentations;
class F implements Comparable<F> {
	public static long gcd(long n1, long n2) {
		return n2 == 0 ? n1 : gcd(n2, n1 % n2);
	}

	public long a = 1, b = 1;

	public void cl() {
		long gcd = gcd(a, b);
		a /= gcd;
		b /= gcd;
		if (b < 0) {
			a *= -1l;
			b *= -1l;
		}
	}

	public F() {
	}

	public F(long t1) {
		a = t1;
	}

	public F(long t1, long b1) {
		a = t1;
		b = b1;
		cl();
	}

	public F add(F f1) {
		F fin = new F();
		fin.b = b * f1.b;
		fin.a = a * f1.b + f1.a * b;
		fin.cl();
		return fin;
	}

	public F sub(F f1) {
		F fin = new F();
		fin.b = b * f1.b;
		fin.a = a * f1.b - f1.a * b;
		fin.cl();
		return fin;
	}

	public F mult(F f1) {
		F fin = new F();
		fin.b = b * f1.b;
		fin.a = a * f1.a;
		fin.cl();
		return fin;
	}

	public F div(F f1) {
		if (f1.compareTo(F.ZERO) == 0) { throw new ArithmeticException(); }
		F fin = new F();
		fin.b = b * f1.a;
		fin.a = a * f1.b;
		fin.cl();
		return fin;
	}

	public F neg() {
		F fin = new F();
		fin.a = a * -1;
		fin.b = b;
		return fin;
	}

	public F inv() {
		F fin = new F();
		fin.a = b;
		fin.b = a;
		return fin;
	}

	public String toString() {
		return "(" + a + "/ " + b + ")";
	}

	@Override
	public int compareTo(F f1) {
		long self = a * f1.b;
		long it = f1.a * b;
		long diff = self - it;
		if (diff > 0) return 1;
		if (diff < 0) return -1;
		return 0;
	}

	public static final F ZERO = new F(0);
	public static final F ONE = new F(1);
	public static final F NEG = new F(-1);

	public F clone() {
		return new F(a,b);
	}

}