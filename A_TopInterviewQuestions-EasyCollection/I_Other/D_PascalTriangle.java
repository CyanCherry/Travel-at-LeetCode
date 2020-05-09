package I_Other;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class D_PascalTriangle {
    static List<List<Integer>> generate(int numRows) {
        Integer[] row;
        Integer[] lastRow = new Integer[]{};
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            row = new Integer[i + 1];
            row[0] = row[i] = 1;
            for (int index = 1; index < i; index++) {
                row[index] = lastRow[index - 1] + lastRow[index];
            }
            lastRow = row;
            result.add(Arrays.asList(row));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(0).equals(
            List.of()
        ));
        System.out.println(generate(1).equals(
            List.of(List.of(1))
        ));
        System.out.println(generate(5).equals(
            List.of(
                List.of(1),
                List.of(1, 1),
                List.of(1, 2, 1),
                List.of(1, 3, 3, 1),
                List.of(1, 4, 6, 4, 1)
            )
        ));
    }
}
