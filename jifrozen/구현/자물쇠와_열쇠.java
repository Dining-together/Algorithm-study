class Solution {
    public static int n;

    // 2차원 배열 회전
    public static int[][] rotate(int[][] key) {
        int n = key.length;
        int result[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[n - 1 - j][i] = key[i][j];
            }
        }
        return result;
    }

    // 자물쇠 확인
    public static boolean check(int[][] newLock) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (newLock[n + i][n + j] != 1)
                    return false;
            }
        }
        return true;
    }

    public boolean solution(int[][] key, int[][] lock) {
        n = lock.length;
        int m = key.length;
        int[][] newLock = new int[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newLock[i + n][j + n] = lock[i][j];
            }
        }

        for (int k = 0; k < 4; k++) {
            key = rotate(key);
            for (int a = 0; a < n * 3 - m; a++) {
                for (int b = 0; b < n * 3 - m; b++) {
                    for (int c = 0; c < m; c++) {
                        for (int d = 0; d < m; d++) {
                            newLock[a + c][b + d] += key[c][d];
                        }
                    }
                    if (check(newLock)) {
                        return true;
                    }
                    for (int c = 0; c < m; c++) {
                        for (int d = 0; d < m; d++) {
                            newLock[a + c][b + d] -= key[c][d];
                        }
                    }
                }
            }
        }
        return false;
    }
}