/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
        double heightRatio = Math.sqrt(3) / 4;

        double y = 0.1 * heightRatio;
        double x1 = 0.0;
        double x2 = 1.0;
        double x3 = 0.5;
        double y1 = 0.0;
        double y2 = 0.0;
        double y3 = heightRatio;


        // Outline of the first triangle.
        StdDraw.line(x1, y1, x2, y2);
        StdDraw.line(x2, y2, x3, y3);
        StdDraw.line(x3, y3, x1, y1);

        sierpinski(n, x1, x2, x3, y1, y2, y3);
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {

		//// Replace this comment with your code
        if (n == 0) {
            // draw triangle.
            StdDraw.line(x1, y1, x2, y2);
            StdDraw.line(x2, y2, x3, y3);
            StdDraw.line(x3, y3, x1, y1);
            return;
        }
        final int X_CORD = 0;
        final int Y_CORD = 1;

        double[] firstMid = {(x1 + x2) / 2, (y1 + y2) / 2};
        double[] secondMid = {(x2 + x3) / 2, (y2 + y3) / 2};
        double[] thirdMid = {(x1 + x3) / 2, (y1 + y3) / 2};

        // Inverted triangles to override printing it twice.
        StdDraw.line(firstMid[X_CORD], firstMid[Y_CORD], secondMid[X_CORD], secondMid[Y_CORD]);
        StdDraw.line(secondMid[X_CORD], secondMid[Y_CORD], thirdMid[X_CORD], thirdMid[Y_CORD]);
        StdDraw.line(thirdMid[X_CORD], thirdMid[Y_CORD], firstMid[X_CORD], firstMid[Y_CORD]);

        sierpinski(n -1, x1, firstMid[X_CORD], thirdMid[X_CORD], y1, firstMid[Y_CORD], thirdMid[Y_CORD]);
        sierpinski(n -1, firstMid[X_CORD], x2, secondMid[X_CORD], firstMid[Y_CORD], y2, secondMid[Y_CORD]);
        sierpinski(n -1, thirdMid[X_CORD], secondMid[X_CORD], x3, thirdMid[Y_CORD], secondMid[Y_CORD], y3);
	}
}
