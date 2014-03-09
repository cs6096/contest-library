
import java.util.*;
import java.math.*;
import java.io.*;
public class Main {
	public static long time = 0;
	public static void main(String[] args) throws Exception {
		time = System.currentTimeMillis();
		
		IN = System.in;
		OUT = System.out;
		in = new BufferedReader(new InputStreamReader(IN));
		out = new PrintWriter(OUT, FLUSH);
		solveOne();
		out.flush();
	}
	
	public static void solveOne() throws Exception {
		
	}
	
	public static void solveTwo() throws Exception {
		
	}
	
	public static void solveThree() throws Exception {
		
	}
	
	public static BufferedReader in;
	public static StringTokenizer st;
	public static InputStream IN;
	public static OutputStream OUT;
	public static String nx() throws Exception {
		for (;st == null || !st.hasMoreTokens();){
			String k1 = in.readLine();
			if (k1 == null) return null;
			st = new StringTokenizer(k1);
		}
		return st.nextToken();
	}
	public static int ni () throws Exception {
		return Integer.parseInt(nx());
	}
	public static long nl() throws Exception{
		return Long.parseLong(nx());
	}
	public static double nd() throws Exception{
		return Double.parseDouble(nx());
	}
	private static int[] nil(int n1) throws Exception {
		int[] l1 = new int[n1];
		for (int i = 0 ;i < n1; i++){
			l1[i] = ni();
		}
		return l1;
	}
	private static long[] nll(int n1) throws Exception {
		long[] l1 = new long[n1];
		for (int i = 0 ;i < n1; i++){
			l1[i] = nl();
		}
		return l1;
	}
	private static int[][] nill(int x, int y) throws Exception {
		int[][] l1 = new int[x][y];
		for (int i =0; i < x; i++){
			for (int j = 0; j < y; j++){
				l1[i][j] = ni();
			}
		}
		return l1;
	}
	public static void px(Object ... l1){
		System.out.println(Arrays.deepToString(l1));
	}
	public static boolean FLUSH = false;
	public static PrintWriter out;
	public static void p(Object ... l1){
		for (int i = 0; i < l1.length; i++){
			if (i != 0) out.print(' ');
			out.print(l1[i].toString());
		}
	}
	public static void pn(Object ... l1){
		for (int i = 0; i < l1.length; i++){
			if (i != 0) out.print(' ');
			out.print(l1[i].toString());
		}
		out.println();
	}
	
	public static void pn(Collection l1){
		boolean first = true;
		for (Object e: l1){
			if (first) first = false;
			else out.print(' ');
			out.print(e.toString());
		}
		out.println();
	}
	
	private static BigInteger bi(long n1){
		return BigInteger.valueOf(n1);
	}
	
