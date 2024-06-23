import java.util.ArrayList;
import java.util.List;

public class CyclicGraph {

    private boolean dfs(List<Integer>[] graph, int src, boolean[] st, boolean[] vis) {

        vis[src] = true;

        for (int neigh : graph[src]) {

            if (st[neigh])
                return true;

            if (!vis[neigh]) {

                st[neigh] = true;

                if (dfs(graph, neigh, st, vis))
                    return true;

                st[neigh] = false;
            }
        }

        return false;
    }

    public int solve(int A, int[][] B) {

        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[A + 1];

        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < B.length; i++) {

            int u = B[i][0], v = B[i][1];
            graph[u].add(v);
        }

        boolean[] vis = new boolean[A + 1];
        boolean[] st = new boolean[A + 1];
        st[1] = true;

        for (int i = 1; i <= A; i++) {

            boolean flag = dfs(graph, i, st, vis);

            if (flag)
                return 1;
        }

        return 0;
    }
}
