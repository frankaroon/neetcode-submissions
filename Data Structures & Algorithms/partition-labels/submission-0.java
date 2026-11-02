class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Set<Character> letters = new HashSet<>();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c-'a']++;
        }

        int count = 0;
        for (char c : s.toCharArray()) {
            letters.add(c);
            count++;
            if (--freq[c-'a'] == 0) {
                letters.remove(c);
            }
            if (letters.size() == 0) {
                res.add(count);
                count = 0;
            }
        }
        return res;
    }
}


/*
we want the most amount of substrings that appear in no more than 1 substring

key -
we need to check if the characters in the current substring exist in the future

2 decisions: 
if they dont exist append the count into the result list
if they exist increment the count and decrement the freq arr

variables
Set - checks current characters in string
int[] - frequency array for the characters in s
List - result array

build freq array 
loop through characters
    include character into set if it doesnt exist
    increment count
    decrement current character freq
    if the character freq is 0 
        remove from set
    if the set is empty
        reset count to 0
return result array 

*/