	private static double usedTime(){
		return (System.currentTimeMillis()-time)*0.001;
	}
	
	
	
private static package classicproblems
private static package classicproblems
private static package classicproblems
private static 
 class BIT {
	int[] vs;
	public BIT (int n){
		vs = new int[n+1];
	}
	public void add(int idx, int n1){
		for (int i = idx + 1; i < vs.length; i += i & -i){
			vs[i] += n1;
		}
	}
	public int sum(int t){
		return sum(0, t);
	}
	public int sum(int s, int t){
		if (s > 0) return sum(0,t)-sum(0,s);
		int res = 0;
		for (int i = t; i > 0; i -= i & -i){
			res += vs[i];
		}
		return res;
	}
	@Override
	public String toString(){
		List<Integer> fin = new ArrayList();
		for (int i =0; i < vs.length-1; i++){
			fin.add(sum(0,i+1)-sum(0,i));
		}
		return fin.toString();
	}
	public String sumString(){
		List<Integer> fin = new ArrayList();
		for (int i =0; i < vs.length-1; i++){
			fin.add(sum(0,i+1));
		}
		return fin.toString();
	}
}

private static 
 class BitSet {
	public long[] cont = null;
}

private static 
 class CS <E> {
	Map<E, Integer> m1 = new HashMap();
	void add(E o1, int n1){
		m1.put(o1, m1.containsKey(o1) ? m1.get(o1)+n1 : n1);
	}
	int get(E o1){
		return m1.get(o1) == null ? 0 : m1.get(o1);
	}
	Map<Integer, ArrayList<E>> reverse(){
		Map<Integer,ArrayList<E>> fin = new HashMap();
		for (E e: m1.keySet()){
			int cur = m1.get(e);
			ArrayList<E> cur2 = fin.get(cur);
			if (cur2 == null) cur2 = new ArrayList();
			cur2.add(e);
			fin.put(cur, cur2);
		}
		return fin;
	}
}

private static 
 class DisjointUnionSet {
	int[] parent;
	int[] rank;
	DisjointUnionSet (int length){
		parent = new int[length];
		rank = new int[length];
		for (int i= 0 ; i < length; i++) parent[i] = i;
	}
	int getPartitionId(int x){
		if (parent[x] != x) parent[x] = getPartitionId(parent[x]);
		return parent[x];
	}
	void unionElement(int x, int y){
		int k1 = getPartitionId(x);
		int k2 = getPartitionId(y);
		if (k1 == k2) return;
		if (rank[k1] < rank[k2]) parent[k1] = k2;
		else if (rank[k1] > rank[k2]) parent[k2] = k1;
		else{
			parent[y] = k1;
			rank[k1]++;
		}
	}
}

private static 
 class DoubleL implements Iterable<Double>{
	public double[] cont;
	public int size = 0;
	public DoubleL(){
		cont = new double[8];
	}
	public DoubleL (int initialCapacity){
		cont = new double[initialCapacity];
	}
	public void add(double v1){
		if (size == cont.length) cont = Arrays.copyOf(cont, size << 1);
		cont[size++] = v1;
	}
	public double get(int idx){
		if (idx >= 0) return cont[idx];
		return cont[size + idx];
	}
	public double last(){
		return cont[size - 1];
	}
	public double pop(){
		size--;
		return cont[size];
	}
	public void sort(){
		Shuffle.doubles(cont, 0, size);
		Arrays.sort(cont, 0, size);
	}
	public int binarySearch(double v1){
		return Arrays.binarySearch(cont, 0, size, v1);
	}
	public void reverse(){
		for (int i = 0; i < size / 2; i++) {
			double temp = cont[i];
			cont[i] = cont[size - 1 - i];
			cont[size - 1 - i] = temp;
		}
	}
	public double[] toPrimitiveArray(){
		return Arrays.copyOf(cont, size);
	}
	public boolean contains(double v1){
		for (double e: cont){
			if (e == v1) return true;
		}
		return false;
	}
	public int size(){
		return size;
	}
	public String toString() {
		StringBuilder fin = new StringBuilder();
		fin.append('{');
		for (int i = 0; i < size; i++) {
			if (i != 0) fin.append(", ");
			fin.append(String.format("%.6f", cont[i]));
		}
		fin.append('}');
		return fin.toString();
	}
	@Override
	public Iterator<Double> iterator() {
		return new It();
	}
	public class It implements Iterator<Double> {
		private int ptr = 0;
		@Override
		public boolean hasNext() {
			if (ptr < size) return true;
			return false;
		}
		@Override
		public Double next() {
			return cont[ptr++];
		}
		@Override
		public void remove() {}
	}
}

private static 
 class GeneralDisjoinUnionSet<E> {
		public HashMap<E, Integer> mapping = new HashMap();
		public ArrayList<E> value = new ArrayList();
		public IntL p = new IntL();
		public IntL size = new IntL();
		public int n = 0;
		public void add(E k1) {
			if (!mapping.containsKey(k1)) {
				mapping.put(k1, n);
				value.add(k1);
				p.add(n);
				size.add(1);
				n++;
			}
		}
		public int find(int x) {
			if (p.get(x) == x)
				return x;
			else
				return find(p.get(x));
		}
		public void union(E k1, E k2) {
			if (!mapping.containsKey(k1)) add(k1);
			if (!mapping.containsKey(k2)) add(k2);
			int s1 = mapping.get(k1);
			int s2 = mapping.get(k2);
			int r1 = find(s1);
			int r2 = find(s2);
			if (r1 == r2) return;
			if (size.get(r1) >= size.get(r2)) {
				size.set(r1, size.get(r1) + size.get(r2));
				p.set(r2, r1);
			}
			else {
				size.set(r2, size.get(r1) + size.get(r2));
				p.set(r1, r2);
			}
		}
		public void debugPrint() {
			System.out.println("value\n" + value);
			System.out.println("p\n" + p);
			System.out.println("size\n" + size);
		}
		public HashMap<Integer, ArrayList<E>> partitions() {
			HashMap<Integer, ArrayList<E>> temp1 = new HashMap();
			for (int i = 0; i < p.size(); i++) {
				int classNo = find(i);
				if (!temp1.containsKey(classNo))
					temp1.put(classNo, new ArrayList());
				ArrayList curList = temp1.get(classNo);
				curList.add(value.get(i));
			}
			return temp1;
		}
	}

private static 
class IntInterval {
	int[] sum = null;
	IntInterval (int[] l1){
		sum = new int[l1.length+1];
		int cur = 0;
		for (int i = 1; i <= l1.length ; i++){
			cur += l1[i-1];
			sum[i] = cur;
		}
	}
	int get(int n1){
		return sum[n1];
	}
	int range(int left, int right){
		return get(right) - get(left);
	}
}

private static 
 class IntL implements Iterable<Integer> {
	public static IntL empty(int n1) {
		IntL fin = new IntL(n1);
		fin.size = n1;
		return fin;
	}
	public static IntL wrap(int[] l1) {
		IntL fin = new IntL();
		fin.cont = l1;
		fin.size = l1.length;
		return fin;
	}
	public int[] cont = null;
	public int size = 0;
	public IntL(int initialCapacity) {
		this.cont = new int[initialCapacity];
	}
	public IntL() {
		this(5);
	}
	public void add(int e) {
		if (size == cont.length) {
			cont = Arrays.copyOf(cont, ((cont.length * 3) >> 1) + 1);
		}
		cont[size++] = e;
	}
	public int get(int id) {
		if (id >= 0) return cont[id];
		else return cont[size + id];
	}
	public void inc(int id, int v1) {
		if (id >= 0) cont[id] += v1;
		else cont[size + id] += v1;
	}
	public void set(int id, int v1) {
		if (id >= 0) cont[id] = v1;
		else cont[size + id] = v1;
	}
	public int last() {
		return cont[size - 1];
	}
	public int pop() {
		size--;
		return cont[size];
	}
	public void pop(int n1) {
		size -= n1;
		if (size < 0) size = 0;
	}
	public void sort() {
		Shuffle.ints(cont, 0, size);
		Arrays.sort(cont, 0, size);
	}
	public int binarySearch(int v1) {
		return Arrays.binarySearch(cont, 0, size, v1);
	}
	public int smallerNo(int n1) {
		if (cont[0] >= n1) return 0;
		if (cont[size - 1] < n1) return size;
		int low = 0;
		int high = size - 1;
		for (; high - low > 1;) {
			int mid = (high + low) >> 1;
			if (cont[mid] >= n1) high = mid;
			else if (cont[mid] < n1) low = mid;
		}
		return low + 1;
	}
	public int greaterNo(int n1) {
		if (cont[size - 1] <= n1) return 0;
		if (cont[0] > n1) return size;
		int low = 0;
		int high = size - 1;
		for (; high - low > 1;) {
			int mid = (high + low) >> 1;
			if (cont[mid] > n1) high = mid;
			else if (cont[mid] <= n1) low = mid;
		}
		return size - high;
	}
	public int equalNo(int n1) {
		return size - smallerNo(n1) - greaterNo(n1);
	}
	public int[] toPrimitiveArray() {
		return Arrays.copyOf(cont, size);
	}
	public void reverse() {
		for (int i = 0; i < size / 2; i++) {
			int temp = cont[i];
			cont[i] = cont[size - 1 - i];
			cont[size - 1 - i] = temp;
		}
	}
	public String seqString() {
		StringBuilder fin = new StringBuilder();
		for (int i = 0; i < size; i++) {
			if (i != 0) fin.append(' ');
			fin.append(cont[i]);
		}
		return fin.toString();
	}
	@Override
	public String toString() {
		StringBuilder fin = new StringBuilder();
		fin.append('{');
		for (int i = 0; i < size; i++) {
			if (i != 0) fin.append(", ");
			fin.append(cont[i]);
		}
		fin.append('}');
		return fin.toString();
	}
	public String toSpacedString(){
		StringBuilder fin = new StringBuilder();
		for (int i = 0; i < size; i++) {
			if (i != 0) fin.append(" ");
			fin.append(cont[i]);
		}
		return fin.toString();
	}
	public int contains(int n1) {
		for (int i = 0; i < size; i++) {
			if (cont[i] == n1) { return i; }
		}
		return -1;
	}
	public int size() {
		return size;
	}
	public int max (){
		int fin = Integer.MIN_VALUE;
		for (int e: cont) if (e > fin) fin = e;
		return fin;
	}
	public int min (){
		int fin = Integer.MAX_VALUE;
		for (int e: cont) if (e < fin) fin = e;
		return fin;
	}
	@Override
	public Iterator<Integer> iterator() {
		return new It();
	}
	public class It implements Iterator<Integer> {
		private int ptr = 0;
		@Override
		public boolean hasNext() {
			if (ptr < size) return true;
			return false;
		}
		@Override
		public Integer next() {
			return cont[ptr++];
		}
		@Override
		public void remove() {
		}
	}
}

private static 
class LongInterval {
	long[] sum = null;
	LongInterval (int[] l1){
		sum = new long[l1.length+1];
		long cur = 0;
		for (int i = 1; i <= l1.length ; i++){
			cur += (long)l1[i-1];
			sum[i] = cur;
		}
	}
	long get(int n1){
		return sum[n1];
	}
	long range(int left, int right){
		return get(right) - get(left);
	}
}

private static 
 class LongL implements Iterable<Long> {
		public long[] cont = null;
		public int size = 0;
		public LongL(int initialCapacity) {
			this.cont = new long[initialCapacity];
		}
		public static LongL empty(int n1) {
			LongL fin = new LongL(n1);
			fin.size = n1;
			return fin;
		}
		public static LongL wrap(long[] l1){
			LongL fin = new LongL();
			fin.cont = l1;
			fin.size = l1.length;
			return fin;
		}
		public LongL() {
			this(5);
		}
		public void add(long e) {
			if (size == cont.length) {
				cont = Arrays.copyOf(cont, ((cont.length * 3) >> 1) + 1);
			}
			cont[size++] = e;
		}
		public long get(int id) {
			if (id >= 0)
				return cont[id];
			else
				return cont[size + id];
		}
		public void inc(int id, long v1) {
			if (id >= 0)
				cont[id] += v1;
			else
				cont[size + id] += v1;
		}
		public void set(int id, long v1) {
			if (id >= 0)
				cont[id] = v1;
			else
				cont[size + id] = v1;
		}
		public long last() {
			return cont[size - 1];
		}
		public long pop() {
			size--;
			return cont[size];
		}
		public void pop(int n1) {
			size -= n1;
			if (size < 0) size = 0;
		}
		public void sort(){
			Shuffle.longs(cont, 0, size);
			Arrays.sort(cont, 0, size);
		}
		public int binarySearch(long v1){
			return Arrays.binarySearch(cont, 0, size, v1);
		}
		public int smallerNo(long n1){
			if (cont[0] >= n1) return 0;
			if (cont[size - 1] < n1) return size;
			int low = 0;
			int high = size - 1;
			for (;high - low > 1;){
				int mid = (high + low) >> 1;
				if (cont[mid] >= n1) high = mid;
				else if (cont[mid] < n1) low = mid;
			}
			return low + 1;
		}
		public int greaterNo(long n1){
			if (cont[size - 1] <= n1){
				return 0;
			}
			int low = 0;
			int high = size - 1;
			for (;high - low > 1;){
				int mid = (high + low) >> 1;
				if (cont[mid] > n1) high = mid;
				else if (cont[mid] <= n1) low = mid;
			}
			return size - high;
		}
		public long[] arrayForm() {
			return Arrays.copyOf(cont, size);
		}
		public void reverse(){
			for (int i =0; i < size/2; i++){
				long temp = cont[i];
				cont[i] = cont[size - 1 -i];
				cont[size - 1 -i] = temp;
			}
		}
		public String seqString(){
			StringBuilder fin = new StringBuilder();
			for (int i = 0; i < size; i++) {
				if (i != 0) fin.append(' ');
				fin.append(cont[i]);
			}
			return fin.toString();
		}
		@Override
		public String toString() {
			StringBuilder fin = new StringBuilder();
			fin.append('{');
			for (int i = 0; i < size; i++) {
				if (i != 0) fin.append(", ");
				fin.append(cont[i]);
			}
			fin.append('}');
			return fin.toString();
		}
		public int contains(int n1){
			for (int i = 0; i < size; i++){
				if (cont[i] == n1){
					return i;
				}
			}
			return -1;
		}
		public int size(){
			return size;
		}
		@Override
		public Iterator<Long> iterator() {
			return new It();
		}
		public class It implements Iterator<Long> {
			int ptr = 0;
			@Override
			public boolean hasNext() {
				if (ptr < size) return true;
				return false;
			}
			@Override
			public Long next() {
				long fin = cont[ptr];
				ptr++;
				return fin;
			}
			@Override
			public void remove() {
			}
		}
	}

private static 
class OldSegmentTree{
		public static long assoc(long n1, long n2){
			return n1 + n2;
		}
		int size = -1;
		long[] nodeValue = null;
		public OldSegmentTree(int n1){
			nodeValue = new long[n1*4+4];
			size = n1;
		}
		public IntL getComposingIntervals(int left, int right){
			IntL fin = new IntL();
			getComposingIntervals(left, right, 0, 0, size-1, fin);
			return fin;
		}
		public void getComposingIntervals(int left, int right, int at, int currentLeft, int currentRight, IntL bag){
			if (currentLeft > right || currentRight < left) return;
			if (currentLeft >= left && currentRight <= right){
				bag.add(at);
				return;
			}
			int bound = currentRight - ((currentRight-currentLeft+1)>>1);
			getComposingIntervals(left, right, (at<<1)+1, currentLeft, bound, bag);
			getComposingIntervals(left, right, (at<<1)+2, bound+1, currentRight, bag);
		}
		public int locateIndexSource(int n1){
			return locateIndexSource(n1, 0, size-1, 0);
		}
		public int locateIndexSource(int n1, int left, int right,int cur){
			if (left == right) return cur;
			int range = right - left + 1;
			int half = range >> 1;
			int bound = right - half;
			if (n1 <= bound) return locateIndexSource(n1, left, bound, (cur << 1)+1);
			else return locateIndexSource(n1, bound+1, right, (cur << 1)+2);
		}
		public void update(int index, long value){
			int ptr = locateIndexSource(index);
			nodeValue[ptr] = value;
			for (;;){
				if (ptr == 0) break;
				ptr = (ptr - 1)>>1;
				refreshNodeValue(ptr);
			}
		}
		public long rangeProduct(int left, int right){
			IntL intervals = getComposingIntervals(left, right);
			long fin = intervals.get(0);
			for (int i = 1; i < intervals.size(); i++){
				fin = mergedProductValue(fin, nodeValue[intervals.get(i)]);
			}
			return fin;
		}
		public long mergedProductValue(long value1, long value2) {
			return value1 + value2;
		}
		public void refreshNodeValue(int nodeIndex) {
			nodeValue[nodeIndex] = nodeValue[(nodeIndex << 1) + 1] + nodeValue[(nodeIndex << 1) + 2];
		}
	}

private static 
 class RMQ {
	public static int assoc(int n1, int n2){
		return Math.max(n1, n2);
	}
	public static int NULLVAL = Integer.MIN_VALUE;
	public class N {
		N parent = null;
		N q1 = null, q2 = null;
		int left = 0;
		int right = 0;
		int val = 0;
		void generate() {
			if (left == right) {
				unit[left] = this;
				return;
			}
			int len = right - left + 1;
			int half = len >> 1;
			q1 = new N();
			q1.left = left;
			q1.right = left + half - 1;
			q1.parent = this;
			q2 = new N();
			q2.left = left + half;
			q2.right = right;
			q2.parent = this;
			q1.generate();
			q2.generate();
		}
		void refresh() {
			val = assoc(q1.val,q2.val);
			if (parent != null) parent.refresh();
		}
		public int find(int fleft, int fright) {
			if (fleft <= left && fright >= right) return val;
			int res = NULLVAL;
			if (fleft <= q1.right) res = assoc(res, q1.find(fleft, fright));
			if (fright >= q2.left) res = assoc(res, q2.find(fleft, fright));
			return res;
		}
	}
	N root = null;
	int size = 0;
	N[] unit = null;
	public RMQ(int n1) {
		size = n1;
		root = new N();
		root.left = 0;
		root.right = size - 1;
		unit = new N[size];
		root.generate();
	}
	void set(int idx, int k1){
		unit[idx].val = k1;
		if (unit[idx].parent != null)unit[idx].parent.refresh();
	}
	public int find(int fleft, int fright) {
		return root.find(fleft, fright);
	}
}

private static 
 abstract class SegmentTree {
	public static class MinTree extends SegmentTree {
		public MinTree(int size) {
			super(size);
		}
		@Override
		public long mergedProductValue(long value1, long value2) {
			return Math.min(value1, value2);
		}
		@Override
		public void refreshNodeValue(int nodeIndex) {
			nodeValue[nodeIndex] = mergedProductValue(nodeValue[(nodeIndex << 1) + 1], nodeValue[(nodeIndex << 1) + 2]);
		}
	}
	public static class MaxTree extends SegmentTree {
		public MaxTree(int size) {
			super(size);
		}
		@Override
		public long mergedProductValue(long value1, long value2) {
			return Math.max(value1, value2);
		}
		@Override
		public void refreshNodeValue(int nodeIndex) {
			nodeValue[nodeIndex] = mergedProductValue(nodeValue[(nodeIndex << 1) + 1], nodeValue[(nodeIndex << 1) + 2]);
		}
	}
	public static class SumTree extends SegmentTree {
		public SumTree(int size) {
			super(size);
		}
		@Override
		public long mergedProductValue(long value1, long value2) {
			return value1 + value2;
		}
		@Override
		public void refreshNodeValue(int nodeIndex) {
			nodeValue[nodeIndex] = mergedProductValue(nodeValue[(nodeIndex << 1) + 1], nodeValue[(nodeIndex << 1) + 2]);
		}
	}
	public abstract long mergedProductValue(long value1, long value2);
	public abstract void refreshNodeValue(int nodeIndex);
	public long[] nodeValue;
	public int arraySize;
	public SegmentTree(int size){
		nodeValue = new long[(size + 4) * 4];
		arraySize = size;
	}
	public void setArrayValueAtIndex(int arrayIndex, long value){
		setArrayValueAtIndex(arrayIndex, value, 0, arraySize - 1, 0);
	}
	public void setArrayValueAtIndex(int arrayIndex, long newValue,int currentLeft, int currentRight, int currentNodeIndex){
		if (currentLeft == currentRight){
			nodeValue[currentNodeIndex] = newValue;
			return;
		}
		int leftChildRangeEnd = ((currentRight + currentLeft) >> 1);
		if (arrayIndex <= leftChildRangeEnd){
			setArrayValueAtIndex(arrayIndex, newValue, currentLeft, leftChildRangeEnd, (currentNodeIndex << 1) + 1);
		}
		else {
			setArrayValueAtIndex(arrayIndex, newValue, leftChildRangeEnd + 1, currentRight, (currentNodeIndex << 1) + 2);
		}
		refreshNodeValue(currentNodeIndex);
	}
	public long rangeProduct(int queryLeft, int queryRight){
		return rangeProduct(queryLeft, queryRight, 0, arraySize - 1, 0);
	}
	public long rangeProduct(int queryLeft, int queryRight, int currentLeft, int currentRight, int currentNodeIndex){
		if (currentLeft >= queryLeft && currentRight <= queryRight){
			return nodeValue[currentNodeIndex];
		}
		int leftChildRangeEnd = ((currentRight + currentLeft) >> 1);
		if (queryLeft <= leftChildRangeEnd && queryRight > leftChildRangeEnd){
			return mergedProductValue(
					rangeProduct(queryLeft, queryRight, currentLeft, leftChildRangeEnd, (currentNodeIndex << 1) + 1),
					rangeProduct(queryLeft, queryRight, leftChildRangeEnd + 1, currentRight, (currentNodeIndex << 1) + 2)
					);
		}
		else if (queryRight <= leftChildRangeEnd){
			return rangeProduct(queryLeft, queryRight, currentLeft, leftChildRangeEnd, (currentNodeIndex << 1) + 1);
		}
		else {
			return rangeProduct(queryLeft, queryRight, leftChildRangeEnd + 1, currentRight, (currentNodeIndex << 1) + 2);
		}
	}
	public String prefixProductString(){
		StringBuilder fin = new StringBuilder();
		fin.append("{");
		for (int i = 0 ;  i < arraySize; i++){
			if (i != 0) fin.append(", ");
			fin.append(rangeProduct(0, i));
		}
		fin.append("}");
		return fin.toString();
	}
	public String toString(){
		StringBuilder fin = new StringBuilder();
		fin.append("{");
		for (int i = 0 ;  i < arraySize; i++){
			if (i != 0) fin.append(", ");
			fin.append(rangeProduct(i, i));
		}
		fin.append("}");
		return fin.toString();
	}
}

private static 
 class SuffixArray {
	static class Comp implements Comparator<Integer>{
		CharSequence str = null;
		@Override
		public int compare(Integer o1, Integer o2) {
			return Character.compare(str.charAt(o1), str.charAt(o2));
		}
	}
	static Comp comp1 = new Comp();
  public static int[] suffixArray(CharSequence str) {
    int n = str.length();
    Integer[] order = new Integer[n];
    for (int i = 0; i < n; i++)
      order[i] = n - 1 - i;
    comp1.str = str;
    Arrays.sort(order, comp1);
    int[] sa = new int[n];
    int[] rank = new int[n];
    for (int i = 0; i < n; i++) {
      sa[i] = order[i];
      rank[i] = str.charAt(i);
    }
    for (int len = 1; len < n; len *= 2) {
      int[] r = rank.clone();
      for (int i = 0; i < n; i++) {
        rank[sa[i]] = i > 0 && r[sa[i - 1]] == r[sa[i]] && sa[i - 1] + len < n && r[sa[i - 1] + len / 2] == r[sa[i] + len / 2] ? rank[sa[i - 1]] : i;
      }
      int[] cnt = new int[n];
      for (int i = 0; i < n; i++)
        cnt[i] = i;
      int[] s = sa.clone();
      for (int i = 0; i < n; i++) {
        int s1 = s[i] - len;
        if (s1 >= 0)
          sa[cnt[rank[s1]]++] = s1;
      }
    }
    return sa;
  }
  public static int[] lcp(int[] sa, CharSequence s) {
    int n = sa.length;
    int[] rank = new int[n];
    for (int i = 0; i < n; i++)
      rank[sa[i]] = i;
    int[] lcp = new int[n - 1];
    for (int i = 0, h = 0; i < n; i++) {
      if (rank[i] < n - 1) {
        for (int j = sa[rank[i] + 1]; Math.max(i, j) + h < s.length() && s.charAt(i + h) == s.charAt(j + h); ++h)
          ;
        lcp[rank[i]] = h;
        if (h > 0)
          --h;
      }
    }
    return lcp;
  }
  public static void test(String[] args) {
    String s1 = "abcab";
    int[] sa1 = suffixArray(s1);
    for (int p : sa1)
      System.out.println(s1.substring(p));
    System.out.println("lcp = " + Arrays.toString(lcp(sa1, s1)));
    Random rnd = new Random(1);
    for (int step = 0; step < 100000; step++) {
      int n = rnd.nextInt(100) + 1;
      StringBuilder s = new StringBuilder();
      for (int i = 0; i < n; i++)
        s.append((char) ('\0' + rnd.nextInt(10)));
      int[] sa = suffixArray(s);
      int[] lcp = lcp(sa, s);
      for (int i = 0; i + 1 < n; i++) {
        String a = s.substring(sa[i]);
        String b = s.substring(sa[i + 1]);
        if (a.compareTo(b) >= 0
            || !a.substring(0, lcp[i]).equals(b.substring(0, lcp[i]))
            || (a + " ").charAt(lcp[i]) == (b + " ").charAt(lcp[i]))
          throw new RuntimeException("error");
      }
    }
    System.out.println("Test passed");
  }
}

private static 
 class SuffixArray2 {
	static class RankComp implements Comparator<Integer> {
		long[] rank = null;
		@Override
		public int compare(Integer a, Integer b) {
			return Long.compare(rank[a], rank[b]);
		}
	}
	static RankComp c1 = new RankComp();
	public static Integer[] suffixArray(CharSequence s) {
		int n = s.length();
		Integer[] sa = new Integer[n];
		int[] rank = new int[n];
		for (int i = 0; i < n; i++) {
			sa[i] = i;
			rank[i] = s.charAt(i);
		}
		for (int len = 1; len < n; len *= 2) {
			long[] rank2 = new long[n];
			for (int i = 0; i < n; i++)
				rank2[i] = ((long) rank[i] << 32) + (i + len < n ? rank[i + len] + 1 : 0);
			c1.rank = rank2;
			Arrays.sort(sa, c1);
			for (int i = 0; i < n; i++)
				rank[sa[i]] = i > 0 && rank2[sa[i - 1]] == rank2[sa[i]] ? rank[sa[i - 1]] : i;
		}
		return sa;
	}
	public static void main(String[] args) {
		String s1 = "abcab";
		Integer[] sa1 = suffixArray(s1);
		for (Integer p : sa1)
			System.out.println(s1.substring(p));
		Random rnd = new Random(1);
		for (int step = 0; step < 100000; step++) {
			int n = rnd.nextInt(100);
			StringBuilder s = new StringBuilder();
			for (int i = 0; i < n; i++)
				s.append((char) ('\0' + rnd.nextInt(10)));
			Integer[] sa = suffixArray(s);
			for (int i = 0; i + 1 < n; i++)
				if (s.substring(sa[i]).compareTo(s.substring(sa[i + 1])) >= 0) throw new RuntimeException("error");
		}
		System.out.println("Test passed");
	}
}

private static 
class SumSegT {
		int size = -1;
		long[] cont = null;
		long[] excess = null;
		long[] lengths = null;
		public SumSegT(int n1){
			cont = new long[n1*4+4];
			excess = new long[n1*4+4];
			lengths = new long[n1*4+4];
			size = n1;
			genLength();
		}
		public void genLength(){
			genLengthRec(0, size);
		}
		public void genLengthRec(int at, long curLength){
			lengths[at] = curLength;
			if (curLength == 1) return;
			long bound = curLength - (curLength>>1);
			genLengthRec((at<<1)+1, bound);
			genLengthRec((at<<1)+2, curLength>>1);
		}
		public long valueAt(int n1){
			return cont[n1]+excess[n1];
		}
		public void propagate(int idx){
			if (excess[idx] != 0) if (lengths[idx] != 1){
				long unit = excess[idx] / lengths[idx];
				excess[(idx<<1)+1]+=unit * lengths[(idx<<1)+1];
				excess[(idx<<1)+2]+=unit * lengths[(idx<<1)+2];
				cont[idx] += excess[idx];
				excess[idx] = 0;
			}
		}
		public int loc(int n1){
			return loc(n1, 0, size-1, 0);
		}
		public int loc(int n1, int left, int right,int cur){
			if (left == right) return cur;
			int range = right - left + 1;
			int half = range >> 1;
			int bound = right - half;
			if (n1 <= bound) return loc(n1, left, bound, (cur << 1)+1);
			else return loc(n1, bound+1, right, (cur << 1)+2);
		}
		public void refresh(int n1){
			cont[n1] =  valueAt((n1 << 1) + 1) + valueAt((n1 << 1) + 2);
		}
		public void add(int n1){
			add(n1,1);
		}
		public void add(int n1, long k1){
			int ptr = loc(n1);
			cont[ptr] += k1;
			for (;;){
				if (ptr == 0) break;
				ptr = (ptr - 1)>>1;
				refresh(ptr);
			}
		}
		public void lazyAdd(int idx, long length, long val){
			if (length == 1){
				cont[idx] += val*length;
				refreshUp(idx);
			}
			else {
				excess[idx] += val*length;
				refreshUp(idx);
			}
		}
		public void rangeAdd(int left, int right, long val){
			IntL intervals = getIntervals(left, right);
			for (int i = 0; i< intervals.size>>1; i++){
				lazyAdd(intervals.get(i<<1), intervals.get((i<<1)+1), val);
			}
		}
		public void refreshUp(int idx){
			int ptr = idx;
			for (;;){
				if (ptr == 0) break;
				ptr = (ptr - 1)>>1;
				refresh(ptr);
			}
		}
		public long sum(int left, int right){
			IntL intervals = getIntervals(left, right);
			long fin = 0;
			for (int i = 0; i < intervals.size >> 1;i++){
				fin += valueAt(intervals.get(i<<1));
			}
			return fin;
		}
		public IntL getIntervals(int left, int right){
			IntL fin = new IntL();
			getIntervals(left, right, 0, 0, size-1, fin);
			return fin;
		}
		public void getIntervals(int left, int right, int at, int atLeft, int atRight, IntL bag){
			int length =atRight-atLeft+1;
			if (length > 1) propagate(at);
			if (atLeft > right || atRight < left) return;
			if (atLeft >= left && atRight <= right){
				bag.add(at);
				bag.add(length);
				return;
			}
			int bound = atRight - ((atRight-atLeft+1)>>1);
			getIntervals(left, right, (at<<1)+1, atLeft, bound, bag);
			getIntervals(left, right, (at<<1)+2, bound+1, atRight, bag);
		}
		public String toString(){
			StringBuilder fin = new StringBuilder();
			for (int i =0; i< size; i++){
				fin.append(sum(i,i)+" ");
			}
			return fin.toString();
		}
	}

private static 
 class TP {
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

private static 
class DP {
	public static int lcsNo(char[] l1, char[] l2){
		int[][] dp1 = new int[l1.length+1][l2.length+1];
		int max = 0;
		for (int i =0;i < l1.length+1;i ++){
			for (int j =0; j < l2.length+1; j++){
				if (i ==0 || j == 0){
					dp1[i][j] = 0;
				}
				else if (l1[i-1] == l2[j-1]){
					dp1[i][j] = dp1[i-1][j-1]+1;
				}
				else {
					dp1[i][j] = Math.max(dp1[i-1][j], dp1[i][j-1]);
				}
				max = Math.max(max, dp1[i][j]);
			}
		}
		return max;
	}
	static int UP = 1;
	static int LEFT = 2;
	static int UPLEFT = 3;
	static int END = 0;
	public static String lcs(char[] l1, char[] l2){
		int[][] dp1 = new int[l1.length+1][l2.length+1];
		int[][] from = new int[l1.length+1][l2.length+1];
		int max = 0;
		int kx = -1;
		int ky = -1;
		for (int i =0;i < l1.length+1;i ++){
			for (int j =0; j < l2.length+1; j++){
				if (i ==0 || j == 0){
					dp1[i][j] = 0;
				}
				else if (l1[i-1] == l2[j-1]){
					dp1[i][j] = dp1[i-1][j-1]+1;
					from[i][j] = UPLEFT;
				}
				else {
					dp1[i][j] = Math.max(dp1[i-1][j], dp1[i][j-1]);
					from[i][j] = dp1[i-1][j] >= dp1[i][j-1] ? UP : LEFT;
				}
				if (dp1[i][j] > max){
					max = dp1[i][j];
					kx = i;
					ky = j;
				}
			}
		}
		char[] fin = new char[max];
		for (int ptr = 0;;){
			int type = from[kx][ky];
			if (type == UPLEFT){
				fin[max - 1 - ptr++] = l1[kx-1];
				kx--;
				ky--;
			}
			else if (type == UP) kx--;
			else if (type == LEFT) ky--;
			else break; 
		}
		return String.valueOf(fin);
	}
	public static int lcsNo(int[] l1, int[] l2){
		int[][] dp1 = new int[l1.length+1][l2.length+1];
		int max = 0;
		for (int i =0;i < l1.length+1;i ++){
			for (int j =0; j < l2.length+1; j++){
				if (i ==0 || j == 0){
					dp1[i][j] = 0;
				}
				else if (l1[i-1] == l2[j-1]){
					dp1[i][j] = dp1[i-1][j-1]+1;
				}
				else {
					dp1[i][j] = Math.max(dp1[i-1][j], dp1[i][j-1]);
				}
				max = Math.max(max, dp1[i][j]);
			}
		}
		return max;
	}
	public static int maxSubarraySum(int[] l1){
		int temp = l1[0];
		int max = l1[0];
		for (int i = 1; i < l1.length ;i++){
			if (temp < 0) temp = l1[i];
			else temp += l1[i];
			max = Math.max(max, temp);
		}
		return max;
	}
	public static int levenshtein(char[] l1, char[] l2){
		int[][] dp1 = new int[l1.length+1][l2.length+1];
		int min = 0;
		for (int i =0;i < l1.length+1;i ++){
			for (int j =0; j < l2.length+1; j++){
				if (i ==0 || j == 0){
					dp1[i][j] = Math.max(i, j);
				}
				else {
					int res = Integer.MAX_VALUE;
					res = Math.min(res, dp1[i-1][j]+1);
					res = Math.min(res, dp1[i][j-1]+1);
					if (l1[i-1] == l2[j-1]){
						res = Math.min(res, dp1[i-1][j-1]);
					}
					else {
						res = Math.min(res, dp1[i-1][j-1] + 1);
					}
					dp1[i][j] = res;
				}
			}
		}
		return dp1[l1.length][l2.length];
	}
}

private static 
 class LongestIncreasingSubsequence {
	static int lower_bound(int[] a, int len, int key) {
		int lo = -1;
		int hi = len;
		while (hi - lo > 1) {
			int mid = (lo + hi) / 2;
			int midVal = a[mid];
			if (midVal < key) {
				lo = mid;
			}
			else {
				hi = mid;
			}
		}
		return hi;
	}
	public static int[] lis(int[] a) {
		int n = a.length;
		int[] b = new int[n];
		int[] len = new int[n];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			int j = lower_bound(b, cnt, a[i]);
			if (j == cnt) ++cnt;
			b[j] = a[i];
			len[i] = j + 1;
		}
		int[] res = new int[cnt];
		for (int i = n - 1; i >= 0; i--)
			if (len[i] == cnt && (cnt == res.length || a[i] < res[cnt])) res[--cnt] = a[i];
		return res;
	}
}

private static 
class Geo2 {
	static double eps = 1e-8;
	static int comp(double a) {
		if (a < eps) return -1;
		if (a > eps) return 1;
		return 0;
	}
	static double sqr(double a) {
		return a * a;
	}
	static double sqrt(double a) {
		return a <= 0 ? 0 : Math.sqrt(a);
	}
	static P2 add(P2 a, P2 b) {
		return new P2(a.x + b.x, a.y + b.y);
	}
	static P2 sub(P2 a, P2 b) {
		return new P2(a.x - b.x, a.y - b.y);
	}
	static P2 mult(P2 a, double b) {
		return new P2(a.x * b, a.y * b);
	}
	static P2 div(P2 a, double b) {
		return new P2(a.x / b, a.y / b);
	}
	static boolean eq(P2 a, P2 b) {
		if (comp(a.x - b.x) != 0) return false;
		if (comp(a.y - b.y) != 0) return false;
		return true;
	}
	static double det(P2 a, P2 b) {
		return a.x * b.y - a.y * b.x;
	}
	static double dot(P2 a, P2 b) {
		return a.x * b.x + a.y * b.y;
	}
	static class P2 {
		double x = 0, y = 0;
		P2() {}
		P2(double k1, double k2) {x = k1; y = k2;}
		public String toString() {return "(" + x + ", " + y + ")";}
		double norm() {return sqrt(x * x + y * y);}
	}
	static class Convex {
		ArrayList<P2> p = new ArrayList();
	}
	static class CompLess implements Comparator<P2> {
		@Override
		public int compare(P2 a, P2 b) {
			int cx = comp(a.x-b.x);
			if (cx != 0) return cx;
			return comp(a.y-b.y);
		}
	}
}

private static 
class Geo2X {
		public static double eps = 1e-8;
		public static int sign(double n1) {
			if (Math.abs(n1) <= eps) return 0;
			if (n1 > 0) return 1;
			return -1;
		}
		public static int comp(double n1, double n2) {
			return sign(n1 - n2);
		}
		public static double norm(double[] l1){
			double fin = 0;
			for (double e: l1){
				fin += e*e;
			}
			return Math.sqrt(fin);
		}
		public static double dist(double[] p1, double[] p2){
			double kx = p1[0] - p2[0];
			double ky = p1[1] - p2[1];
			return Math.sqrt(kx*kx+ky*ky);
		}
		public static double dist(double x1, double y1, double x2, double y2){
			double kx = x1 - x2;
			double ky = y1 - y2;
			return Math.sqrt(kx*kx+ky*ky);
		}
		public static double ang(double[] p1){
			double k1 = Math.atan2(p1[1], p1[0]);
			k1 += Math.PI*2;
			k1 = k1 % (Math.PI*2);
			return k1;
		}
		public static double ang(double[] p1, double[] p2){
			double kx = p2[0]-p1[0];
			double ky = p2[1]-p1[1];
			double k1 = Math.atan2(ky, kx);
			k1 += Math.PI*2;
			k1 = k1 % (Math.PI*2);
			return k1;
		}
		public static double ang(double[] a1, double[] b1, double[] b2){
			double[] vec1 = {b1[0]-a1[0],b1[1]-a1[1]};
			double[] vec2 = {b2[0]-a1[0],b2[1]-a1[1]};
			double fin = ang(vec1)-ang(vec2);
			if(fin <0) fin *= -1;
			if (sign(fin-Math.PI)>0) fin = 2*Math.PI - fin;
			return fin;
		}
		public static double canonDiffAng(double[] a1, double[] a2, double[] b1, double[] b2){
			double ang1 = ang(a1,a2);
			double ang2 = ang(b1,b2);
			double f1 = (ang2 - ang1+Math.PI*2)%Math.PI;
			if (f1 > Math.PI/2){
				f1 = Math.PI - f1;
			}
			return f1;
		}
		public static double[] midPoint(double[] p1, double[] p2){
			double[] fin = {p1[0]+p2[0],p1[1]+p2[1]};
			fin[0]*=0.5;
			fin[1]*=0.5;
			return fin;
		}
		public static double[] projPoint(double[] k1, double[] k2, double[] point){
			double[] lineVec = Vec.diff(k1, k2);
			double[] pointVec = Vec.diff(point, k2);
			double[] lineUnit = unit(lineVec);
			double pointLength = norm(pointVec);
			double minusLength = Math.cos(canonDiffAng(k1,k2,point,k2))*pointLength;
			double[] fin = {k2[0] + lineUnit[0]*minusLength,k2[1] + lineUnit[1]*minusLength};
			return fin;
		}
		public static double[] projPoint2(double[] k1, double[] k2, double[] point){
			double[] lineVec = Vec.diff(k2, k1);
			double[] pointVec = Vec.diff(k2, point);
			double[] lineUnit = unit(lineVec);
			double pointLength = norm(pointVec);
			double cosine = (lineVec[0]*pointVec[0]+lineVec[1]*pointVec[1])/(norm(lineVec)*norm(pointVec) );
			double minusLength = cosine*pointLength;
			double[] fin = {k2[0] - lineUnit[0]*minusLength,k2[1] - lineUnit[1]*minusLength};
			return fin;
		}
		public static double[] unit(double[] p1){
			double norm = Math.sqrt(p1[0]*p1[0]+p1[1]*p1[1]);
			double[] fin = {p1[0]/norm, p1[1]/norm};
			return fin;
		}
		public static double[] lineRep(double[] p1, double[] p2){
			double a = p1[0]- p2[0];
			double b = p1[1]- p2[1];
			return new double[]{b, -a, b*p1[0]-a*p1[1]};
		}
		public static double[] perpendicular(double[] l1, double[] p2){
			return new double[]{-l1[1],l1[0],-l1[1]*p2[0]+l1[0]*p2[1]};
		}
		public static double[] sectPoint(double[] l1, double[] l2){
			double det = l1[0]*l2[1]-l1[1]*l2[0];
			double xtop = l1[2]*l2[1]-l2[2]*l1[1];
			double ytop = l1[2]*l2[0]-l2[2]*l1[0];
			return new double[]{xtop/det, -ytop/det};
		}
		public static double[] sectPoint(double[] p1, double[] p2, double[] p3, double[] p4){
			double[] l1 = lineRep(p1, p2);
			double[] l2 = lineRep(p3, p4);
			double det = l1[0]*l2[1]-l1[1]*l2[0];
			double xtop = l1[2]*l2[1]-l2[2]*l1[1];
			double ytop = l1[2]*l2[0]-l2[2]*l1[0];
			return new double[]{xtop/det, -ytop/det};
		}
		public static boolean par(double[] p1, double[] p2, double[] p3, double[] p4){
			double kx1 = p1[0] - p2[0];
			double ky1 = p1[1] - p2[1];
			double kx2 = p3[0] - p4[0];
			double ky2 = p3[1] - p4[1];
			if (Geo2X.sign(kx1*ky2 - kx2*ky1) == 0){
				return true;
			}
			return false;
		}
		public static double sarea(double a, double b, double coseta){
			return 0.5*a*b*Math.sin(coseta);
		}
		public static double lcos(double a, double b, double coseta){
			double k1 = a*a+b*b-2*a*b*Math.cos(coseta);
			return Math.sqrt(k1);
		}
		public static int ccw(double[] p1, double[] p2, double[] p3){
			return sign((p2[0]-p1[0])*(p3[1]-p1[1])-(p2[1]-p1[1])*(p3[0]-p1[0]));
		}
		public static ArrayList<double[]> convexHull(double[][] points){
			Arrays.sort(points, new SortX());
			ArrayList<double[]> top = new ArrayList();
			top.add(points[0]);
			top.add(points[1]);
			for (int i = 2; i < points.length; i++){
				double[] cur = points[i];
				for (;;){
					if (top.size()<2) break;
					if (ccw(top.get(top.size()-2),top.get(top.size()-1),cur) <= 0){
						top.remove(top.size()-1);
					}
					else break;
				}
				top.add(cur);
			}
			ArrayList<double[]> bot = new ArrayList();
			bot.add(points[points.length-1]);
			bot.add(points[points.length-2]);
			for (int i = points.length-3; i >= 0; i--){
				double[] cur = points[i];
				for (;;){
					if (bot.size()<2) break;
					if (ccw(bot.get(bot.size()-2),bot.get(bot.size()-1),cur) <= 0){
						bot.remove(bot.size()-1);
					}
					else break;
				}
				bot.add(cur);
			}
			ArrayList<double[]> fin = new ArrayList();
			for (int i = 0; i< top.size()-1; i++){
				fin.add(top.get(i));
			}
			for (int i = 0; i< bot.size()-1; i++){
				fin.add(bot.get(i));
			}
			return fin;
		}
		public static class SortX implements Comparator<double[]>{
			@Override
			public int compare(double[] l1, double[] l2) {
				if (l1[0] > l2[0]) return 1;
				if (l1[0] < l2[0]) return -1;
				if (l1[1] > l2[1]) return 1;
				if (l1[1] < l2[1]) return -1;
				return 0;
			}
		}
	}

private static 
class BipartiteMatching {
	static boolean findPath(List<Integer>[] g, int u1, int[] matching,
			boolean[] vis) {
		vis[u1] = true;
		for (int v : g[u1]) {
			int u2 = matching[v];
			if (u2 == -1 || !vis[u2] && findPath(g, u2, matching, vis)) {
				matching[v] = u1;
				return true;
			}
		}
		return false;
	}
	public static int maxMatching(List<Integer>[] g, int n2) {
		int n1 = g.length;
		int[] matching = new int[n2];
		Arrays.fill(matching, -1);
		int matches = 0;
		for (int u = 0; u < n1; u++) {
			if (findPath(g, u, matching, new boolean[n1]))
				++matches;
		}
		return matches;
	}
	public static void main(String[] args) {
		int n1 = 2;
		int n2 = 3;
		List<Integer>[] g = new List[n1];
		for (int i = 0; i < n1; i++) {
			g[i] = new ArrayList<Integer>();
		}
		g[0].add(2);
		g[0].add(0);
		g[1].add(2);
		System.out.println(2 == maxMatching(g, n2));
	}
}

private static 
 class Dijsktra {
}

private static 
 class DirectedGraph {
	public IntL[] adjacencyList;
	int nodeNo;
	int edgeNo = 0;
	public DirectedGraph(int nodeNo){
		this.nodeNo = nodeNo;
		adjacencyList = new IntL[nodeNo];
		for (int i = 0; i < adjacencyList.length; i++){
			adjacencyList[i] = new IntL();
		}
	}
	public void addEdge(int from, int to){
		adjacencyList[from].add(to);
	}
	public void addBidirectedEdge(int from, int to){
		adjacencyList[from].add(to);
		adjacencyList[to].add(from);
	}
}

private static 
 class DoubleWeightedDirectedGraph {
	public IntL[] adjacencyList;
	public IntL fromList = new IntL();
	public IntL toList = new IntL();
	public DoubleL weightList = new DoubleL();
	int nodeNo;
	int edgeNo = 0;
	public DoubleWeightedDirectedGraph(int nodeNo) {
		this.nodeNo = nodeNo;
		adjacencyList = new IntL[nodeNo];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new IntL();
		}
	}
	public void addEdge(int from, int to, double weight) {
		int edgeId = edgeNo;
		fromList.add(from);
		toList.add(to);
		weightList.add(weight);
		adjacencyList[from].add(edgeId);
		edgeNo++;
	}
	public double[] dijkstra(int source) {
		final double[] fin = new double[nodeNo];
		boolean[] poped = new boolean[nodeNo];
		Arrays.fill(fin, Long.MAX_VALUE);
		TreeSet<Integer> q1 = new TreeSet<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer n1, Integer n2) {
				double diff1 = fin[n1] - fin[n2];
				if (diff1 > 0) return 1;
				if (diff1 < 0) return -1;
				return n1 - n2;
			}
		});
		q1.add(source);
		fin[source] = 0;
		for (;;) {
			if (q1.size() <= 0) break;
			int cur = q1.pollFirst();
			poped[cur] = true;
			double baseDist = fin[cur];
			for (int edgeId : adjacencyList[cur]) {
				int to = toList.get(edgeId);
				if (poped[to]) continue;
				double newDist = baseDist + weightList.get(edgeId);
				if (newDist < fin[to]) {
					if (q1.contains(to)) {
						q1.remove(to);
					}
					fin[to] = newDist;
					q1.add(to);
				}
			}
		}
		return fin;
	}
}

