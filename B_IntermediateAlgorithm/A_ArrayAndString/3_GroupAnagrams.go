package main

import (
	"reflect"
)

func countChar(str string) [26]int {
	var result [26]int
	for _, char := range str {
		result[char-'a']++
	}
	return result
}

func toResult(strGroupMap map[[26]int][]string) [][]string {
	var result [][]string
	for _, stringGroup := range strGroupMap {
		result = append(result, stringGroup)
	}
	return result
}

func groupAnagrams(strings []string) [][]string {
	strGroupMap := map[[26]int][]string{}
	for _, str := range strings {
		charCount := countChar(str)
		strGroupMap[charCount] = append(strGroupMap[charCount], str)
	}
	return toResult(strGroupMap)
}

func main() {
	println(reflect.DeepEqual(
		groupAnagrams([]string{"eat", "tea", "tan", "ate", "nat", "bat"}),
		[][]string{
			{"eat", "tea", "ate"},
			{"tan", "nat"},
			{"bat"},
		},
	))
}
