package main

import "fmt"

func titleToNumber(s string) int {
	result := 0
	weight := 1
	for i := len(s) - 1; i > -1; i-- {
		result += int(s[i]-64) * weight
		weight *= 26
	}
	return result
}

func main() {
	fmt.Println(1 == titleToNumber("A"))
	fmt.Println(28 == titleToNumber("AB"))
	fmt.Println(701 == titleToNumber("ZY"))
}
