package algorithm;

/**
 * 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * <p>
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 * <p>
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 * <p>
 * 最后返回经过上色渲染后的图像。
 *
 * @Author: Hr_Ending
 * @Date: 2020/8/16 15:16
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image.length == 0 || image[0].length == 0) {
            return image;
        }
        if (image[sr][sc] == newColor) {
            return image;
        }
        int originColor = image[sr][sc];
        image[sr][sc] = newColor;
        //上
        if (sr - 1 >= 0 && image[sr - 1][sc] == originColor) {
            floodFill(image, sr - 1, sc, newColor);
        }
        //下
        if (sr + 1 < image.length && image[sr + 1][sc] == originColor) {
            floodFill(image, sr + 1, sc, newColor);
        }
        //左
        if (sc - 1 >= 0 && image[sr][sc - 1] == originColor) {
            floodFill(image, sr, sc - 1, newColor);
        }
        //右
        if (sc + 1 < image[sr].length && image[sr][sc + 1] == originColor) {
            floodFill(image, sr, sc + 1, newColor);
        }
        return image;
    }
}
