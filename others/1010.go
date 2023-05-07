package main

import "fmt"

const unit = 60

func numPairsDivisibleBy60(time []int) int {
	result := 0
	m := make([]int, 60)
	for i := len(time) - 1; i >= 0; i-- {
		t := time[i] % unit
		result += m[(unit-t)%unit]
		m[t]++
	}
	return result
}

func main() {
	fmt.Println(3 == numPairsDivisibleBy60([]int{30, 20, 150, 100, 40}))
	fmt.Println(3 == numPairsDivisibleBy60([]int{60, 60, 60}))
}
