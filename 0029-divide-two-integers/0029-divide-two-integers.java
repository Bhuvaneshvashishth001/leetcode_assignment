class Solution {
    public int divide(int x, int y) {

        if (y == 0)
            throw new ArithmeticException("Divide by zero");

        if (x == 0)
            return 0;

        // Overflow case
        if (x == Integer.MIN_VALUE && y == -1)
            return Integer.MAX_VALUE;

        if (y == 1)
            return x;

        if (y == -1)
            return -x;

        boolean negative = false;

        if ((x < 0 && y > 0) || (x > 0 && y < 0))
            negative = true;

        // Use long to avoid overflow
        long dividend = Math.abs((long) x);
        long divisor = Math.abs((long) y);

        long count = 0;

        for (long i = divisor; i <= dividend; i += divisor) {
            count++;
        }

        if (negative)
            count = -count;

        return (int) count;
    }
}