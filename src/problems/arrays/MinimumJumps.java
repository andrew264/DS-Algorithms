package problems.arrays;

public class MinimumJumps {
    public static int findSolution(int[] arr) {
        int nJumps = 0;
        if (arr[0] == 0) return -1;
        int curr = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, i + arr[i]);
            if (max >= arr.length - 1) {
                return nJumps + 1;
            }
            if (i == curr) {
                if (i == max) {
                    return -1;
                } else {
                    nJumps++;
                    curr = max;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findSolution(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));
        System.out.println(findSolution(new int[]{1, 4, 3, 2, 6, 7}));
        System.out.println(findSolution(new int[]{0, 10, 20}));
    }
}
