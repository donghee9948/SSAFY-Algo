import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int N,M,max;
    static int[][] map;
    static boolean[][] visited;
    static final int WALL = 3;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];
            max = 0;
            for(int row = 0; row<N; row++){
                st = new StringTokenizer(br.readLine());
                for(int col = 0; col<M; col++){
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0,0);
            System.out.println("#"+tc+" "+max);
        }
        // 문제의 입력 형식에 맞춰 읽고 결과를 출력하세요.
    }
    static void dfs(int start, int depth){
        if(depth == WALL){
            bfs();
            return;
        }
        for(int i = start; i<N*M; i++){
            int r = i/M;
            int c = i%M;
            if(map[r][c] !=0){
                continue;
            }
            map[r][c] = 1;
            dfs(i+1,depth+1);

            map[r][c] = 0;
        }
    }
    static void bfs(){
        int[][] copy = new int[N][M];
        visited = new boolean[N][M];

        Queue<int[]> que = new ArrayDeque<>();
        for(int r = 0; r<N; r++){
            for(int c=0; c<M; c++){
                copy[r][c]= map[r][c];

                if(copy[r][c]==2){
                    que.offer(new int[] {r,c});
                    visited[r][c] = true;
                }
            }
        }
        while(!que.isEmpty()){
            int [] cur = que.poll();

            int r = cur[0];
            int c = cur[1];

            for(int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];

                if(nr<0 || nc<0 || nr>=N || nc>=M){
                    continue;
                }
                if(visited[nr][nc]){
                    continue;
                }
                if(copy[nr][nc] == 0){
                    copy[nr][nc] = 2;
                    visited[nr][nc] = true;
                    que.offer(new int[]{nr,nc});
                }
            }
        }
        int count = 0;
        for(int r = 0; r<N; r++){
            for(int c = 0; c<M; c++){
                if(copy[r][c]==0){
                    count++;
                }
            }
        }
        max = Math.max(max,count);
    }
}
