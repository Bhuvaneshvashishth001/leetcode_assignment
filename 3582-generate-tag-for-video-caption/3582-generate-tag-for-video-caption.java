class Solution {
    public String generateTag(String caption) {
        String arr[] = caption.trim().split("\\s+");
        String ans = "";
        ans=ans+"#";
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length();j++){
                char ch = arr[i].charAt(j);
                if(i==0 && Character.isLowerCase(ch)){
                    if(ans.length()<100){
                        ans = ans+ch;
                    }
                }
                else if(i==0 && !Character.isLowerCase(ch)){
                    if(ans.length()<100){
                        ans = ans+(char)(ch+32);
                    }
                }
                else if(j==0 && !Character.isUpperCase(ch)){
                    if(ans.length()<100){
                        ans = ans+(char)(ch-32);
                    }
                }
                else if(j==0 && Character.isUpperCase(ch)){
                    if(ans.length()<100){
                        ans = ans+ch;
                    }
                }
                else{
                    if(ans.length()<100 && Character.isLowerCase(ch)){
                        ans = ans+ch;
                    }
                    else if(ans.length()<100){
                        ans = ans+(char)(ch+32);
                    }
                }
            }
        }
        return ans;
    }
}