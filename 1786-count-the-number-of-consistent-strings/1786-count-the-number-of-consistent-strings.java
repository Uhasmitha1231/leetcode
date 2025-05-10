class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count=0;
        for (String word : words) {
           boolean isConsistent=true;
           for (char c:word.toCharArray()) {
            if(!allowed.contains(String.valueOf(c))) {
                isConsistent = false;
                break;
            }
           }
           if (isConsistent) {
                count++;
            }
        }
        return count;
    }
}