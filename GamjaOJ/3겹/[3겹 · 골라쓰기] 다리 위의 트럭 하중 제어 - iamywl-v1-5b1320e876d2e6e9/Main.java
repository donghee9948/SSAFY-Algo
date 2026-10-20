import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        //W대 트럭, L 최대 하중 , W초 시간 소요
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int [] kg = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i =0; i<N; i++){
                kg[i] = Integer.parseInt(st.nextToken());
            }
            //큐에 넣고 빼기
            ArrayDeque<Integer> que = new ArrayDeque<>();
            for(int i =0; i<W; i++){
                que.offer(0);
            }

            int time = 0;
            int weight = 0 ;
            int idx = 0;
            while(idx<N){
                time++;
                weight -= que.poll();
                if(weight+kg[idx]<=L){
                    que.offer(kg[idx]);
                    weight+=kg[idx];
                    idx++;
                }else{
                    que.offer(0);
                }

            }
            System.out.println("#"+tc+" "+(time+W));         
        }
    }
}
