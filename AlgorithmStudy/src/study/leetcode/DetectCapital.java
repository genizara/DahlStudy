package study.leetcode;

public class DetectCapital {
    public boolean detectCapitalUse(String word){

        int cnt = 0;
        int index = 0;
        int charAt = 0;
        for(char c : word.toCharArray()) {
            if((int)'A'<=(int)c && (int)'Z'>=(int)c){
                cnt ++;
                charAt = index;
            }
            index ++;
        }
        int length = word.length();
        if(length == cnt ) {
            return true;
        }else if(cnt ==1 && index ==0) {
            return true;
        }else if(cnt == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new DetectCapital().detectCapitalUse("ffffffffffF"));
    }
}
