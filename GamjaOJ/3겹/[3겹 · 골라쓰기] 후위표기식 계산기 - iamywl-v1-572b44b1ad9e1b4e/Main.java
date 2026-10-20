import java.io.*;
import java.util.*; 

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc= 1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());
            ArrayDeque<Long> que = new ArrayDeque<>();
            String str = br.readLine();

            for(int i =0; i<N; i++){
                char ch = str.charAt(i);
                if(ch>'0' && ch<='9'){
                    que.addLast((long)ch-'0');
                }else if(ch == '+'){
                    long a = que.pollLast();
                    long b = que.pollLast();
                    que.addLast(a+b);
                }else if(ch == '*'){
                    long a = que.pollLast();
                    long b = que.pollLast();
                    que.addLast(a*b);
                }
                

            }
            System.out.println("#"+tc+" "+que.pop());

            
            
        }
        // 문제의 입력 형식에 맞춰 읽고 결과를 출력하세요.
    }
}
