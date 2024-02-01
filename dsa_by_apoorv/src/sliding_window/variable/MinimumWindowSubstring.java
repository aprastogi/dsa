package sliding_window.variable;

/*
https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
Given two strings, string, and pattern, the task is to find the smallest substring in string containing all characters of pattern.
 */

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        String pattern = "ork";
        System.out.println(minimumWindowSubstring(str, pattern));
    }

    private static String minimumWindowSubstring(String str, String pattern) {
        int i = 0, j = 0;
        int start = -1, end = -1;
        int n = str.length();
        int minWindow = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : pattern.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0 ) + 1);
        }
        // it is useful to check whether we have all character of pattern string
        int count = map.size();
        while (j < n){
            if(map.containsKey(str.charAt(j))){
                map.put(str.charAt(j), map.get(str.charAt(j)) - 1);
                if(map.get(str.charAt(j)) == 0)
                    count--;
            }
            if(count > 0){
                j++;
            }
            // till the count is 0, slide the window from left to shrink and calculate the best possible answer
            else if(count == 0){
                while(count == 0){
                    // calculate the answer
                    if(minWindow > j - i + 1){
                        minWindow = j - i + 1;
                        start = i;
                        end = j;
                    }
                    // shrink the window from left
                    if(map.containsKey(str.charAt(i))){
                        map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
                        if(map.get(str.charAt(i)) == 1)
                            count++;
                    }
                    i++;
                }
            }
        }
        return start == -1 ? "" : str.substring(start, end + 1);
    }
}
