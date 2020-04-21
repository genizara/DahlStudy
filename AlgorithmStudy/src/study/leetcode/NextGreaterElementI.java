package study.leetcode;

import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int leng = nums1.length;
        int[] result = new int[leng];
        int leng2 = nums2.length;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < leng2; i ++) {
            map.put(nums2[i], i);
        }

        for(int i = 0; i < leng ; i ++ ) {
            int target = nums1[i];
            int resultInt = -1;
            boolean jobStart = false;

            for(int j = map.get(target) ; j < leng2; j ++ ) {

                if(nums2[j]>target) {
                    resultInt = nums2[j];
                    break;
                }

            }
            result[i] = resultInt;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,1,2};
        int[] b = new int[]{1,3,4,2};
        int[] result = new NextGreaterElementI().nextGreaterElement(a, b);
        for(int k : result){
            System.out.print(k);

        }
    }
}
