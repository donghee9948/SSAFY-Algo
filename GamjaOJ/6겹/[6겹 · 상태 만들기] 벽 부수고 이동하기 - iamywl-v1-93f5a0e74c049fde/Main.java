import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    //N,M
    static int N,M;

    //맵이랑 방문처리
    static int[][] map;
    static boolean[][][] visited;

    //방향 전환
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    //시작점 끝점
    static int startX, startY, endX, endY;
    
    public static void main(String[] args) throws IOException {
        // 문제의 입력 형식에 맞춰 읽고 결과를 출력하세요.
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M][2];
            startX = 0;
            startY = 0;
            endX = N-1;
            endY = M-1;
            for(int i =0; i<N; i++){
                char[] ch = br.readLine().toCharArray();
                for(int j = 0; j<M; j++){
                    map[i][j] = ch[j] - '0';
                }
            }
            int result = bfs();

            System.out.println("#"+tc+" "+result);
            
        }
        
    }
    static int bfs(){
        Queue<int[]> que = new ArrayDeque<>();

        que.offer(new int[] {startX, startY, 0, 0});
        visited[startX][startY][0] = true;

        while(!que.isEmpty()){
            int[] cur = que.poll();
            int row = cur[0];
            int col = cur[1];
            int dist = cur[2];
            int wall = cur[3];
            
            if(row ==endX && col == endY){
                return dist;
            }

            for(int d=0; d<4; d++){
                int nextrow = row + dr[d];
                int nextcol = col + dc[d];

                if(nextrow<0 || nextrow >= N || nextcol <0 || nextcol >=M ){
                    continue;
                }
                if(map[nextrow][nextcol]==1){
                    if(wall == 1){
                        continue;
                    }
                    if(!visited[nextrow][nextcol][1]){
                        visited[nextrow][nextcol][1] = true;
                        que.offer(new int[] {nextrow, nextcol, dist+2, 1});
                    }
                }else{
                    if(!visited[nextrow][nextcol][wall]){
                        visited[nextrow][nextcol][wall] = true;
                        que.offer(new int[] {nextrow, nextcol, dist+1,wall});
                        
                    }
                }
            }         
        }
        return -1;
    }
}
