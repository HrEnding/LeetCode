package algorithm;

import java.util.List;

/**
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 * <p>
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * <p>
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * <p>
 * 你可以自由地在房间之间来回走动。
 * <p>
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 * @Author: Hr_Ending
 * @Date: 2020/8/31 21:31
 */
public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, 0, visited);
        for (boolean b : visited) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int idx, boolean[] visited) {
        if (visited[idx]) {
            return;
        }
        visited[idx] = true;
        for (int i : rooms.get(idx)) {
            dfs(rooms, i, visited);
        }
    }
}
