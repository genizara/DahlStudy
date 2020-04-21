package study.leetcode;
//Given an integer, return its base 7 string representation.
//
//        Example 1:
//        Input: 100
//        Output: "202"
//        Example 2:
//        Input: -7
//        Output: "-10"
//        Note: The input will be in range of [-1e7, 1e7].
public class Base7 {
    public String convertToBase7(int num) {
            int index = 0;
            String returnVal = "";
            boolean isM = false;
            if(num<0) {
                isM = true;
                num = num*-1;
            }else if(num == 0) {
                return "0";
            }

            while(true){
                int moc = num/7;
                int namuji = num%7;

                returnVal = namuji + returnVal;
                if(moc<7){
                    if(moc!=0)
                        returnVal = moc + returnVal;
                    break;
                }
                num = moc;
            }
        return isM?"-"+returnVal:returnVal;
    }

    public static void main(String[] args) {
        System.out.println(new Base7().convertToBase7(-1));
    }
}
