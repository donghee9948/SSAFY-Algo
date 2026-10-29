import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char[][] map;
    static boolean[][] visited;
    static int H,W,K;
    static int sr,sc;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        visited = new boolean[H][W];
        for(int row = 0 ; row<H; row++){
            char[] ch = br.readLine().toCharArray();
            for(int col = 0; col<W; col++){
                map[row][col] = ch[col];
            }
        }
        st = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(st.nextToken());
        sc = Integer.parseInt(st.nextToken());
        sr = sr-1;
        sc = sc - 1;
        int result  = bfs();

        System.out.println(result); 
        
    }
    static int bfs(){
        Queue<int[]> que = new ArrayDeque<>();
        visited[sr][sc] = true;
        que.offer(new int[] {sr, sc, 0});
        int count = 1;

        while(!que.isEmpty()){
            int[] cur = que.poll();
            int row = cur[0];
            int col = cur[1];
            int k = cur[2];

            if(k == K){
                continue;
            }
            for(int d=0; d<4; d++){
                int nr = row + dr[d];
                int nc = col + dc[d];

                if(nr<0 || nc<0 || nr>=H || nc>=W){
                    continue;
                }
                if(map[nr][nc] == '#'){
                    continue;
                }
                if(visited[nr][nc]){
                    continue;
                }

                que.offer(new int[] {nr,nc,k+1});
                count++;
                visited[nr][nc] = true;
                
            }
        }
        return count;
    }
}
