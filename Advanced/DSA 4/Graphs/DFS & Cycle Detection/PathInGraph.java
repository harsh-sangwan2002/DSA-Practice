import java.util.ArrayList;
import java.util.List;

public class PathInGraph {

    private void dfs(List<Integer>[] graph, int src, boolean[] vis) {

        vis[src] = true;

        for (int neigh : graph[src]) {

            if (!vis[neigh])
                dfs(graph, neigh, vis);
        }
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

        dfs(graph, 1, vis);

        return vis[A] ? 1 : 0;
    }
}
