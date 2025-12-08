class Solution {
    public int countTriples(int n) {
       int count = 0;
        for(int c=1;c<=n;c++){
            int a=1;
            int b= c-1;
            int c2 = c*c;
            while(a<b){
                int sum = a*a + b*b;
                if(sum ==c2){
                    count += 2;
                    a++;
                    b--;
                } 
                else if(sum<c2){
                    a++;
                }
                else{
                    b--;
                }
            }
        }
        return count; 
    }
}