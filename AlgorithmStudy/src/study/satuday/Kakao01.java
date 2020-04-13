package study.satuday;

import javax.lang.model.element.NestingKind;
import java.util.*;

public class Kakao01 {

    public static void main(String[] args) {

        String str = "if (Count of eggs is 4.) {Buy milk.}" ;
        System.out.println("result : " +new Kakao01().solution(str) );

    }

    public int solution(String inputString) {
        int answer = 0;

        Deque s1 = new ArrayDeque<String>(); // ()
        Deque s2 = new ArrayDeque<String>(); // <>
        Deque s3 = new ArrayDeque<String>(); // {}
        Deque s4 = new ArrayDeque<String>(); // []

        int size = inputString.length();
        int pairCnt = 0;
        for(int i = 0 ; i < size ; i ++ ) {

            Character c = inputString.charAt(i);
            String a = String.valueOf(c);
            if("(".equals(c)){
                    s1.push(c);
            }else if("<".equals(c)){
                    s2.push(c);
            }else if("{".equals(c)){
                    s3.push(c);
            }else if("[".equals(c)){
                    s4.push(c);
            }

            if(")".equals(c)){
                if(!s1.isEmpty()){
                    s1.pop();
                    pairCnt ++;
                }

            }else if(">".equals(c)){
                if(!s2.isEmpty()){
                    s2.pop();
                    pairCnt ++;
                }
            }else if("}".equals(c)){
                if(!s3.isEmpty()){
                    s3.pop();
                    pairCnt ++;
                }
            }else if("]".equals(c)){
                if(!s4.isEmpty()){
                    s4.pop();
                    pairCnt ++;
                }
            }

        }

        answer = pairCnt;


        return answer;
    }
}
