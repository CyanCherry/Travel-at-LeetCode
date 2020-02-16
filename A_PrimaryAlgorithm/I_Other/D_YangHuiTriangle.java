package I_Other;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class D_YangHuiTriangle {
    static class Solution {
        static List<List<Integer>> generate(int numRows) {
            System.out.println("numRows = " + numRows);
            Integer[][] result = new Integer[numRows][];
            for (int i = 0; i < numRows; i++) {
                Integer[] row = new Integer[i + 1];
                row[0] = row[i] = 1;
                for (int index = 1; index < i; index++)
                    row[index] = result[i - 1][index - 1] + result[i - 1][index];
                result[i] = row;
            }
            List<List<Integer>> resultList = new LinkedList<>();
            for (Integer[] row : result)
                resultList.add(Arrays.asList(row));
            return resultList;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.generate(0));
        System.out.println(Solution.generate(1));
        System.out.println(Solution.generate(5));
    }
}