private static 
 class FlowGraph {
	public static class Edge {
		public int from;
		public int to;
		public int capacity;
		public int cost;
		public int flow;
	}
}

private static 
 class ForwardStar {
	int[] cnt =null;
	int[] idx = null;
	int[] id = null;
	int eno = 0;
	int vno = 0;
	public ForwardStar(int n1, int[] l1, int[] l2) {
		vno = n1;
		eno = l1.length;
		cnt = new int[vno];
		for (int i =0; i < eno; i++) {
			cnt[l1[i]]++;
		}
		idx = new int[vno];
		for (int i = 1; i < vno; i++) {
			idx[i] = idx[i-1] + cnt[i - 1];
		}
		id = new int[eno];
		int[] ptr = idx.clone();
		for (int i =0; i < eno; i++) {
			int id1 = ptr[l1[i]]++;
			id[id1] = l2[i];
		}
		Main.px(idx);
		Main.px(id);
		if (true) for (int i =0; i < vno; i++){
			Arrays.sort(id,idx[i], idx[i] + cnt[i]);
		}
	}
	public void print(){
		for (int i =0; i < cnt.length; i++){
			System.out.print(i+": ");
			for (int j =0; j < cnt[i]; j++){
				System.out.print(id[j+idx[i]]+" ");
			}
			System.out.println();
		}
	}
	public boolean contains(int from , int to){
		return Arrays.binarySearch(id, idx[from], idx[from]+cnt[from], to) >= 0;
	}
	public VertexEdges edgedOf(int v1){
		return new VertexEdges(v1);
	}
	public class VertexEdges implements Iterable<Integer> {
		int v1 = 0;
		public VertexEdges(int n1) {
			v1 = n1;
		}
		@Override
		public Iterator<Integer> iterator() {
			return new EdgesIterator(v1);
		}
		public class EdgesIterator implements Iterator<Integer>{
			int v1 = 0;
			int ptr = -1;
			public EdgesIterator(int n1) {
				v1 = n1;
				ptr = idx[v1];
			}
			@Override
			public boolean hasNext() {
				if (ptr - idx[v1] >= cnt[v1])
				return false;
				return true;
			}
			@Override
			public Integer next() {
				return id[ptr++];
			}
			@Override
			public void remove() {}
		}
	}
}

