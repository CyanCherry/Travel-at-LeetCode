package E_SortingAndSearching;

import java.util.Arrays;

public class A_Merge {
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m-- + n--;
        while (index > 0 && m > -1 && n > -1) {
            index--;
            if (nums1[m] > nums2[n]) {
                nums1[index] = nums1[m];
                m--;
            } else {
                nums1[index] = nums2[n];
                n--;
            }
        }
        if (n > -1) {
            while (n > -1) {
                index--;
                nums1[index] = nums2[n];
                n--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        merge(nums1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.equals(new int[]{1, 2, 2, 3, 5, 6}, nums1));

        int[] nums2 = new int[0];
        merge(nums2, 0, new int[0], 0);
        System.out.println(Arrays.equals(new int[0], nums2));
    }
}
