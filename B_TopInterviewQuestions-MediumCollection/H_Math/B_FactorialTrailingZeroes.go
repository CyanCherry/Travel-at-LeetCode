package main

import (
	"fmt"
)

func trailingZeroes(n int) int {
	result := 0
	for n > 4 {
		n /= 5
		result += n
	}
	return result
}

func main() {
	fmt.Println(0 == trailingZeroes(3))
	fmt.Println(1 == trailingZeroes(5))
	fmt.Println(7 == trailingZeroes(30))
}