private static 
 class LongWeightedDirectedGraph {
	public IntL[] adjacencyList;
	public IntL fromList = new IntL();
	public IntL toList = new IntL();
	public LongL weightList = new LongL();
	int nodeNo;
	int edgeNo = 0;
	public LongWeightedDirectedGraph(int nodeNo) {
		this.nodeNo = nodeNo;
		adjacencyList = new IntL[nodeNo];
		for (int i = 0; i < adjacencyList.length; i++) {
			adjacencyList[i] = new IntL();
		}
	}
	public void addEdge(int from, int to, long weight) {
		int edgeId = edgeNo;
		fromList.add(from);
		toList.add(to);
		weightList.add(weight);
		adjacencyList[from].add(edgeId);
		edgeNo++;
	}
	public long[] dijkstra(int source) {
		final long[] fin = new long[nodeNo];
		boolean[] poped = new boolean[nodeNo];
		Arrays.fill(fin, Long.MAX_VALUE);
		TreeSet<Integer> q1 = new TreeSet<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer n1, Integer n2) {
				long diff1 = fin[n1] - fin[n2];
				if (diff1 > 0) return 1;
				if (diff1 < 0) return -1;
				return n1 - n2;
			}
		});
		q1.add(source);
		fin[source] = 0;
		for (;;) {
			if (q1.size() <= 0) break;
			int cur = q1.pollFirst();
			poped[cur] = true;
			long baseDist = fin[cur];
			for (int edgeId : adjacencyList[cur]) {
				int to = toList.get(edgeId);
				if (poped[to]) continue;
				long newDist = baseDist + weightList.get(edgeId);
				if (newDist < fin[to]) {
					if (q1.contains(to)) {
						q1.remove(to);
					}
					fin[to] = newDist;
					q1.add(to);
				}
			}
		}
		return fin;
	}
	public long[] bellmanFord(int source) {
		long[] fin = new long[nodeNo];
		Arrays.fill(fin, Long.MAX_VALUE >> 1);
		fin[source] = 0;
		for (int i = 0; i < nodeNo - 1; i++) {
			for (IntL e : adjacencyList) {
				for (int edgeId : e) {
					int from = fromList.get(edgeId);
					int to = toList.get(edgeId);
					long weight = weightList.get(edgeId);
					if (fin[from] + weight < fin[to]) {
						fin[to] = weight + fin[from];
					}
				}
			}
		}
		for (IntL e : adjacencyList) {
			for (int edgeId : e) {
				int from = fromList.get(edgeId);
				int to = toList.get(edgeId);
				long weight = weightList.get(edgeId);
				if (fin[from] + weight < fin[to]) { return null; }
			}
		}
		return fin;
	}
	public long[][] floydWarshall(){
		long[][] fin = new long[nodeNo][nodeNo];
		for (long[] e: fin){
			Arrays.fill(e, Long.MAX_VALUE / 8l * 3l);
		}
		for (IntL e: adjacencyList){
			for (int edgeId: e){
				fin[fromList.get(edgeId)][toList.get(edgeId)] = weightList.get(edgeId);
			}
		}
		for (int i = 0; i < nodeNo; i++){
			for (int j = 0; j <nodeNo; j++){
				for (int k = 0; k < nodeNo; k++){
					long newDist = fin[j][i] + fin[i][k];
					if (newDist < fin[j][k]){
						fin[j][k] = newDist;
					}
				}
			}
		}
		return fin;
	}
}

