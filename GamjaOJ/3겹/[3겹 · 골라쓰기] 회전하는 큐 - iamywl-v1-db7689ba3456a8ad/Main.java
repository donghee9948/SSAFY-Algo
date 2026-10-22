
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] answer = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                answer[i] = Integer.parseInt(st.nextToken());
            }

            LinkedList<Integer> que = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                que.addLast(i);
            }

            int result = 0;
            int idx = 0;

            while (idx < M) {
                if (que.peekFirst() == answer[idx]) {
                    que.pollFirst();
                    idx++;
                    continue;
                }
                int pos = que.indexOf(answer[idx]);
                if (pos > que.size() / 2) {
                    int a = que.pollLast();
                    que.offerFirst(a);
                    result++;
                } else {
                    int a = que.pollFirst();
                    que.offerLast(a);
                    result++;
                }
            }
            System.out.println("#" + tc + " " + result);
        }
    }
}

