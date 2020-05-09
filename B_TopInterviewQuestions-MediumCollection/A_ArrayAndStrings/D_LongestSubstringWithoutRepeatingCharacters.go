package main

func lengthOfLongestSubstring(s string) int {
    charCount := [256]int{}
    startIndex := 0
    maxLen := 0
    for endIndex := 0; endIndex < len(s); endIndex++ {
        charCount[s[endIndex]]++
        for charCount[s[endIndex]] > 1 {
            charCount[s[startIndex]]--
            startIndex++
        }
        currentLen := endIndex - startIndex + 1
        if currentLen > maxLen {
            maxLen = currentLen
        }
    }
    return maxLen
}

func main() {
    println(3 == lengthOfLongestSubstring("abcabcbb"))
    println(1 == lengthOfLongestSubstring("bbbbb"))
    println(3 == lengthOfLongestSubstring("pwwkew"))
    println(2 == lengthOfLongestSubstring("aab"))
    println(3 == lengthOfLongestSubstring("dvdf"))
    println(0 == lengthOfLongestSubstring(""))
}
