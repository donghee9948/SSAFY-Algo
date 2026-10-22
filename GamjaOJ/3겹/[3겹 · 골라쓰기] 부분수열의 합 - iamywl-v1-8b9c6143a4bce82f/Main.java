import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N,S,result;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());
            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i =0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            result = 0;
            dfs(0,0);   
            if(S==0){
                result--;
            }
            System.out.println("#"+tc+" "+result);
        }
    }
    static void dfs(int index, int sum){
        if(index == N ){
            if(sum==S){
                result++;
            }
            return;
        }

        dfs(index+1,sum+arr[index]);
        dfs(index+1,sum);
    }
}
