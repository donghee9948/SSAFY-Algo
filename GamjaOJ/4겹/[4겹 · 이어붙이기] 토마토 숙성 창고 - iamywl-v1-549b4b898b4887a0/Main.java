import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int M, N, H, count;
    static int[][][] map;
    static int[] dr = {-1, 0, 1, 0, 0, 0};
    static int[] dc = {0, 1, 0, -1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); 
            N = Integer.parseInt(st.nextToken()); 
            H = Integer.parseInt(st.nextToken()); 
            map = new int[N][M][H];
            count = 0;
            Queue<int[]> que = new ArrayDeque<>();
            for (int height = 0; height < H; height++) {
                for (int row = 0; row < N; row++) {
                    st = new StringTokenizer(br.readLine());
                    for (int col = 0; col < M; col++) {
                        int value = Integer.parseInt(st.nextToken());
                        map[row][col][height] = value;

                        if (value == 0) {
                            count++;
                        }
                        if (value == 1) {
                            que.offer(new int[]{row, col, height});
                        }
                    }
                }
            }

            int day = 0;
            while (!que.isEmpty()) {
                if (count == 0) {
                    break;
                }
                int size = que.size();

                for (int i = 0; i < size; i++) {
                    int[] cur = que.poll();
                    int row = cur[0];
                    int col = cur[1];
                    int height = cur[2];
                    for (int d = 0; d < 6; d++) {
                        int nr = row + dr[d];
                        int nc = col + dc[d];
                        int nh = height + dh[d];
                        if (nr < 0 || nc < 0 || nh < 0 ||
                            nr >= N || nc >= M || nh >= H ||
                            map[nr][nc][nh] != 0) {
                            continue;
                        }
                        map[nr][nc][nh] = 1;
                        que.offer(new int[]{nr, nc, nh});
                        count--;
                    }
                }
                day++;
            }

            System.out.println("#" + tc + " " + (count != 0 ? -1 : day));
        }
    }
}

