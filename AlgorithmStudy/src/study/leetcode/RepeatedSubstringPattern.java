package study.leetcode;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();

        boolean test = true;
        for(int i = 1 ; i <= length/2 ; i ++){


            test = true;
            if(length%i!=0) {
                test = false;
                continue;
            }

            String patten = s.substring(0, i);

            int forLoop = length/i;
            int cnt = 0;
            while(cnt < forLoop){
                String compare = s.substring(cnt*i, (cnt+1)*i);
                if(!compare.equals(patten)) {
                    test = false;
                    break;
                }
                cnt ++;
            }
            if(test){
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abab"));
    }
}
