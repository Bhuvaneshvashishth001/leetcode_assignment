class Solution {
    public int numTeams(int[] arr) {
        int n = arr.length;

        int greaterRight[] = new int[n];
        int smallerRight[] = new int[n];

        // count right side
        for (int i = n - 1; i >= 0; i--) {
            int gr = 0;
            int sr = 0;

            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) gr++;
                else if (arr[i] > arr[j]) sr++;
            }

            greaterRight[i] = gr;
            smallerRight[i] = sr;
        }

        int ans = 0;

        // count left side + form teams
        for (int j = 0; j < n; j++) {
            int smallerLeft = 0;
            int greaterLeft = 0;

            for (int i = 0; i < j; i++) {
                if (arr[i] < arr[j]) smallerLeft++;
                else if (arr[i] > arr[j]) greaterLeft++;
            }

            // increasing + decreasing
            ans += smallerLeft * greaterRight[j];
            ans += greaterLeft * smallerRight[j];
        }

        return ans;
    }
}
