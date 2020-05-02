package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
//외계인의 기타 연주 출처다국어분류
//        시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
//        1 초	256 MB	3531	1454	1153	40.584%
//        문제
//        상근이의 상상의 친구 외계인은 손가락을 수십억개 가지고 있다. 어느 날 외계인은 기타가 치고 싶었고,
//        인터넷에서 간단한 멜로디를 검색했다. 이제 이 기타를 치려고 한다.
//
//        보통 기타는 1번 줄부터 6번 줄까지 총 6개의 줄이 있고, 각 줄은 P개의 프렛으로 나누어져 있다.
//        프렛의 번호도 1번부터 P번까지 나누어져 있다.
//
//        멜로디는 음의 연속이고, 각 음은 줄에서 해당하는 프렛을 누르고 줄을 튕기면 연주할 수 있다. 예를 들면,
//        4번 줄의 8번 프렛을 누르고 튕길 수 있다. 만약, 어떤 줄의 프렛을 여러 개 누르고 있다면, 가장 높은 프렛의 음이 발생한다.
//
//        예를 들어, 3번 줄의 5번 프렛을 이미 누르고 있다고 하자. 이때, 7번 프렛을 누른 음을 연주하려면,
//        5번 프렛을 누르는 손을 떼지 않고 다른 손가락으로 7번 프렛을 누르고 줄을 튕기면 된다. 여기서 2번 프렛의 음을 연주하려고 한다면,
//        5번과 7번을 누르던 손가락을 뗀 다음에 2번 프렛을 누르고 연주해야 한다.
//
//        이렇게 손가락으로 프렛을 한 번 누르거나 떼는 것을 손가락을 한 번 움직였다고 한다. 어떤 멜로디가 주어졌을 때,
//        손가락의 가장 적게 움직이는 회수를 구하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 멜로디에 포함되어 있는 음의 수 N과 한 줄에 있는 프렛의 수 P가 주어진다. (N ≤ 500,000, 2 ≤ P ≤ 300,000)
//
//        다음 N개 줄에는 멜로디의 한 음을 나타내는 두 정수가 주어진다. 첫 번째 정수는 줄의 번호이고 두 번째 정수는
//        그 줄에서 눌러야 하는 프렛의 번호이다. 입력으로 주어진 음의 순서대로 기타를 연주해야 한다.
//
//        출력
//        첫째 줄에 멜로디를 연주하는데 필요한 최소 손가락 움직임을 출력한다.
//
//        예제 입력 1
//        7 15
//        1 5
//        2 3
//        2 5
//        2 7
//        2 4
//        1 5
//        1 3
//        예제 출력 1
//        9
//        출처
public class AlienGuitar {

    public static int lines = 6;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] meta = br.readLine().split(" ");
        int howManyMelody = Integer.parseInt(meta[0]);
        List<int[]> melodies= new ArrayList<>();
        for(int i = 0 ; i < howManyMelody ; i ++) {
            int[] melody = new int[2];
            String[] param = br.readLine().trim().split(" ");
            melody[0] = Integer.parseInt(param[0]);
            melody[1] = Integer.parseInt(param[1]);
            melodies.add(melody);
        }

        System.out.println(new AlienGuitar().solution(melodies));
    }

    public int solution(List<int[]> melodies){
        Stack<Integer>[] play = new Stack[7]; // map > 배열. 50ms빨라질 뿐.. 스트링은 6개이나 index특성상 걍 1개 더줌.
        int fingerCnt = 0;

        for(int[] melody : melodies){
            int nextString = melody[0];
            int nextPrat = melody[1];
            if(play[nextString]==null){
                Stack<Integer> stack = new Stack<>();
                stack.push(nextPrat);
                play[nextString] = stack;
                fingerCnt ++;
            }else {
                Stack<Integer> stack = play[nextString];
                int onTop = 0;
                while(true){
                    onTop = stack.isEmpty()?0:stack.peek();
                    if( onTop < nextPrat ){
                        stack.push(nextPrat);
                        fingerCnt ++;
                        break;
                    }else if( onTop > nextPrat ) {
                        stack.pop();
                        fingerCnt ++;
                    }else{
                        break;
                    }
                }


            }


        }

        return fingerCnt;
    }

}
