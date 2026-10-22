import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++){
            LinkedList<Integer> list = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i =0; i<N; i++){
                int a = Integer.parseInt(st.nextToken());
                list.add(a);
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i =0; i<M; i++){
                String command = st.nextToken();
                if(command.equals("I")){
                    int idx = Integer.parseInt(st.nextToken());
                    int cnt = Integer.parseInt(st.nextToken());
                    for(int j =0 ; j<cnt; j++){
                        int s1 = Integer.parseInt(st.nextToken());
                        list.add(idx+j,s1);
                    }
                }
                if(command.equals("D")){
                    int idx = Integer.parseInt(st.nextToken());
                    int cnt = Integer.parseInt(st.nextToken());
                    for(int j =0; j<cnt; j++){
                        list.remove(idx);
                    }
                }
                if(command.equals("A")){
                    int cnt = Integer.parseInt(st.nextToken());
                    for(int j =0; j<cnt; j++){
                        int s1 = Integer.parseInt(st.nextToken());
                        list.add(s1);
                    }
                }
            }
            System.out.print("#"+tc);
            for(int i =0; i<Math.min(10,list.size());i++){
                System.out.print(" "+ list.get(i));
            }

            System.out.println();
        }
        
    }
}
