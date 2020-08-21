class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int lo = 1;
      int   hi = 1000000000;
       while (lo < hi) {
            int mi = (lo + hi + 1) / 2; 
            if (check(position, mi, m)) {
                lo = mi;
            } else {
                hi = mi - 1;
            }
        }

        return lo;
    }

    private boolean check(int[] position, int minimumDistance, int m) {
        // Always place first object at position[0]
        int lastBallPosition = position[0];
        int ballsLeftToBePlaced = m - 1;
        for (int i = 1; i < position.length && ballsLeftToBePlaced != 0; ) {
            if (position[i] - lastBallPosition < minimumDistance) {
                // Try to place the next ball, since this ball isn't minimumDistance away from lastBall
                i++;
            } else {
                // Place the ball only if this ball is farther than the previous ball by minimumDistance
                lastBallPosition = position[i];
                ballsLeftToBePlaced--;
            }
        }
        return ballsLeftToBePlaced == 0;
    }
}
        
    
