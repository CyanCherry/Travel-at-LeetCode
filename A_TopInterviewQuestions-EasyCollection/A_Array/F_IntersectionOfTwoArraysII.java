package A_Array;

import java.util.ArrayList;
import java.util.Arrays;

public class F_IntersectionOfTwoArraysII {
    static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int nums1Index = 0;
        int nums2Index = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (nums1Index < nums1.length && nums2Index < nums2.length) {
            if (nums1[nums1Index] == nums2[nums2Index]) {
                result.add(nums1[nums1Index]);
                nums1Index++;
                nums2Index++;
            } else if (nums1[nums1Index] < nums2[nums2Index]) {
                nums1Index++;
            } else if (nums1[nums1Index] > nums2[nums2Index]) {
                nums2Index++;
            }
        }
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(
            new int[]{2, 2},
            intersect(new int[]{1, 2, 2, 1}, new int[]{2})
        ));
        System.out.println(Arrays.equals(
            new int[]{4, 9},
            intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})
        ));
    }
}
