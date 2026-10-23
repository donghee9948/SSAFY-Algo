import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    //시작점 , 도착점
    static int StartX,StartY,EndX,EndY;
    //상하좌우
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        //int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=10; tc++){ 
            String str = br.readLine();
            if(str == null)
                break;
            int T = Integer.parseInt(str);
            map = new int[16][16];
            visited = new boolean[16][16];
            for(int i = 0; i<16; i++){
                char[] input = br.readLine().toCharArray();
                for(int j =0; j<16; j++){
                    map[i][j] = input[j] - '0';
                    if(map[i][j] ==2){
                        StartX = i;
                        StartY = j;
                    }else if(map[i][j]==3){
                        EndX = i;
                        EndY = j;
                    }
                }
            }
            int result = bfs(StartX, StartY, EndX, EndY);
            System.out.println("#"+tc+" "+result);
        }
        
        // 문제의 입력 형식에 맞춰 읽고 결과를 출력하세요.
    }
    static int bfs(int StartX, int StartY, int EndX, int EndY){
        Queue<int[]> que = new ArrayDeque<>();
        //시작점 출발
        que.offer(new int[] {StartX, StartY, 0});
        visited[StartX][StartY] = true;

        while(!que.isEmpty()){
            int[] cur = que.poll();
            
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            if(x==EndX && y == EndY){
                return dist;
            }
            for(int d = 0; d<4; d++){
                int nx = x+dr[d];
                int ny = y+dc[d];
                if(nx < 0 || ny<0 || nx >=16 || ny>=16 || map[nx][ny] == 1){
                    continue;
                }
                if(visited[nx][ny]) continue;
                visited[x][y] = true;
                que.offer(new int[] {nx,ny,dist+1});
            }
        }
        return -1;
    }
}
