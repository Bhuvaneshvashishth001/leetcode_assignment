class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String,Integer> map = new HashMap<>();
        for(List<String>list: paths){
            map.put(list.get(1),map.getOrDefault(list.get(1),0)+1);
        }
        for(List<String>list: paths){
            if(map.containsKey(list.get(0))){
                map.remove(list.get(0));
            }
        }
        for(String city:map.keySet()){
            return city;
        }
        return "";
    }
}