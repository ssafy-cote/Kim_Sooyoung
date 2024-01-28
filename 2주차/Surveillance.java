package study;

/**도저히 혼자 못풀겠어서 정답 코드 보고 만들었습니다... 나중에 다시 풀게요 **/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Surveillance {
    private static int n, m, result = Integer.MAX_VALUE;
    private static int[][] board, copyBoard;
    private static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    private static int[] dy = {0, 0, -1, 1};
    private static ArrayList<Pair> cameras = new ArrayList<>();

    private static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int blindSpot() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyBoard[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void copyArray() {
        for (int i = 0; i < n; i++) {
            System.arraycopy(board[i], 0, copyBoard[i], 0, m);
        }
    }

    private static void changeBoard(int x, int y, int d) {
        int nx = x + dx[d];
        int ny = y + dy[d];

        while (0 <= nx && nx < n && 0 <= ny && ny < m) {
            if (copyBoard[nx][ny] == 6) break;
            if (copyBoard[nx][ny] == 0) {
                copyBoard[nx][ny] = -1;
            }
            nx += dx[d];
            ny += dy[d];
        }
    }

    private static void dfs(int index) {
        if (index == cameras.size()) {
            copyArray();
            for (Pair camera : cameras) {
                int type = board[camera.x][camera.y];
                // 각 CCTV 타입에 따른 감시 방향 설정
                // ...
            }
            result = Math.min(result, blindSpot());
            return;
        }

        int x = cameras.get(index).x;
        int y = cameras.get(index).y;
        int type = board[x][y];

        for (int d = 0; d < 4; d++) {
            if (type == 1) {
                // Type 1: 한 방향
                changeBoard(x, y, d);
                dfs(index + 1);
                copyArray();
            } else if (type == 2) {
                // Type 2: 반대 방향 두 개
                if (d < 2) {
                    changeBoard(x, y, d);
                    changeBoard(x, y, d + 2);
                    dfs(index + 1);
                    copyArray();
                }
            } else if (type == 3) {
                // Type 3: 직각 방향 두 개
                changeBoard(x, y, d);
                changeBoard(x, y, (d + 1) % 4);
                dfs(index + 1);
                copyArray();
            } else if (type == 4) {
                // Type 4: 세 방향
                changeBoard(x, y, d);
                changeBoard(x, y, (d + 1) % 4);
                changeBoard(x, y, (d + 2) % 4);
                dfs(index + 1);
                copyArray();
            } else if (type == 5) {
                // Type 5: 모든 방향
                if (d == 0) {
                    for (int i = 0; i < 4; i++) {
                        changeBoard(x, y, i);
                    }
                    dfs(index + 1);
                    copyArray();
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        board = new int[n][m];
        copyBoard = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = scanner.nextInt();
                if (1 <= board[i][j] && board[i][j] <= 5) {
                    cameras.add(new Pair(i, j));
                }
            }
        }

        dfs(0);
        System.out.println(result);
        scanner.close();
    }
}
