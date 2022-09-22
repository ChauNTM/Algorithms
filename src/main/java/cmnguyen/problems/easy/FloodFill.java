package main.java.cmnguyen.problems.easy;

public class FloodFill {

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        floodFill(image, sr, sc, originalColor, color);
        return image;
    }

    private static void floodFill(int[][] image, int sr, int sc, int originalColor,int color) {
        if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length &&
                image[sr][sc] == originalColor && originalColor != color) {
            image[sr][sc] = color;
            floodFill(image, sr - 1, sc, originalColor, color);
            floodFill(image, sr + 1, sc, originalColor, color);
            floodFill(image, sr, sc - 1, originalColor, color);
            floodFill(image, sr, sc + 1, originalColor, color);
        }
    }

}
