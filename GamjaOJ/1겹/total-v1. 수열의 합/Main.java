import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long arr[] = new long[N];
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        for(int i =0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
            sum+=arr[i];
        }
        System.out.println(sum);
        
        
        // 문제의 입력 형식에 맞춰 읽고 결과를 출력하세요.
    }
}
