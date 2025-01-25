package problems.arrays;

public class MajorityElement {
    static int findSolution(int[] arr) {
        // Moore's Voting Algorithm
        int candidate = -1;
        int count = 0;
        for (int i : arr)
            if (count == 0) {
                candidate = i;
                count++;
            } else if (candidate == i) count++;
            else count--;

        count = 0;
        for (int i : arr) if (i == candidate) count++;

        if (count > arr.length / 2) return candidate;
        else return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 1, 3, 5, 1};
        System.out.println(findSolution(arr1));
        int[] arr2 = {3, 1, 3, 3, 2};
        System.out.println(findSolution(arr2));
        int[] arr3 = {2, 13};
        System.out.println(findSolution(arr3));
        int[] arr4 = {7};
        System.out.println(findSolution(arr4));
    }
}
