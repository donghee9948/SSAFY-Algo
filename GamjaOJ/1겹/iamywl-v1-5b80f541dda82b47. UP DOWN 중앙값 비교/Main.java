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
            int target = Integer.parseInt(st.nextToken());

            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int mid = (N - 1) / 2;
            if (target == arr[mid]) {
                System.out.println("#" + tc + " EQUAL " + mid);

            } else if (target < arr[mid]) {
                System.out.println("#" + tc + " LEFT 0 " + (mid - 1));

            } else {
                System.out.println("#" + tc + " RIGHT " + (mid + 1) + " " + (N - 1));
            }
        }
    }
}
