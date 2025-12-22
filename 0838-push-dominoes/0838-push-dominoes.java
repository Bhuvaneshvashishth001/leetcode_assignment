class Solution{
    public String pushDominoes(String dominoes){
        int n=dominoes.length();
        char[] arr=new char[n+2];
        arr[0]='L';
        arr[n+1]='R';
        for(int i=0;i<n;i++){
            arr[i+1]=dominoes.charAt(i);
        }
        int i=0;
        for(int j=1; j<arr.length;j++){
            if(arr[j]=='.'){
                continue;
            }
            int mid=j-i-1;
            if(arr[i]==arr[j]){
                for(int k=1; k<=mid ;k++){
                    arr[i+k]=arr[i];
                }
            }
            else if(arr[i]=='R' && arr[j]=='L'){
                for(int k=1;k<=mid/2;k++){
                    arr[i+k] = 'R';
                    arr[j-k] = 'L';
                }
            }
            i=j;
        }
        return new String(arr,1,n);
    }
}
