package algorithm;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 * <p>
 * 一个数独的解法需遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 * @Author: Hr_Ending
 * @Date: 2020/9/15 21:24
 */
public class SolveSudoku {
    //数独的长宽大小
    final int N = 9;
    //行
    private int[] rows = new int[N];
    //列
    private int[] cols = new int[N];
    //单元格
    private int[][] cells = new int[3][3];

    public void solveSudoku(char[][] board) {
        //统计未填的个数
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    count++;
                } else {
                    //如果已经有数字，把这个数字标记一下
                    fillNumber(i, j, ch - '1', true);
                }
            }
        }
        //上面是一些计算前的准备工作，从这里开始调用回溯算法
        backtrace(board, count);
    }

    private boolean backtrace(char[][] board, int count) {
        //如果可填的位置为0，就是填完了，直接返回true
        if (count == 0) {
            return true;
        }
        //找到可选择数字比较少的位置
        int[] pos = getMinOkMaskCountPos(board);
        int x = pos[0], y = pos[1];
        //获取可选择数字比较少的位置的mask
        int mask = getMask(x, y);
        for (char c = '1'; c <= '9'; c++) {
            int index = c - '1';
            //判断这个位置是否可以填字符c
            if (testMask(mask, index)) {
                //如果可填，就把字符c填入到这个位置中
                fillNumber(x, y, index, true);
                board[x][y] = c;
                //如果成功直接返回
                if (backtrace(board, count - 1)) {
                    return true;
                }
                //否则，撤销上面的操作
                board[x][y] = '.';
                fillNumber(x, y, index, false);
            }
        }
        return false;
    }

    //如果fill是true就把对应位置的数字从右边数第（n+1）位变为1，如果fill为false就把
    //对应位置的数字从右边数第（n+1）位变为0，
    private void fillNumber(int x, int y, int n, boolean fill) {
        if (fill) {
            int mask = 1 << n;
            rows[x] = rows[x] | mask;
            cols[y] = cols[y] | mask;
            cells[x / 3][y / 3] = cells[x / 3][y / 3] | mask;
        } else {
            int mask = ~(1 << n);
            rows[x] = rows[x] & mask;
            cols[y] = cols[y] & mask;
            cells[x / 3][y / 3] = cells[x / 3][y / 3] & mask;
        }
    }

    //当前位置的行，列，单元格进行与运算，运算的结果就是如果这个数字的
    //后面9位哪一个位置是0，就表示这个位置可以填对应的数字
    private int getMask(int x, int y) {
        return rows[x] | cols[y] | cells[x / 3][y / 3];
    }

    //统计上面的方法有多少位置还可以填
    private int getCount(int mask) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if ((mask & (1 << i)) == 0) {
                count++;
            }
        }
        return count;
    }

    //判断mask从右边数第（index+1）个位置是否可以填入数字，
    //注意这里的index是从0开始，如果是0，就表示判断右边第1位
    //能不能填入数字
    private boolean testMask(int mask, int index) {
        return (mask & (1 << index)) == 0;
    }

    //统计所有的单元格，判断哪个单元格内可填数字比较少，就返回哪个单元格的坐标
    private int[] getMinOkMaskCountPos(char[][] board) {
        int[] res = new int[2];
        int min = 10;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '.') {
                    int mask = getMask(i, j);
                    int count = getCount(mask);
                    if (count < min) {
                        min = count;
                        res[0] = i;
                        res[1] = j;
                    }
                }
            }
        }
        return res;
    }
}
