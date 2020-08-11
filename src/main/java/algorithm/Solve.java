package algorithm;

/**
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * <p>
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 解释:
 * <p>
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 *
 * @Author: Hr_Ending
 * @Date: 2020/8/11 20:28
 */
public class Solve {

    private final static int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int row, column;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        //行
        row = board.length;
        //列
        column = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                //判断是否在边界
                boolean flag = (i == 0 || i == row - 1 || j == 0 || j == column - 1) && board[i][j] == 'O';
                if (flag) {
                    dfs(board, i, j);
                }
            }
        }
        //将被包围的'O'替换成'X'
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    /**
     * 判断是否被'X'包围
     *
     * @param board
     * @param i
     * @param j
     */
    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i > row - 1 || j < 0 || j > column - 1 || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        for (int[] direction : DIRECTIONS) {
            dfs(board, i + direction[0], j + direction[1]);
        }
    }
}
