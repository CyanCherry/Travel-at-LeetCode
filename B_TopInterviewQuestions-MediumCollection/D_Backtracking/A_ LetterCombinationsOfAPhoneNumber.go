package main

import "reflect"

var dictionary = map[rune][]string{
	'2': {"a", "b", "c"},
	'3': {"d", "e", "f"},
	'4': {"g", "h", "i"},
	'5': {"j", "k", "l"},
	'6': {"m", "n", "o"},
	'7': {"p", "q", "r", "s"},
	'8': {"t", "u", "v"},
	'9': {"w", "x", "y", "z"},
}

func letterCombinations(digits string) []string {
	if len(digits) == 0 {
		return []string{}
	}
	results := []string{""}
	for _, char := range digits {
		letters := dictionary[char]
		newResults := make([]string, 0, len(results)*len(letters))
		for _, result := range results {
			for _, letter := range letters {
				newResults = append(newResults, result+letter)
			}
		}
		results = newResults
	}
	return results
}

func main() {
	println(reflect.DeepEqual(
		[]string{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"},
		letterCombinations("23"),
	))
}