private static 
 class UndirectedGraph {
	public IntL[] adjacencyList;
	int nodeNo;
	int edgeNo = 0;
	public UndirectedGraph(int nodeNo){
		this.nodeNo = nodeNo;
		adjacencyList = new IntL[nodeNo];
		for (int i = 0; i < adjacencyList.length; i++){
			adjacencyList[i] = new IntL();
		}
	}
	public void addEdge(int from, int to){
		adjacencyList[from].add(to);
		adjacencyList[to].add(from);
	}
}

private static 
 class UndirectedTree {
	public int[] parent;
	public UndirectedTree(int n1){
	}
}

private static 
 class Arrayz {
		public static int[] sortUnique(int[] l1) {
			int[] copy = l1.clone();
			Arrays.sort(copy);
			int size = 0;
			for (int i = 0; i < copy.length; i++) {
				if (i == 0 || copy[i] != copy[i - 1]) {
					copy[size++] = copy[i];
				}
			}
			return Arrays.copyOf(copy, size);
		}
		public static long[] sortUnique(long[] l1) {
			long[] copy = l1.clone();
			Arrays.sort(copy);
			int size = 0;
			for (int i = 0; i < copy.length; i++) {
				if (i == 0 || copy[i] != copy[i - 1]) {
					copy[size++] = copy[i];
				}
			}
			return Arrays.copyOf(copy, size);
		}
		public static int[][] sortUniqueCount(int[] l1) {
			int[] copy = l1.clone();
			Arrays.sort(copy);
			int[] count = new int[l1.length];
			int size = 0;
			for (int i = 0; i < copy.length; i++) {
				if (i == 0 || copy[i] != copy[i - 1]) {
					copy[size] = copy[i];
					count[size] = 1;
					size++;
				}
				else {
					count[size - 1]++;
				}
			}
			return new int[][]{Arrays.copyOf(copy, size),Arrays.copyOf(count, size)};
		}
		public static int max(int[] l1){
			int fin = Integer.MIN_VALUE;
			for (int e: l1) if (e > fin) fin = e;
			return fin;
		}
		public static long max(long[] l1){
			long fin = Integer.MIN_VALUE;
			for (long e: l1) if (e > fin) fin = e;
			return fin;
		}
		public static double max(double[] l1){
			double fin = l1[0];
			for (double e: l1) if (e > fin) fin = e;
			return fin;
		}
		public static int min(int[] l1){
			int fin = Integer.MAX_VALUE;
			for (int e: l1) if (e < fin) fin = e;
			return fin;
		}
		public static long min(long[] l1){
			long fin = Integer.MAX_VALUE;
			for (long e: l1) if (e < fin) fin = e;
			return fin;
		}
		public static double min(double[] l1){
			double fin = l1[0];
			for (double e: l1) if (e < fin) fin = e;
			return fin;
		}
		public static int[] prefixSum(int[] l1){
			int[] fin = new int[l1.length + 1];
			for (int i = 1;i < l1.length + 1; i++){
				fin[i] += fin[i - 1] + l1[i - 1];
			}
			return fin;
		}
		public static long[] prefixSum(long[] l1){
			long[] fin = new long[l1.length + 1];
			for (int i = 1;i < l1.length + 1; i++){
				fin[i] += fin[i - 1] + l1[i - 1];
			}
			return fin;
		}
		public static double[] prefixSum(double[] l1){
			double[] fin = new double[l1.length + 1];
			for (int i = 1;i < l1.length + 1; i++){
				fin[i] += fin[i - 1] + l1[i - 1];
			}
			return fin;
		}
		public static int lowerCount(int[] l1, int n1){
			if (n1 <= l1[0]) return 0;
			if (l1[l1.length - 1] < n1) return l1.length;
			int low = 0;
			int high = l1.length - 1;
			for (;high - low > 1;){
				int mid = (high + low) >> 1;
				if (l1[mid] >= n1) high = mid;
				else if (l1[mid] < n1) low = mid;
			}
			return low + 1;
		}
		public static int lowerCount(long[] l1, long n1){
			if (n1 <= l1[0]) return 0;
			if (l1[l1.length - 1] < n1) return l1.length;
			int low = 0;
			int high = l1.length - 1;
			for (;high - low > 1;){
				int mid = (high + low) >> 1;
				if (l1[mid] >= n1) high = mid;
				else if (l1[mid] < n1) low = mid;
			}
			return low + 1;
		}
		public static int lowerCount(double[] l1, double n1){
			if (n1 <= l1[0]) return 0;
			if (l1[l1.length - 1] < n1) return l1.length;
			int low = 0;
			int high = l1.length - 1;
			for (;high - low > 1;){
				int mid = (high + low) >> 1;
				if (l1[mid] >= n1) high = mid;
				else if (l1[mid] < n1) low = mid;
			}
			return low + 1;
		}
		public static int higherCount(int[] l1, int n1){
			if (n1 >= l1[l1.length - 1]) return 0;
			if (l1[0] > n1) return l1.length;
			int low = 0;
			int high = l1.length - 1;
			for (;high - low > 1;){
				int mid = (high + low) >> 1;
				if (l1[mid] > n1) high = mid;
				else if (l1[mid] <= n1) low = mid;
			}
			return l1.length - high;
		}
		public static int higherCount(long[] l1, long n1){
			if (n1 >= l1[l1.length - 1]) return 0;
			if (l1[0] > n1) return l1.length;
			int low = 0;
			int high = l1.length - 1;
			for (;high - low > 1;){
				int mid = (high + low) >> 1;
				if (l1[mid] > n1) high = mid;
				else if (l1[mid] <= n1) low = mid;
			}
			return l1.length - high;
		}
		public static int higherCount(double[] l1, double n1){
			if (n1 >= l1[l1.length - 1]) return 0;
			if (l1[0] > n1) return l1.length;
			int low = 0;
			int high = l1.length - 1;
			for (;high - low > 1;){
				int mid = (high + low) >> 1;
				if (l1[mid] > n1) high = mid;
				else if (l1[mid] <= n1) low = mid;
			}
			return l1.length - high;
		}
		public int equalCount(int[] l1, int n1){
			return l1.length - lowerCount(l1, n1) - higherCount(l1, n1);
		}
		public int equalCount(long[] l1, long n1){
			return l1.length - lowerCount(l1, n1) - higherCount(l1, n1);
		}
		public int equalCount(double[] l1, double n1){
			return l1.length - lowerCount(l1, n1) - higherCount(l1, n1);
		}
		public Integer[] objectOrder(int n1){
			Integer[] fin = new Integer[n1];
			for (int i =  0;  i < n1; i++){
				fin[i] = i;
			}
			return fin;
		}
		public int[] intOrder(int n1){
			int[] fin = new int[n1];
			for (int i =  0;  i < n1; i++){
				fin[i] = i;
			}
			return fin;
		}
	}

