import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for(int i =0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int A = Integer.parseInt(st.nextToken());
                if(cmd.equals("PUT_FRONT")){
                    deque.offerFirst(A);
                    if(deque.size()>K){
                        deque.pollLast();
                    }
                }
                if(cmd.equals("PUT_BACK")){
                    deque.offer(A);
                    if(deque.size()>K){
                        deque.pollFirst();
                    }
                }
            }
            System.out.print("#"+tc);
            for(int i = 0; i<K; i++){
                System.out.print(" "+deque.pollFirst());
            }
            System.out.println();
        }
        
        // 문제의 입력 형식에 맞춰 읽고 결과를 출력하세요.
    }
}
