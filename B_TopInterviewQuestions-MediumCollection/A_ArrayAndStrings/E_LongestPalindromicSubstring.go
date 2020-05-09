package main

func longestPalindrome(s string) string {
    maxLen := 0
    var result string
    expand := func(start, end int) {
        for start > -1 && end < len(s) && s[start] == s[end] {
            start--
            end++
        }
        currentLen := end - start - 1
        if currentLen > maxLen {
            maxLen = currentLen
            result = s[start+1 : end]
        }
    }
    for centerIndex := range s {
        expand(centerIndex-1, centerIndex+1)
        expand(centerIndex, centerIndex+1)
    }
    return result
}

func main() {
    println(longestPalindrome("babad") == "bab")
    println(longestPalindrome("cbbd") == "bb")
    println(longestPalindrome("a") == "a")
    println(longestPalindrome("aaaaaaaaabc") == "aaaaaaaaa")
}
