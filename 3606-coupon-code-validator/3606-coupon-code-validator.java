class Solution {
    public List<String> validateCoupons(String[] code, String[] business, boolean[] isActive) {
        Set<String> set1 = new HashSet<>();
        Set<Character> set = new HashSet<>();
        for(char i='a';i<='z';i++){
            set.add(i);
        }
        for(char i='A';i<='Z';i++){
            set.add(i);
        }
        for(char i='0';i<='9';i++){
            set.add(i);
        }
        set.add('_');
        int n = business.length;
        set1.add("electronics");
        set1.add("grocery");
        set1.add("pharmacy");
        set1.add("restaurant");
        List<String> e = new ArrayList<>();
        List<String> g = new ArrayList<>();
        List<String> p = new ArrayList<>();
        List<String> r = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(isActive[i] == true && business[i] != null && set1.contains(business[i])){
                String str = code[i];
                boolean flag = true;
                if(str == null || str.equals("")){
                    flag = false;
                } else {
                    for(int j=0;j<str.length();j++){
                        if(!set.contains(str.charAt(j))){
                            flag = false;
                            break;
                        }
                    }
                }
                if(flag == true){
                    if(business[i].equals("electronics")){
                        e.add(str);
                    } else if(business[i].equals("grocery")){
                        g.add(str);
                    } else if(business[i].equals("pharmacy")){
                        p.add(str);
                    } else if(business[i].equals("restaurant")){
                        r.add(str);
                    }
                }
            }
        }
        Collections.sort(e);
        Collections.sort(g);
        Collections.sort(p);
        Collections.sort(r);
        List<String> list = new ArrayList<>();
        list.addAll(e);
        list.addAll(g);
        list.addAll(p);
        list.addAll(r);
        return list;
    }
}
