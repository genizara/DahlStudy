package study.leetcode;

public class ThriedMax {
    public static void main(String[] args) {
        int[] nums = {1,-2147483648,2};
        System.out.println(new ThriedMax().thirdMax(nums));
    }

    public int thirdMax(int[] nums) {

        long[] result = {nums[0], Long.MIN_VALUE, Long.MIN_VALUE};
        int cnt = 1;

        for(int k = 1 ; k < nums.length; k++){
            if(result[0]<nums[k]){
                result[2] = result[1];
                result[1] = result[0];
                result[0] = nums[k];
                cnt ++;
            }else if(result[0] == nums[k]){

            }else {
                if( result[1] == Integer.MIN_VALUE || result[1] < nums[k]) {
                    result[2] = result[1];
                    result[1] = nums[k];
                    cnt ++;
                }else if(result[1] == nums[k]){

                }else {
                    if( result[2] <= nums[k]) {
                        result[2] = nums[k];
                        cnt ++;
                    }
                }
            }

        }
        return cnt>2?(int)result[2]:(int)result[0];

    }
}
