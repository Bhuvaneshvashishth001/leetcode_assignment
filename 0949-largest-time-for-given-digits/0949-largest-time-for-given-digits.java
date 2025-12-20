class Solution {
    public static void valid(int arr[],int idx,ArrayList<String> list,String str){
        if(idx==arr.length){
            list.add(str+" ");
            return;
        }
        for(int i=idx;i<arr.length;i++){
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
            valid(arr,idx+1,list,str+arr[idx]);
            temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }
    public String largestTimeFromDigits(int[] arr) {
        int n = arr.length;
        if(n!=4){
            return "";
        }
        ArrayList<String> list = new ArrayList<>();
        valid(arr,0,list,"");
        String ans = "";
        for(String str:list){
            String hour = str.substring(0, 2);
            String min  = str.substring(2, 4);
            int h = Integer.parseInt(hour);
            int m = Integer.parseInt(min);
            if(h<24 && m<60){
                String time = hour+":" +min;
                if(ans.equals("") || time.compareTo(ans)>0) {
                    ans=time;
                }
            }
        }
        return ans;
    }
}