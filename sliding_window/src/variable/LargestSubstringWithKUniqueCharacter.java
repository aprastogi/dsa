package variable;

import java.util.HashMap;
import java.util.Map;

/*
https://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
Given a string you need to print longest possible substring that has exactly M unique characters. If there is more than one substring of longest possible length,
then print any one of them.
 */
public class LargestSubstringWithKUniqueCharacter {

    public static void main(String[] args) {
        String str = "aabbcc";
        int k = 2;
        System.out.println(largestSubstringWithKUniqueCharacter(str, k));
    }

    private static int largestSubstringWithKUniqueCharacter(String str, int k) {
        int i = 0, j = 0;
        int n = str.length();
        Map<Character,Integer> map = new HashMap<>();
        int largestSubstring = Integer.MIN_VALUE;
        while(j < n){
            map.put(str.charAt(j), map.getOrDefault(str.charAt(j), 0) + 1);
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
