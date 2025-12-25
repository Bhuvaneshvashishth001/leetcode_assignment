class Solution {
    public int distMoney(int money1, int children) {
        int money = money1-children;
        if(money<0){
            return -1;
        }
        int count = money/7;
        int remains  = money%7;
        if(count == children && remains ==0){
            return count;
        }
        else if(count<children && remains!=3){
            return count;
        }
        else if(count<children && remains==3 && children-count == 1){
            return count-1;
        }
        else if(count<children && remains==3 && children-count != 1){
            return count;
        }
        else if(count>=children){
            return children -1;
        }
        return 0;
    }
}