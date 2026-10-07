import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int parent[] = new int [N+1];
            for(int i = 0; i<=N; i++){
                parent[i] = i;
            }
            System.out.print("#"+tc);
            for(int i =0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                if(cmd == 1){
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    parent[b] = a;
                }
                if(cmd == 2){
                    int x = Integer.parseInt(st.nextToken());
                    System.out.print(" "+parent[x]);
                }
            }
            System.out.println();
    
            
        }
        
        // 문제의 입력 형식에 맞춰 읽고 결과를 출력하세요.
    }
}
