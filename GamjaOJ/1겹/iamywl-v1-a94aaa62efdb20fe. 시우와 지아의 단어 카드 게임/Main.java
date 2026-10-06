import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            ArrayDeque<Character> deque = new ArrayDeque<>();
            char[] ch = new char[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                ch[i] = st.nextToken().charAt(0);
                if (deque.isEmpty()) {
                    deque.offer(ch[i]);
                } else if (deque.peekFirst() < ch[i]) {
                    deque.offerLast(ch[i]);
                } else {
                    deque.offerFirst(ch[i]);
                }
            }
            System.out.print("#" + tc + " ");
            for (int i = 0; i < N; i++) {
                System.out.print(deque.pollFirst());
            }
            System.out.println();
        }
    }
}


