import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());
            int Left[] = new int[N/2];
            int Right[] = new int[N/2];
            int LeftSum =0;
            int RightSum = 0;
            st = new StringTokenizer(br.readLine());
            for(int i =0; i<N/2; i++){
                Left[i] = Integer.parseInt(st.nextToken());
                LeftSum+=Left[i];
            }
            for(int i =0; i<N/2; i++){
                Right[i] = Integer.parseInt(st.nextToken());
                RightSum += Right[i];
            }
            int answer = LeftSum -RightSum;
            if(answer<0){
                System.out.println("#"+tc+" "+Math.abs(answer)+" RIGHT");
            }else if(answer>0){
                System.out.println("#"+tc+" "+Math.abs(answer)+" LEFT");
            }else{
                System.out.println("#"+tc+" "+ 0 +" EQUAL");
            }
        }
        // 문제의 입력 형식에 맞춰 읽고 결과를 출력하세요.
    }
}
