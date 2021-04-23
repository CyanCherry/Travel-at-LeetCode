package main

import "fmt"

func getSum(a int, b int) int {
	sum := a ^ b
	overflow := (a & b) << 1
	for overflow != 0 {
		sum, overflow = sum^overflow, (overflow&sum)<<1
	}
	return sum
}

func main() {
	fmt.Println(4 == getSum(1, 3))
	fmt.Println(1 == getSum(-2, 3))
}
