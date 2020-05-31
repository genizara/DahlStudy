package study.programmers.greedy;

import java.util.Collections;
import java.util.PriorityQueue;

//큰 수 만들기
//        문제 설명
//        어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
//
//        예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
//
//        문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
//        number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
//
//        제한 조건
//        number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
//        k는 1 이상 number의 자릿수 미만인 자연수입니다.
//        입출력 예
//        number	k	return
//        1924	2	94
//        1231234	3	3234
//        4177252841	4	775841
//        출처
public class BuildBigNum {
    public String solution(String number, int k) {

        int length = number.length();
        StringBuffer returnVal = new StringBuffer();

        getNums( number, returnVal, 0, length - k, length);

        return returnVal.toString();
    }
    private void getNums(String target, StringBuffer returnVal, int start, int need, int length){

        if(length - start <= need ){
            returnVal.append(target.substring(start));
            return;
        }else if(need == 0){
            return;
        }
        int maxIndex = start;
        char max = target.charAt(start);
        for(int i = start ; i <= length - need ; i ++) {
            char tmp = target.charAt(i);
            if(tmp=='9'){
                max = tmp;
                maxIndex = i;
                break;
            }
            if(max < tmp){
                max = tmp;
                maxIndex = i;
            }
        }
        returnVal.append(max);
        getNums( target, returnVal, maxIndex+1, need-1, length);
    }

    public static void main(String[] args) {
//        String number = "4177252841";
        String number = "7777777";
        int k = 2;
        System.out.println(new BuildBigNum().solution(number, k));


    }
}
