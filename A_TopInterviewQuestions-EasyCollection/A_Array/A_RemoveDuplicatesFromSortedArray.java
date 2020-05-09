package A_Array;

public class A_RemoveDuplicatesFromSortedArray {
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int length = 1;
        int currentNumber = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != currentNumber) {
                currentNumber = nums[i];
                length++;
                nums[length - 1] = currentNumber;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(2 == removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(5 == removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
