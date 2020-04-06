package study.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {

    public static void main(String[] args) {

//        String given = "asdlifjasdljfailjsdflajsdifljasdliffvhawuevhdjvh";
        String given = "abccccdd";
        int[] checker = new int[72];
        int maxLen = 0;
        int len = given.length();
        System.out.println(checker );
        for(int i = 0 ; i < len ; i ++ ) {
            checker[given.charAt(i) - 'A']++;
        }
        boolean only1 = true;
        for(int k = 0; k < 72 ; k ++){
            if(checker[k]%2==0) {
                maxLen += checker[k];
            }else{
                maxLen += checker[k]-1;
                if(only1) {
                    maxLen ++;
                    only1 = false;
                }
            }
        }
        System.out.println(maxLen);
    }


}
