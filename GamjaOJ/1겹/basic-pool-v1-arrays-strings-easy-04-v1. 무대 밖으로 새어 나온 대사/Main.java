
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        boolean A =true;
        String str = br.readLine();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        char ch[] = new char[str.length()];
        for(int i =0; i<str.length();i++){
            ch[i] = str.charAt(i);
        }
        for(int i = 0; i<str.length();i++){
            if(ch[i] == '|'){
                if(A == true){
                    A =false;
                }else{
                    A = true;
                }
            }
            if(ch[i]!='|' && A == true){
                deque.offer(ch[i]);
            }

        }
        int L = deque.size();
        if(deque.isEmpty()){
            System.out.print("-");
        }else{
            for(int i = 0 ; i<L; i++){
                System.out.print(deque.pollFirst());
            }
        }
 
        // 문제의 입력 형식에 맞춰 읽고 결과를 출력하세요.
    }
}
