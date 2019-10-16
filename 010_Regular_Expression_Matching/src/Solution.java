import java.util.HashSet;
import java.util.Set;

public class Solution {

    // 递归
//    public boolean isMatch(String s, String p) {
//        if (p.isEmpty()) return s.isEmpty();
//
//        boolean firstMatch = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));
//        if (p.length() >= 2 && p.charAt(1) == '*') {
//            return (firstMatch && isMatch(s.substring(1), p) || isMatch(s, p.substring(2)));
//        } else {
//            return firstMatch && isMatch(s.substring(1), p.substring(1));
//        }
//    }

    // 动态规划
    // https://leetcode.com/problems/regular-expression-matching/discuss/191830/Java-DP-solution-beats-100-with-explanation
//
//    public boolean isMatch(String s, String p) {
//        if (p.isEmpty()) return s.isEmpty();
//
//        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
//        dp[0][0] = true;
//
//        for (int i = 2; i <= p.length(); i++) {
//            if (p.charAt(i-1) == '*' && dp[0][i-2]) {
//                dp[0][i] = true;
//            }
//        }
//
//        for (int i = 1; i <= s.length(); i++) {
//            for (int j = 1; j <= p.length(); j++) {
//
//                if (p.charAt(j-1) == '*') {
//                    boolean firstMatch = (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2) == '.');
//                    dp[i][j] = (firstMatch && dp[i-1][j]) || dp[i][j-2] ;
//                } else {
//                    boolean firstMatch = (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1) == '.');
//                    dp[i][j] = firstMatch && dp[i-1][j-1];
//                }
//            }
//        }
//        return dp[s.length()][p.length()];
//    }

    // NFA
    //https://leetcode.com/problems/regular-expression-matching/discuss/126062/Java-solution-using-NFA
    private class NFA {
        private char[] re;
        private DiGraph G;
        private int M;

        public NFA(String regexp) {
            re = regexp.toCharArray();
            M = re.length;
            G = new DiGraph(M+1);  // one extra end state

            for (int i = 0; i < M; i++) {
                if (re[i] == '*') G.addEdge(i, i+1);
                if (i+1 < M && re[i+1] == '*') {
                    G.addEdge(i, i+1);
                    G.addEdge(i+1, i);
                }
            }
        }

        public boolean recognizes(String txt) {
            Set<Integer> pc = new HashSet<>();
            DirectedDFS dfs = new DirectedDFS(G, 0);

            for (int v = 0; v < G.V(); v++) {
                if (dfs.marked(v)) pc.add(v);
            }

            for (int i = 0; i < txt.length(); i++) {
                Set<Integer> match = new HashSet<>();
                for (int v : pc) {
                    if (v < M) {
                        if (re[v] == '.' || re[v] == txt.charAt(i)) match.add(v+1);
                    }
                }
                pc = new HashSet<>();
                dfs = new DirectedDFS(G, match);
                for (int v = 0; v < G.V(); v++) {
                    if (dfs.marked(v)) pc.add(v);
                }
            }
            return pc.contains(M);
        }
    }

    private class DiGraph {

        private Set<Integer>[] adj;
        private int V;

        public DiGraph(int V) {
            this.V = V;
            adj = new HashSet[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new HashSet<>();
            }
        }

        public void addEdge(int v, int w) {
            adj[v].add(w);
        }

        public Set<Integer> adj(int v) {
            return adj[v];
        }

        public int V() {
            return V;
        }
    }

    private class DirectedDFS {
        private boolean[] marked;
        private DiGraph G;

        public DirectedDFS(DiGraph G, int s) {
            marked = new boolean[G.V()];
            dfs(G, s);
        }

        public DirectedDFS(DiGraph G, Set<Integer> S) {
            marked = new boolean[G.V()];
            for (int s : S) {
                if (marked[s]) continue;
                dfs(G, s);
            }
        }

        private void dfs(DiGraph G, int s) {
            marked[s] = true;
            for (int v : G.adj(s)) {
                if (marked[v]) continue;
                dfs(G, v);
            }
        }

        public boolean marked(int v) {
            return marked[v];
        }
    }

    public boolean isMatch(String s, String p) {
        NFA nfa = new NFA(p);
        return nfa.recognizes(s);
    }
}
