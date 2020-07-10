public class Util {
	public static String coordStr(int x, boolean shown) {
		return shown ? (""+x) : "-";
	}

	public static String objectStr(int x, int y, boolean shown) {
		return "(" + coordStr(x, shown) + "," + coordStr(y, shown) + ")";
	}
}