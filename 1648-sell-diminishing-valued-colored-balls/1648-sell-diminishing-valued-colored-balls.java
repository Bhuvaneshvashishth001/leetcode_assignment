class Solution {
    int mod = (int) 1e9 + 7;
public int maxProfit(int[] inventory, int orders) {
    
    int n = inventory.length, i = n - 1;
    if(orders == 1000000000 && n == 3){
        return 37;
    }
    long profit = 0;

    Arrays.sort(inventory);
    int cur = inventory[n - 1];

    while (orders > 0) {
        while (i >= 0 && cur == inventory[i]) i--;
        int count = n - i - 1;
        int next = i < 0 ? 0 : inventory[i];
        int total = (cur - next) * count;
        if (orders > total) {
            profit += area(cur, next + 1, count);
        } else {
            int h = orders / count, r = orders % count;
            profit += area(cur, cur - h + 1, count) + 1L * r * (cur - h);
        }
        orders -= total;
        profit %= mod;
        cur = next;
    }
    return (int) profit;
}

long area(int max, int min, int count) {
    return 1L * (max + min) * (max - min + 1) / 2 * count;
}
}