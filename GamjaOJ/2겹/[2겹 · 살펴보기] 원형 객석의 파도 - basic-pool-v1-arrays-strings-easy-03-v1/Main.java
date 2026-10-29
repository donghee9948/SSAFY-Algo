import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cur = arr[0];
        int count = 1;
        int first = arr[0];

        // 1, 1 , 2
        //cur = 1, first 1 , count 1
        //
        
        for(int i = 1; i<N; i++){
            if(i == N-1){
                if(count>1  && arr[i]==first){
                    count--;
                }
                
            }
            if(cur != arr[i]){
                cur = arr[i];
                count++;
            }
            
        }
        System.out.println(count);

        
        
        
        // 문제의 입력 형식에 맞춰 읽고 결과를 출력하세요.
    }
}
