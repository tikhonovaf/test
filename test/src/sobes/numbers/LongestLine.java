package sobes.numbers;

/*
ƒана бинарна€ матрица размера m x n. ¬ернуть длину самой длинной последовательной линии из единиц в матрице.

Ћини€ может быть горизонтальной, вертикальной, диагональной или анти-диагональной.

Ётот код использует динамическое программирование дл€ отслеживани€ длины последовательных линий единиц в четырех направлени€х:
горизонтально, вертикально, диагонально и анти-диагонально. ћаксимальна€ длина обновл€етс€ при каждом нахождении новой линии.


*/
public class LongestLine {
    public int longestLine(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return 0;
        }

        int m = mat.length;
        int n = mat[0].length;
        int maxLen = 0;
        int maxLen1 = 0;

// »нициализаци€ DP массивов
        int[][][] dp = new int[m][n][4];
        int hor = 0;
        int vert = 0;
        int diag = 0;
        int antiDiag = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j][0] = (j > 0 ? dp[i][j - 1][0] : 0) + 1; // √оризонтально
                    dp[i][j][1] = (i > 0 ? dp[i - 1][j][1] : 0) + 1; // ¬ертикально
                    dp[i][j][2] = (i > 0 && j > 0 ? dp[i - 1][j - 1][2] : 0) + 1; // ƒиагонально
                    dp[i][j][3] = (i > 0 && j < n - 1 ? dp[i - 1][j + 1][3] : 0) + 1; // јнти-диагонально

                    hor = (j > 0 ? hor : 0) + 1; // √оризонтально
                    vert = (i > 0 ? vert : 0) + 1; // ¬ертикально
                    diag= (i > 0 && j > 0 ? diag : 0) + 1; // ƒиагонально
                    antiDiag = (i > 0 && j < n - 1 ? antiDiag :0) + 1; // јнти-диагонально


// ќбновление максимальной длины
                    maxLen = Math.max(maxLen, dp[i][j][0]);
                    maxLen = Math.max(maxLen, dp[i][j][1]);
                    maxLen = Math.max(maxLen, dp[i][j][2]);
                    maxLen = Math.max(maxLen, dp[i][j][3]);

                    maxLen1 = Math.max(maxLen, hor);
                    maxLen1 = Math.max(maxLen, vert);
                    maxLen1 = Math.max(maxLen, diag);
                    maxLen1 = Math.max(maxLen, antiDiag);
                } else {
                    hor = 0;
                    vert = 0;
                    diag = 0;
                    antiDiag = 0;
                }
            }
        }
        System.out.println(maxLen);
        System.out.println(maxLen1);
        return maxLen;
    }

    public static void main(String[] args) {
        LongestLine solution = new LongestLine();
        int[][] mat = {{1, 0, 1, 1,1}, {0, 1, 1, 1,0}, {1, 0, 0, 1,0}};

        System.out.println(solution.longestLine(mat));
    }
}
