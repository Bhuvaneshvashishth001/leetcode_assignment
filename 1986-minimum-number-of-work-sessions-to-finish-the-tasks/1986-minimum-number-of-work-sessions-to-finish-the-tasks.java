class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        for (int i = 1; i < tasks.length; i++) {
            int[] remain = new int[i];
            for (int j = 0; j < i; j++) {
                remain[j] = sessionTime;
            }
            if (canWork(tasks, 0, remain)) {
                return i;
            }
        }
        return tasks.length;
    }
    public boolean canWork(int[] tasks, int curr, int[] remain) {
        if (curr == tasks.length) {
            return true;
        }
        for(int i = 0;i<remain.length;i++){
            if(i>curr){
                continue;
            }   
            if(remain[i] >= tasks[curr]){
                remain[i] -= tasks[curr];
                if(canWork(tasks, curr + 1, remain)) {
                    return true;
                }
                remain[i] += tasks[curr];
            }
        }
        return false;
    }
}