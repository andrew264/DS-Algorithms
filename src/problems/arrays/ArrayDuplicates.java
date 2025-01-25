package problems.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayDuplicates {
    public static List<Integer> findSolution(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findSolution(new int[]{2, 3, 1, 2, 3}));
        System.out.println(findSolution(new int[]{0, 3, 1, 2}));
        System.out.println(findSolution(new int[]{2}));
    }
}
