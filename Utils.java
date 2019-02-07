import java.util.Random;
import java.awt.Color;

public class Utils {
	private final static Random rand = new Random(0);
	private final static Color[] col = {Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};
	
	/**
	 * Returns a random double between lo and hi.
	 * @param lo the minimum value that could be returned
	 * @param hi the maximum value that could be returned
	 * @return a random double between lo and hi
	 */
	public static double randomDouble(double lo, double hi) {
		double range = hi - lo;
		return lo + rand.nextDouble() * range;
	}
	
	/**
	 * Returns a random color from the set
	 * {blue, cyan, gray, green magenta, orange, pink, red, white, yellow}
	 * @return a random color
	 */
	public static Color randomColor() {
		return col[rand.nextInt(col.length)];
	}
}
