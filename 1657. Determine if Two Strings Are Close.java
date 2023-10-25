class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        
        // Create frequency maps for both strings
        Map<Character, Integer> freqMap1 = new HashMap<>();
        Map<Character, Integer> freqMap2 = new HashMap<>();
        
        for (char c : word1.toCharArray()) {
            freqMap1.put(c, freqMap1.getOrDefault(c, 0) + 1);
        }
        
        for (char c : word2.toCharArray()) {
            freqMap2.put(c, freqMap2.getOrDefault(c, 0) + 1);
        }
        
        // Check if the sets of characters are the same
        if (!freqMap1.keySet().equals(freqMap2.keySet())) {
            return false;
        }
        
        // Check if the frequencies of the characters are the same
        int n = word1.length();
        int[] freqArr1 = new int[n];
        int[] freqArr2 = new int[n];
        int i = 0;
        for (char c : freqMap1.keySet()) {
            freqArr1[i] = freqMap1.get(c);
            freqArr2[i] = freqMap2.get(c);
            i++;
        }
        
        Arrays.sort(freqArr1);
        Arrays.sort(freqArr2);
        
        for (i = 0; i < n; i++) {
            if (freqArr1[i] != freqArr2[i]) {
                return false;
            }
        }
        
        return true;
    }
}
