public class WordWrapper {
    private final String[] words;
    private final int[] lengths;
    private final int M;
    private final int n;
    private final int[] dp;
    private final int[] parent;

    public WordWrapper(String[] words, int[] lengths, int M) {
        this.words = words;
        this.lengths = lengths;
        this.M = M;
        this.n = lengths.length;
        this.dp = new int[n + 1];
        this.parent = new int[n + 1];
    }

    public void computeOptimal() {
        final int INF = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) dp[i] = INF;
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += lengths[j];
                if (j > i) sum++;

                if (sum > M) break;

                int spaces = M - sum;
                int cost = (j == n - 1) ? 0 : (int)Math.pow(spaces, 3);

                if (dp[i] > cost + dp[j + 1]) {
                    dp[i] = cost + dp[j + 1];
                    parent[i] = j + 1;
                }
            }
        }

        System.out.println("Costo mínimo de impresión: " + dp[0]);
    }

    public void printSolution() {
        int i = 0;
        System.out.println("\nDistribución óptima de líneas:");
        while (i < n) {
            for (int j = i; j < parent[i]; j++) {
                System.out.print(words[j] + " ");
            }
            System.out.println();
            i = parent[i];
        }
    }
}
