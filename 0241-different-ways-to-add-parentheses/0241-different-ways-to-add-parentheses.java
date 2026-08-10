class Solution {
    public List<Integer> diffWaysToCompute(String s) {
        List<Integer> list1 = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*'){
                String left = s.substring(0,i);
                String right = s.substring(i+1);
                List<Integer> lefty = diffWaysToCompute(left);
                List<Integer> righty = diffWaysToCompute(right);
                for(int c1:lefty){
                    for(int c2:righty){
                        if(ch == '+'){
                            list1.add(c1+c2);
                        }
                        if(ch == '-'){
                            list1.add(c1-c2);
                        }
                        if(ch == '*'){
                            list1.add(c1*c2);
                        }
                    }
                }
            } 
        }
        if(list1.size() == 0){
            list1.add(Integer.parseInt(s));
        }
        return list1;
    }
}