private static 
class BigCombinatoricz {
		public static BigInteger bi(long n1) {
			return BigInteger.valueOf(n1);
		}
		public static BigInteger factorial(long n1, long k1) {
			BigInteger fin = bi(1);
			BigInteger mult = bi(n1);
			for (int i = 0; i < k1; i++) {
				fin = fin.multiply(mult);
				mult = mult.subtract(bi(1));
			}
			return fin;
		}
		public static BigInteger factorial(long n1) {
			return factorial(n1, n1);
		}
		public static BigInteger choose(long n1, long k1) {
			return factorial(n1, k1).divide(factorial(k1));
		}
		public static BigInteger chooseRep(long n1, long k1){
			return choose(k1 + n1 -  1, n1 - 1);
		}
		public static BigInteger[][] pascal(int depth){
			BigInteger[][] fin = new BigInteger[depth+1][];
			fin[0] = new BigInteger[]{BigInteger.ONE};
			for (int i = 1 ; i <= depth; i++){
				BigInteger[] temp = new BigInteger[i+1];
				temp[0] = BigInteger.ONE;
				temp[temp.length-1] = BigInteger.ONE;
				for (int j = 1;j<i; j++){
					temp[j] = fin[i-1][j].add(fin[i-1][j-1]);
				}
				fin[i] = temp;
			}
			return fin;
		}
	}

private static 
 class Bitz {
	public static long[] front = new long[65];
	public static long[] back = new long[65];
	public static long empty = 0;
	static {
		long cur = 0;
		for (int i =0; i < back.length; i++){
			back[back.length - i - 1] = ~cur;
			front[i] = cur;
			cur |= 1l << i;
		}
	}
	public static long addBitAt(long set, int idx){
		return set | (1l << idx);
	}
	public static long removeBitAt(long set, int idx){
		return set & ~(1l << idx);
	}
	public static boolean hasBitAt(long set, int idx){
		return (set & (1 << idx)) != 0;
	}
	public static int size(long set){
		return Long.bitCount(set);
	}
	public static String binString64(long n1){
		return String.format("%64s", Long.toBinaryString(n1)).replace(' ', '0');
	}
}

private static 
 class Intz {
	public static int decDigitNo(int n1){
		if (n1 == 0) return 1;
		int cnt = 0;
		for (;n1 != 0;){
			n1 /= 10;
			cnt++;
		}
		return cnt;
	}
}

private static 
 class Modz {
		public static long mod(long n1, long mod) {
			long fin = n1 % mod;
			if (fin < 0) fin += mod;
			return fin;
		}
		public static long add(long n1, long n2, long mod) {
			long k1 = (n1 + n2) % mod;
			if (k1 < 0) k1 += mod;
			return k1;
		}
		public static long subtract(long n1, long n2, long mod) {
			long k1 = (n1 - n2) % mod;
			if (k1 < 0) k1 += mod;
			return k1;
		}
		public static long times(long n1, long n2, long mod) {
			long k1 = (n1 * n2) % mod;
			if (k1 < 0) k1 += mod;
			return k1;
		}
		public static long divides(long divided, long dividing, long mod) {
			return (times(divided, moduloInverse(mod, dividing), mod)) % mod;
		}
		public static long moduloInverse(long n1, long mod){
			long top = mod;
			long bot = n1;
			long top1 = 1;
			long bot1 = 0;
			long top2 = 0;
			long bot2 = 1;
			for (;;){
				if (bot == 1) break;
				long times = top / bot;
				long rmd = top % bot;
				long top3 = top1 - times * top2;
				long bot3 = bot1 - times * bot2;
				top1 = top2;
				bot1 = bot2;
				top2 = top3;
				bot2 = bot3;
				top = bot;
				bot = rmd;
			}
			return mod(bot2, mod);
		}
		public static long pow(long base, long pow, long mod) {
			if (pow == 0)
				return 1l % mod;
			else if (pow == 1)
				return times(1l, base, mod);
			else if ((pow & 1) == 0) {
				long half = pow(base, pow >> 1, mod);
				return times(half, half, mod);
			}
			else {
				long half = pow(base, pow >> 1, mod);
				return times(half, times(half, base, mod), mod);
			}
		}
	}

private static 
 class Multiplyz {
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
		BigInteger w2 = z2.multiply(mod1).multiply(mod1);
		BigInteger w1 = z1.multiply(mod1);
		BigInteger w0 = z0;
		return w2.add(w1).add(w0);
	}
}

private static 
 class Shuffle {
		private static Random r1 = new Random();
		public static void ints(int[] l1) {
			for (int i = 0; i < l1.length; i++) {
				int k1 = i + r1.nextInt(l1.length - i);
				int temp = l1[i];
				l1[i] = l1[k1];
				l1[k1] = temp;
			}
		}
		public static void ints(int[] l1, int n1, int n2) {
			for (int i = 0; i < n2 - n1; i++) {
				int k1 = i + r1.nextInt(n2 - n1 - i);
				int temp = l1[i + n1];
				l1[i + n1] = l1[k1 + n1];
				l1[k1 + n1] = temp;
			}
		}
		public static void longs(long[] l1) {
			for (int i = 0; i < l1.length; i++) {
				int k1 = i + r1.nextInt(l1.length - i);
				long temp = l1[i];
				l1[i] = l1[k1];
				l1[k1] = temp;
			}
		}
		public static void longs(long[] l1, int n1, int n2) {
			for (int i = 0; i < n2 - n1; i++) {
				int k1 = i + r1.nextInt(n2 - n1 - i);
				long temp = l1[i + n1];
				l1[i + n1] = l1[k1 + n1];
				l1[k1 + n1] = temp;
			}
		}
		public static void doubles(double[] l1) {
			for (int i = 0; i < l1.length; i++) {
				int k1 = i + r1.nextInt(l1.length - i);
				double temp = l1[i];
				l1[i] = l1[k1];
				l1[k1] = temp;
			}
		}
		public static void doubles(double[] l1, int n1, int n2) {
			for (int i = 0; i < n2 - n1; i++) {
				int k1 = i + r1.nextInt(n2 - n1 - i);
				double temp = l1[i + n1];
				l1[i + n1] = l1[k1 + n1];
				l1[k1 + n1] = temp;
			}
		}
	}

