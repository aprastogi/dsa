package fixed;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrenceOfAnagrams {
    public static void main(String[] args) {
        String str = "aabaabaa";
        String pattern = "aaba";
        System.out.println(countOccurrenceOfAnagrams(str, pattern));
    }

    private static int countOccurrenceOfAnagrams(String str, String pattern) {
        int i= 0, j = 0;
        int n = str.length();
        int k = pattern.length();
        int answer = 0;
        Map<Character,Integer> patternMap = new HashMap<>();
        for(char ch : pattern.toCharArray())
            patternMap.put(ch, patternMap.getOrDefault(ch, 0 ) + 1);
        int count = patternMap.size();
        while(j < n){
            char currentChar = str.charAt(j);
            if(patternMap.containsKey(currentChar)){
                patternMap.put(currentChar, patternMap.get(currentChar) - 1);
            }
            if(patternMap.get(currentChar) == 0){
                count--;
            }
            int currentWindow = j - i + 1;
            if(currentWindow < k){
                j++;
            }
            else if(currentWindow == k){
                // If count is 0 then we found the anagram
                if(count == 0){
                    answer++;
                }
                // If map contains ith pointer value then increment its value if map
                if(patternMap.containsKey(str.charAt(i))){
                    patternMap.put(str.charAt(i), patternMap.get(str.charAt(i)) + 1);
                    // if value of ith pointer key is 1 that means we included one extra char in map whose frequency is not 0
                    if(patternMap.get(str.charAt(i)) == 1)
                        count++;
                }
                // slide the window
                i++;
                j++;
            }
        }
        return answer;
    }
}
