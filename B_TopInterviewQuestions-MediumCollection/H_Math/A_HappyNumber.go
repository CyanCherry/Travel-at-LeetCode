package main

import "fmt"

func isHappy(n int) bool {
	sum := 0
	for true {
		for n > 0 {
			one := n % 10
			sum += one * one
			n /= 10
		}
		if sum == 1 || sum == 7 {
			return true
		}
		if sum < 10 {
			return false
		}
		n = sum
		sum = 0
	}
	return false
}

func main() {
	fmt.Println(true == isHappy(19))
	fmt.Println(false == isHappy(20))
}
