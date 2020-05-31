package study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MayorInvite9237 {

    public StringBuffer solution(String[] nodeInfo, int howmanyTrees, StringBuffer sb){

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());


        for(int i = 0; i < howmanyTrees; i ++){

            pq.add(Integer.parseInt(nodeInfo[i]));

        }

        int dates = 0;
        int plantDue = 1;
        int maxJob = 0;
        while(!pq.isEmpty()){
            dates ++;
            int tmp = pq.poll();
            if(maxJob < tmp + dates){
                maxJob = tmp + dates;
            }
        }
        sb.append(maxJob+1);

        return sb;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int howmanyTrees = Integer.parseInt(br.readLine());


        String[] nodeInfo = br.readLine().trim().split(" ");
        StringBuffer sb= new StringBuffer();

        System.out.println(new MayorInvite9237().solution(nodeInfo,howmanyTrees, sb).toString());

    }
}
