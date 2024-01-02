public class TwoCrystalBalls {
    // we have two balls to drop (。_。)
    // we need to find the exact breaking point before we run out of balls to break
    // Complexity: O(sqrt(N))

    static int breakPoint(boolean[] breaks) {
        int jumpAmt = (int) Math.floor(Math.sqrt(breaks.length));  // find the jump amount with is sqrt(N)
        // Math.floor because sqrt(3) is funny so round off to the lowest

        int i = jumpAmt;  // we start from the jump amount
        for (; i < breaks.length; i += jumpAmt) if (breaks[i]) break;  // we find where the first ball breaks

        i -= jumpAmt;  // we go back to a previously known good point

        for (int j = 0; j <= jumpAmt && i < breaks.length; j++, i++)  // we go through the array without jumping
            if (breaks[i]) return i;  // the point where the second ball breaks gives us the breaking point
        // i.e. linear search

        return -1;  // balls of steel maybe (‾◡◝)
    }


    public static void main(String[] args) {
        boolean[] anArray = {false, false, false, false, false, false, true, true, true, true, true, true};

        int brkPoint = breakPoint(anArray);
        System.out.println("The balls break at index " + brkPoint);
    }
}
