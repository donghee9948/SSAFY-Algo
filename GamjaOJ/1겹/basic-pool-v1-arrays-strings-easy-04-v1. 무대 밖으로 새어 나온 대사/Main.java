import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        boolean flag = true;
        char[] input = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : input){
            switch(c){
                case '|' : flag = !flag; break;
                default : if(flag) sb.append(c);
            }
        }
        System.out.print(sb.length()==0?"-":sb);
        // 문제의 입력 형식에 맞춰 읽고 결과를 출력하세요.
    }
}