private static 
 class Stringz {
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

private static 
 class FullPermutation implements Iterable<int[]>{
	int[] cur = null;
	public static FullPermutation instance(int n1){
		FullPermutation fin = new FullPermutation();
		fin.cur = new int[n1];
		for (int i = 0 ; i < n1; i++){
			fin.cur[i] = i;
		}
		return fin;
	}
	@Override
	public Iterator<int[]> iterator() {
		return new It();
	}
	public class It implements Iterator<int[]> {
		public boolean hasNext = true;
		public boolean advanced = true;
		public void advance(){
			if (advanced) return;
			advanced = true;
			hasNext = Gen.nextPerm(cur);
		}
		@Override
		public boolean hasNext() {
			advance();
			return hasNext;
		}
		@Override
		public int[] next() {
			advanced = false;
			return cur;
		}
		@Override
		public void remove() {}
	}
}

private static 
 class Order implements Iterable<Integer>{
	public static Order order(int n1){
		Order fin = new Order();
		fin.cur = 0;
		fin.lim = n1;
		fin.inc = 1;
		return fin;
	}
	public static Order order(int n1, int inc1){
		Order fin = new Order();
		fin.cur = 0;
		fin.lim = n1;
		fin.inc = inc1;
		return fin;
	}
	public static Order arithmetic(int start, int inc1,int bound){
		Order fin = new Order();
		fin.cur = start;
		fin.lim = bound;
		fin.inc = inc1;
		return fin;
	}
	@Override
	public Iterator<Integer> iterator() {
		return new It();
	}
	public int lim = 0;
	public int cur = 0;
	public int inc = 1;
	public int temp = 0;
	public class It implements Iterator<Integer> {
		@Override
		public boolean hasNext() {
			return cur < lim;
		}
		@Override
		public Integer next() {
			temp = cur;
			cur += inc;
			return temp;
		}
		@Override
		public void remove() {}
	}
}

private static 
class Dir {
	public static int[][] four = {{0,1},{1,0},{0,-1},{-1,0}};
	public static int[][] eight = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
	public static int[][] negDiag = {{-1,1},{1,-1}};
	public static int[][] posDiag = {{1,1},{-1,-1}};
	public static int[][] hori = {{1,0},{-1,0}};
	public static int[][] vert = {{0,1},{0,-1}};
	public static boolean bound(int[] l1, int kx, int ky){
		if (l1[0] < 0 || l1[1] < 0) return false;
		if (l1[0] >= kx || l1[1] >= ky) return false;
		return true;
	}
	public static boolean bound(int x1, int y1, int kx, int ky){
		if (x1 < 0 || y1 < 0) return false;
		if (x1>= kx || y1 >= ky) return false;
		return true;
	}
	public static boolean same(int[] l1, int[] l2){
		if (l1[0]*l2[1] == l1[1]*l2[0]) return true;
		return false;
	}
}

private static 
 class Gen {
		private static int greyCode(int n1){
			return n1 ^ (n1 >> 1);
		}
		public static boolean nextComb(int[] l1, int cap){
			for (int ptr = l1.length-1;;){
				if (ptr < 0) return false;
				if (l1[ptr] == cap - 1){
					l1[ptr] = 0;
					ptr--;
				}
				else {
					l1[ptr]++;
					break;
				}
			}
			return true;
		}
		public static void swap(int[] l1, int a, int b){
			int k1 = l1[a];l1[a]=l1[b];l1[b]=k1;
		}
		public static void rev(int[] l1, int a, int b){
			for (int i = 0; i < (b-a+1)/2;i++) swap(l1,a+i,b-i);
		}
		public static boolean nextPerm(int[] l1) {
			for (int i = l1.length- 2; i >=0; i--) {
				if (l1[i] < l1[i + 1]){
					for (int k = l1.length - 1; k>=0;k--){
						if (l1[k]>=l1[i]){
							swap(l1,i,k);
							rev(l1,i+1,l1.length-1);
							return true;
						}
					}
				}
			}
			rev(l1,0,l1.length-1);
			return false;
		}
		public static int[] permInv(int[] l1){
			int[] fin = new int[l1.length];
			for (int i = 0; i< l1.length;i++){
				fin[l1[i]]=i;
			}
			return fin;
		}
	}

private static 
class Geo3 {
	static double eps = 1e-8;
	static int comp(double a){
		if (a < eps) return -1;
		if (a > eps) return 1;
		return 0;
	}
	static double sqr(double a){
		return a *a;
	}
	static double sqrt(double a){
		return a <= 0 ? 0 : Math.sqrt(a);
	}
	static P3 add(P3 a, P3 b){
		return new P3(a.x+b.x,a.y+b.y,a.z+b.z);
	}
	static P3 sub(P3 a, P3 b){
		return new P3(a.x-b.x,a.y-b.y,a.z-b.z);
	}
	static P3 mult(P3 a, double b){
		return new P3(a.x*b,a.y*b,a.z*b);
	}
	static P3 div(P3 a, double b){
		return new P3(a.x/b,a.y/b,a.z/b);
	}
	static P3 det(P3 a, P3 b){
		return new P3(a.y*b.z - a.z*b.y,
				a.z*b.x - a.x*b.z,
				a.x*b.y - a.y*b.x
				);
	}
	static double dot(P3 a, P3 b){
		return a.x*b.x+a.y*b.y+a.z*b.z;
	}
	static double mix(P3 a, P3 b, P3 c){
		return dot(a,det(b,c));
	}
	static double dist(P3 a, P3 b){
		return sqrt(sqr(a.x-b.x) + sqr(a.y-b.y)+sqr(a.z-b.z));
	}
	static boolean eq(P3 a, P3 b){
		return comp(a.x-b.x) == 0
				&& comp(a.y-b.y) == 0
				&& comp(a.z-b.z) == 0;
	}
	static class P3 {
		public double x = 0, y = 0, z = 0;
		P3(){}
		P3(double a, double b, double c){x=a;y=b;z=c;}
		double length(){
			return sqrt(x*x+y*y+z*z);
		}
	}
	static class L3 {
		P3 a, b;
		L3(){}
		L3(P3 k1, P3 k2){a= k1;b=k2;}
	}
	static boolean zero(double n1){
		return 0 == comp(n1);
	}
	static boolean dotsInline(P3 p1, P3 p2, P3 p3){
		return det(sub(p1,p2),sub(p2,p3)).length() < eps;
	}
	static boolean dotOnlineIn(P3 p, L3 l){
		return zero(det(sub(p,l.a), sub(p,l.b) ).length() )
				&& (l.a.x-p.x)*(l.b.x-p.x) < eps
				&& (l.a.y-p.y)*(l.b.y-p.y) < eps
				&& (l.a.y-p.y)*(l.b.y-p.y) < eps;
	}
	static boolean dotOnlineEx(P3 p, L3 l){
		return dotOnlineIn(p,l)
				&& !eq(p,l.a)
				&& !eq(p,l.b)
				;
	}
	static class Plane {
		P3 a = null, b = null, c = null;
		Plane(){}
		Plane(P3 k1, P3 k2, P3 k3){a=k1;a=k2;a=k3;}
		P3 pvec(){
			return det((sub(a,b) ), sub(b, c) );
		}
	}
	static P3 pvec(P3 s1, P3 s2, P3 s3){
		return det((sub(s1,s2) ), sub(s2, s3) );
	}
	static boolean dotsOnplane(P3 a, P3 b, P3 c, P3 d){
		return zero(dot(pvec(a,b,c), sub(d,a) ) );
	}
	static boolean dotInplaneIn(P3 p, Plane s){
		return zero(det(sub(s.a,s.b), sub(s.a,s.c) ).length()
				- det(sub(p,s.a), sub(p,s.b) ).length()
				- det(sub(p,s.b), sub(p,s.c) ).length()
				- det(sub(p,s.c), sub(p,s.a) ).length()
				);
	}
	static boolean sameSide(P3 p1, P3 p2, Plane s){
		return dot(s.pvec(), sub(p1,s.a)) * dot(s.pvec(), sub(p2,s.a)) > eps;
	}
}

private static 
class MaxFlowDinic {
	static class Edge {
		int t, rev, cap, f;
		public Edge(int t, int rev, int cap) {
			this.t = t;
			this.rev = rev;
			this.cap = cap;
		}
	}
	public static List<Edge>[] createGraph(int nodes) {
		List<Edge>[] graph = new List[nodes];
		for (int i = 0; i < nodes; i++)
			graph[i] = new ArrayList<>();
		return graph;
	}
	public static void addEdge(List<Edge>[] graph, int s, int t, int cap) {
		graph[s].add(new Edge(t, graph[t].size(), cap));
		graph[t].add(new Edge(s, graph[s].size() - 1, 0));
	}
	static boolean dinicBfs(List<Edge>[] graph, int src, int dest, int[] dist) {
		Arrays.fill(dist, -1);
		dist[src] = 0;
		int[] Q = new int[graph.length];
		int sizeQ = 0;
		Q[sizeQ++] = src;
		for (int i = 0; i < sizeQ; i++) {
			int u = Q[i];
			for (Edge e : graph[u]) {
				if (dist[e.t] < 0 && e.f < e.cap) {
					dist[e.t] = dist[u] + 1;
					Q[sizeQ++] = e.t;
				}
			}
		}
		return dist[dest] >= 0;
	}
	static int dinicDfs(List<Edge>[] graph, int[] ptr, int[] dist, int dest,
			int u, int f) {
		if (u == dest)
			return f;
		for (; ptr[u] < graph[u].size(); ++ptr[u]) {
			Edge e = graph[u].get(ptr[u]);
			if (dist[e.t] == dist[u] + 1 && e.f < e.cap) {
				int df = dinicDfs(graph, ptr, dist, dest, e.t,
						Math.min(f, e.cap - e.f));
				if (df > 0) {
					e.f += df;
					graph[e.t].get(e.rev).f -= df;
					return df;
				}
			}
		}
		return 0;
	}
	public static int maxFlow(List<Edge>[] graph, int src, int dest) {
		int flow = 0;
		int[] dist = new int[graph.length];
		while (dinicBfs(graph, src, dest, dist)) {
			int[] ptr = new int[graph.length];
			while (true) {
				int df = dinicDfs(graph, ptr, dist, dest, src,
						Integer.MAX_VALUE);
				if (df == 0)
					break;
				flow += df;
			}
		}
		return flow;
	}
	public static void main(String[] args) {
		List<Edge>[] graph = createGraph(3);
		addEdge(graph, 0, 1, 3);
		addEdge(graph, 0, 2, 2);
		addEdge(graph, 1, 2, 2);
		System.out.println(4 == maxFlow(graph, 0, 2));
	}
}

private static 
 class Sort {
	static Random rnd = new Random();
	public static void qSort(int[] a, int low, int high) {
		if (low > high) return;
		int x = a[low + rnd.nextInt(high - low + 1)];
		int i = low;
		int j = high;
		while (true) {
			while (a[i] < x)
				++i;
			while (x < a[j])
				--j;
			if (i > j) break;
			int t = a[i];
			a[i] = a[j];
			a[j] = t;
			++i;
			--j;
			if (i > j) break;
		}
		qSort(a, low, j);
		qSort(a, i, high);
	}
	public static void qSort2(int[] a, int low, int high) {
		if (high - low > 1) {
			int p = randomizedPartition(a, low, high);
			qSort2(a, low, p);
			qSort2(a, p, high);
		}
	}
	static int randomizedPartition(int[] a, int low, int high) {
		swap(a, low + rnd.nextInt(high - low), high - 1);
		int x = a[high - 1];
		int i = low - 1;
		for (int j = low; j < high; j++)
			if (a[j] <= x) swap(a, ++i, j);
		return i;
	}
	static void swap(int[] a, int i, int j) {
		int t = a[j];
		a[j] = a[i];
		a[i] = t;
	}
	public static void mergeSort(int[] a, int low, int high) {
		if (low + 1 < high) {
			int mid = (low + high) >>> 1;
			mergeSort(a, low, mid);
			mergeSort(a, mid, high);
			int size = high - low;
			int[] b = new int[size];
			int i = low;
			int j = mid;
			for (int k = 0; k < size; k++) {
				if (j >= high || i < mid && a[i] < a[j]) {
					b[k] = a[i++];
				}
				else {
					b[k] = a[j++];
				}
			}
			System.arraycopy(b, 0, a, low, size);
		}
	}
	public static void bubbleSort(int[] a) {
		for (int i = 0; i + 1 < a.length; i++) {
			for (int j = 0; j + 1 < a.length; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
				}
			}
		}
	}
	public static void selectionSort(int[] a) {
		int n = a.length;
		int[] p = new int[n];
		for (int i = 0; i < n; i++)
			p[i] = i;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[p[i]] > a[p[j]]) {
					swap(p, i, j);
				}
			}
		}
		int[] b = a.clone();
		for (int i = 0; i < n; i++)
			a[i] = b[p[i]];
	}
	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (a[j - 1] > a[j]) {
					swap(a, j - 1, j);
				}
			}
		}
	}
	public static void countingSort(int[] a) {
		int max = 0;
		for (int x : a) {
			max = Math.max(max, x);
		}
		int[] cnt = new int[max + 1];
		for (int x : a) {
			++cnt[x];
		}
		for (int i = 1; i < cnt.length; i++) {
			cnt[i] += cnt[i - 1];
		}
		int n = a.length;
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			b[--cnt[a[i]]] = a[i];
		}
		System.arraycopy(b, 0, a, 0, n);
	}
	public static void radixSort(int[] a) {
		final int d = 8;
		final int w = 32;
		int[] t = new int[a.length];
		for (int p = 0; p < w / d; p++) {
			int[] cnt = new int[1 << d];
			for (int i = 0; i < a.length; i++)
				++cnt[((a[i] ^ Integer.MIN_VALUE) >>> d * p) & ((1 << d) - 1)];
			for (int i = 1; i < 1 << d; i++)
				cnt[i] += cnt[i - 1];
			for (int i = a.length - 1; i >= 0; i--)
				t[--cnt[((a[i] ^ Integer.MIN_VALUE) >>> d * p) & ((1 << d) - 1)]] = a[i];
			System.arraycopy(t, 0, a, 0, a.length);
		}
	}
	public static void main(String[] args) {
		Random rnd = new Random(1);
		for (int step = 0; step < 1000; step++) {
			int n = rnd.nextInt(100) + 1;
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = rnd.nextInt(1000);
			}
			int[] s = a.clone();
			Arrays.sort(s);
			int[] b = a.clone();
			bubbleSort(b);
			if (!Arrays.equals(s, b)) throw new RuntimeException();
			b = a.clone();
			selectionSort(b);
			if (!Arrays.equals(s, b)) throw new RuntimeException();
			b = a.clone();
			insertionSort(b);
			if (!Arrays.equals(s, b)) throw new RuntimeException();
			b = a.clone();
			countingSort(b);
			if (!Arrays.equals(s, b)) throw new RuntimeException();
		}
		for (int step = 0; step < 10; step++) {
			int n = rnd.nextInt(50000) + 100000;
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = rnd.nextInt();
			}
			int[] s = a.clone();
			Arrays.sort(s);
			int[] b = a.clone();
			qSort(b, 0, b.length - 1);
			if (!Arrays.equals(s, b)) throw new RuntimeException();
			b = a.clone();
			qSort2(b, 0, b.length);
			if (!Arrays.equals(s, b)) throw new RuntimeException();
			b = a.clone();
			mergeSort(b, 0, b.length);
			if (!Arrays.equals(s, b)) throw new RuntimeException();
			b = a.clone();
			radixSort(b);
			if (!Arrays.equals(s, b)) throw new RuntimeException();
		}
	}
}

