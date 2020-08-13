package algorithm;

/**
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 说明:
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 *
 * @Author: Hr_Ending
 * @Date: 2020/8/13 21:25
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int l = 9;
        //行
        boolean[][] rows = new boolean[l][l];
        //列
        boolean[][] cols = new boolean[l][l];
        //九格盒子
        boolean[][] boxes = new boolean[l][l];

        for (int r = 0; r < l; ++r) {
            for (int c = 0; c < l; ++c) {
                if (board[r][c] != '.') {
                    int value = board[r][c] - '1';
                    //计算当行列属于哪个盒子
                    int boxIndex = r / 3 * 3 + c / 3;
                    if (rows[r][value] || cols[c][value] || boxes[boxIndex][value]) {
                        return false;
                    }
                    rows[r][value] = true;
                    cols[c][value] = true;
                    boxes[boxIndex][value] = true;
                }
            }
        }
        return true;
    }
}
