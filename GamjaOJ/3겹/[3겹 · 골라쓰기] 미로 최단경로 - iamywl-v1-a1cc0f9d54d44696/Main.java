import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int startX, startY, endX, endY;
    static int[] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());
            map = new int[16][16];
            visited = new boolean[16][16];
            
            for(int i =0; i<16; i++){
                char[] ch = br.readLine().toCharArray();
                for(int j=0; j<16;j++){
                    map[i][j] = ch[j] - '0';

                    if(map[i][j] == 2){
                        startX = i;
                        startY = j;
                    }
                    if(map[i][j] == 3){
                        endX = i;
                        endY = j;
                    }
                }
            }
            int result = bfs(startX, startY, endX, endY);
            System.out.println("#"+tc+" "+result);
            
        }
        // 문제의 입력 형식에 맞춰 읽고 결과를 출력하세요.
    }
    static int bfs(int startX, int startY, int endX, int endY){

        //출발
        Queue<int []> que = new ArrayDeque<>();
        que.offer(new int[]{startX,startY,0});
        visited[startX][startY] = true;

        while(!que.isEmpty()){
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if(x == endX && y== endY){
                return dist;
            }
            for(int d=0; d<4; d++){
                int nx = x + dr[d];
                int ny = y + dc[d];
                if(nx< 0 || ny < 0 || nx>=16 || ny>=16 || map[nx][ny] == 1){
                    continue;
                }
                if(visited[nx][ny]){
                    continue;
                }
                visited[nx][ny] = true;
                que.offer(new int[]{nx,ny,dist+1});
            }

            
        }
        return -1;

        
    }
}