private static 
 class Vec {
		public static int[] add(int[] l1, int[] l2){
			int[] fin = new int[l1.length];
			for (int i = 0; i < l1.length; i++){
				fin[i] = l1[i] + l2[i];
			}
			return fin;
		}
		public static long[] add(long[] l1, long[] l2){
			long[] fin = new long[l1.length];
			for (int i = 0; i < l1.length; i++){
				fin[i] = l1[i] + l2[i];
			}
			return fin;
		}
		public static double[] add(double[] l1, double[] l2){
			double[] fin = new double[l1.length];
			for (int i = 0; i < l1.length; i++){
				fin[i] = l1[i] + l2[i];
			}
			return fin;
		}
		public static int[] diff(int[] l1, int[] l2){
			int[] fin = new int[l1.length];
			for (int i = 0; i < l1.length; i++){
				fin[i] = l1[i] - l2[i];
			}
			return fin;
		}
		public static long[] diff(long[] l1, long[] l2){
			long[] fin = new long[l1.length];
			for (int i = 0; i < l1.length; i++){
				fin[i] = l1[i] - l2[i];
			}
			return fin;
		}
		public static double[] diff(double[] l1, double[] l2){
			double[] fin = new double[l1.length];
			for (int i = 0; i < l1.length; i++){
				fin[i] = l1[i] - l2[i];
			}
			return fin;
		}
		public static void addAll(int[] l1, int n1){
			for (int i = 0; i < l1.length; i++){
				l1[i] += n1;
			}
		}
		public static void addAll(long[] l1, long n1){
			for (int i = 0; i < l1.length; i++){
				l1[i] += n1;
			}
		}
		public static void addAll(double[] l1, double n1){
			for (int i = 0; i < l1.length; i++){
				l1[i] += n1;
			}
		}
		public static void timesAll(int[] l1, int n1){
			for (int i = 0; i < l1.length; i++){
				l1[i] *= n1;
			}
		}
		public static void timesAll(long[] l1, long n1){
			for (int i = 0; i < l1.length; i++){
				l1[i] *= n1;
			}
		}
		public static void timesAll(double[] l1, double n1){
			for (int i = 0; i < l1.length; i++){
				l1[i] *= n1;
			}
		}
	}

private static 
class Dinic {
	int dinic(V s, V t){
		int flow = 0;
		for (int p = 1; ; p++){
			Queue<V> que = new LinkedList();
			s.level = 0;
			s.p = p;
			que.offer(s);
			while(!que.isEmpty()){
				V v = que.poll();
				v.iter = v.es.size()-1;
				for (E e: v.es) if (e.to.p < p && e.cap > 0){
					e.to.level = v.level + 1;
					e.to.p = p;
					que.offer(e.to);
				}
			}
			if (t.p < p) return flow;
			for (int f; (f = dfs(s,t,Integer.MAX_VALUE))>0;) flow += f;
		}
	}
	int dfs(V v, V t, int f){
		if (v == t) return f;
		for (;v.iter >= 0;v.iter--){
			E e = v.es.get(v.iter);
			if (v.level < e.to.level && e.cap > 0){
				int d = dfs(e.to, t, Math.min(f,e.cap));
				if (d > 0){
					e.cap -= d;
					e.rev.cap += d;
					return d;
				}
			}
		}
		return 0;
	}
	static class V {
		ArrayList<E> es = new ArrayList();
		int level, p, iter;
		void add(V to, int cap){
			E e = new E(to, cap), rev = new E(this, 0);
			e.rev = rev; rev.rev = e;
			es.add(e); to.es.add(rev);
		}
	}
	static class E {
		V to;
		E rev;
		int cap;
		E (V to, int cap){
			this.to = to;
			this.cap = cap;
		}
	}
}

private static 
 class NT {
	public static IntL sieve(int n1) {
		IntL fin = new IntL();
		boolean[] l1 = new boolean[n1 + 1];
		int last = 0;
		for (int m = 2; m * m <= n1; m++) {
			if (!l1[m]) {
				fin.add(m);
				for (int k = m * m; k <= n1; k += m)
					l1[k] = true;
			}
			last = m;
		}
		for (int m = last + 1; m <= n1; m++) {
			if (!l1[m])
				fin.add(m);
		}
		return fin;
	}
	public static IntL factor(int n1) {
		IntL l1 = new IntL();
		for (int i = 1; i * i <= n1; i++) {
			if (n1 % i == 0) {
				l1.add(i);
				if (i != n1 / i)
					l1.add(n1 / i);
			}
		}
		return l1;
	}
	public static long gcd(long n1, long n2) {
		return n2 == 0 ? n1 : gcd(n2, n1 % n2);
	}
	public static long modInverse(long n1, long mod){
		long top = mod;
		long bot = n1;
		long bot1 = 0;
		long bot2 = 1;
		for (;;){
			if (bot == 1) break;
			long times = top / bot;
			long rmd = top % bot;
			long bot3 = bot1 - times * bot2;
			bot1 = bot2;
			bot2 = bot3;
			top = bot;
			bot = rmd;
		}
		return Modz.mod(bot2, mod);
	}
	public static int[] xgcd(int a, int b) {
		if (b == 0)
			return new int[] { 1, 0, a };
		int[] last = xgcd(b, a % b);
		int temp = last[0];
		last[0] = last[1];
		last[1] = temp;
		last[1] -= last[0] * (a / b);
		return last;
	}
	public static int chineseRemainder(int[] a, int[] m, int n) {
		int M = 1;
		for (int i = 0; i < n; ++i)
			M *= m[i];
		int ret = 0;
		for (int i = 0; i < n; ++i) {
			int tm = M / m[i];
			int[] l1 = xgcd(tm, m[i]);
			ret = (ret + tm * l1[0] * a[i]) % M;
		}
		return (ret + M) % M;
	}
	public static long lcm(long a, long b){
		return a * b / gcd(a,b);
	}
	public static int phi(int n1) {
		int fin = n1;
		for (int i = 2; i * i <= n1; i++) {
			if (n1 % i == 0) {
				while (n1 % i == 0)
					n1 /= i;
				fin -= fin / i;
			}
		}
		if (n1 > 1)
			fin -= fin / n1;
		return fin;
	}
	static int[] allPhi(int n1) {
		int[] fin = new int[n1 + 1];
		for (int i = 1; i <= n1; i++)
			fin[i] = i;
		for (int i = 2; i <= n1; i += 2)
			fin[i] >>= 1;
		for (int i = 3; i <= n1; i += 2) {
			if (fin[i] == i) {
				for (int j = i; j <= n1; j += i) {
					fin[j] = fin[j] / i * (i - 1);
				}
			}
		}
		return fin;
	}
	public static long discLog(long base, long right, long mod) {
		long gcd = NT.gcd(base, mod);
		if (right % gcd != 0)
			return -1;
		HashMap<Long, Long> m1 = new HashMap();
		long k1 = 0;
		for (long i = 0, ptr = 1 % mod; i * i <= mod;) {
			long val = ptr * right % mod;
			m1.put(val, i);
			ptr = ptr * base % mod;
			i++;
			k1 = i;
		}
		long pow = Modz.pow(base, k1, mod);
		for (long i = k1, ptr = pow; i <= mod; i += k1) {
			if (m1.containsKey(ptr)) {
				return i - m1.get(ptr);
			}
			ptr = ptr * pow % mod;
		}
		return -1;
	}
	public static boolean millerRabinX(long x1, long n1) {
		long y = n1 - 1l;
		while (!((y & 1) == 1))
			y >>= 1;
		x1 = Modz.pow(x1, y, n1);
		while (y < n1 - 1l && x1 != 1 && x1 != n1 - 1l) {
			x1 = (x1 * x1) % n1;
			y <<= 1;
		}
		return x1 == n1 - 1l || (y & 1l) == 1l;
	}
	public static boolean millerRabin(long n1) {
		if (n1 == 2 || n1 == 7 || n1 == 61)
			return true;
		if (n1 == 1 || (n1 & 1l) == 0)
			return false;
		if (!millerRabinX(2, n1))
			return false;
		if (!millerRabinX(7, n1))
			return false;
		if (!millerRabinX(61, n1))
			return false;
		return true;
	}
}

private static 
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

private static 
 class PolynomialHash {
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

}
