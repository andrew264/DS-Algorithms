package problems.mid;

import java.util.Arrays;

public class FindingOptimalToiletSpace {
    public static int maxDistance(int[] position, int m) {
        // position: the position of the toilets
        // m: the number of men
        // return: the maximum distance between each man to choose from `position` toilets
        Arrays.sort(position);

        int left = 1;
        int right = position[position.length - 1] - position[0];  // rightmost toilet - leftmost toilet

        while (left < right) {  // ah, shit; here we go again
            int mid = right - (right - left) / 2;
            if (check(position, mid) >= m)
                left=mid;
            else
                right=mid-1;
        }
        return left;
    }

    private static int check(int[] position, int mid){
        int count = 0;
        int prev = -mid;  // set the previous toilet to negative mid to make sure the first toilet is included
        for (int i : position) {  // for each toilet
            if (i - prev >= mid) {  // if the distance between the current toilet and the previous toilet is greater than or equal to mid
                count++;
                prev = i;  // set the previous toilet to the current toilet
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] position = {1, 2, 3, 4, 7};
        int m = 3;
        System.out.println(maxDistance(position, m));  // 3
        int[] position2 = {5, 4, 3, 2, 1, 1000000000};
        int m2 = 2;
        System.out.println(maxDistance(position2, m2));  // 999999999
    }
}
