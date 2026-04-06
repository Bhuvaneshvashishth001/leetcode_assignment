class Solution {
    public boolean judgeCircle(String moves) {
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i) == 'U'){
                up++;
            }
            if(moves.charAt(i) == 'D'){
                down++;
            }
            if(moves.charAt(i) == 'L'){
                left++;
            }
            if(moves.charAt(i) == 'R'){
                right++;
            }
        }
        if(Math.abs(up-down)+Math.abs(left-right) == 0){
            return true;
        }
        return false;
    }
}