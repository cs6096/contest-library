package miscellaneous;

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
