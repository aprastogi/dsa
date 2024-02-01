package sliding_window.variable;

/*
https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
Given a string str, find the length of the longest substring without repeating characters.
 */

import java.util.HashMap;
import java.util.Map;

public class LargestSubstringWithNoRepeatingCharacter {

    public static void main(String[] args) {
        String str = "ABCDEFGABEF";
        System.out.println(largestSubstringWithNoRepeatingCharacter(str));
    }

    private static int largestSubstringWithNoRepeatingCharacter(String str) {
        int i = 0, j = 0;
        int n = str.length();
        Map<Character,Integer> map = new HashMap<>();
        int largestSubstring = Integer.MIN_VALUE;
        while(j < n){
            map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
            // this is the main logic for this problem to identify when we will say map is having only 1 occurrence of every character
            // So if map.size() == j - i + 1 then map has only 1 occurrence of every character
            int k = j - i + 1;
            // whenever map size is equal to k that means map is having k unique characters
            if(map.size() == k){
                largestSubstring = Math.max(largestSubstring, j - i + 1);
            }
            // till map size exceeds k slide the window from left
            else if(map.size() > k){
                while(i < j && map.size() > k){
                    if(map.containsKey(str.charAt(i))){
                        map.put(str.charAt(i), map.get(str.charAt(i)) - 1);
                        if(map.get(str.charAt(i)) == 0)
                            map.remove(str.charAt(i));
                    }
                    i++;
                }
            }
            j++;
        }
        return largestSubstring;
    }
}
