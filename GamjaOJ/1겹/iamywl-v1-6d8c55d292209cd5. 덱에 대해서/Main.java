import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc<=T; tc++){
            int A = Integer.parseInt(br.readLine());
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            System.out.print("#"+tc);
            for(int i =0; i<A; i++){
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                if(cmd.equals("push_back")){
                    int N = Integer.parseInt(st.nextToken());
                    deque.offer(N);
                }
                if(cmd.equals("push_front")){
                    int N = Integer.parseInt(st.nextToken());
                    deque.offerFirst(N);
                }
                if(cmd.equals("front")){
                    if(deque.isEmpty()){
                        System.out.print(" "+-1);
                    }else{
                        System.out.print(" "+deque.peekFirst());
                    }
                }
                if(cmd.equals("back")){
                    if(deque.isEmpty()){
                        System.out.print(" "+ -1);
                    }else{
                        System.out.print(" "+deque.peekLast());
                    }
                }
                if(cmd.equals("pop_front")){
                    if(deque.isEmpty()){
                        System.out.print(" "+-1);
                    }else{
                        System.out.print(" "+deque.pollFirst());
                    }
                }
                if(cmd.equals("pop_back")){
                    if(deque.isEmpty()){
                        System.out.print(" "+-1);
                    }else{
                        System.out.print(" "+deque.pollLast());
                    }
                }
                if(cmd.equals("size")){
                    System.out.print(" "+deque.size());
                }
                if(cmd.equals("empty")){
                    if(deque.isEmpty()){
                        System.out.print(" "+ 1);
                    }else{
                        System.out.print(" "+0);
                    }
                }
                
            }
            System.out.println();
        }
        // 문제의 입력 형식에 맞춰 읽고 결과를 출력하세요.
    }
}
