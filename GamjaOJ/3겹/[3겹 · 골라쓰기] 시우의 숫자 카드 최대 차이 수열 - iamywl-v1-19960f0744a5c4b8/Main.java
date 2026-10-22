import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,max;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            visited = new boolean[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            max = Integer.MIN_VALUE;
            dfs(0,0,0);
            System.out.println("#"+tc+" "+max);
            
        }
        // 문제의 입력 형식에 맞춰 읽고 결과를 출력하세요.
    }
    static void dfs(int depth, int sum,int prev){
        if(depth ==N){
            max = Math.max(max,sum);
            return;
        }
        for(int i =0; i<N; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            if(depth == 0 ){
                dfs(depth+1, sum , arr[i]);
            }else{
                dfs(depth+1, sum+Math.abs(prev-arr[i]),arr[i]);
            }
            visited[i] =false;
            
        }

        
    }



}
