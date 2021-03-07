package main

import (
	"fmt"
	"math"
)

func abs(num int) int {
	if num < 0 {
		return -num
	}
	return num
}

func divide(dividend int, divisor int) int {
	if divisor == 0 {
		panic("divisor is 0")
	}
	if dividend == math.MinInt32 && divisor == -1 {
		return math.MaxInt32
	}
	isPositive := (dividend < 0) == (divisor < 0)
	divisor = abs(divisor)
	dividend = abs(dividend)

	bias := 0
	for {
		divisor <<= 1
		if dividend < divisor {
			divisor >>= 1
			break
		}
		bias++
	}
	result := 0
	for bias > -1 {
		if dividend >= divisor {
			result += 1 << bias
			dividend -= divisor
		}
		divisor >>= 1
		bias--
	}

	if !isPositive {
		return -result
	}
	return result
}

func main() {
	fmt.Println(3 == divide(10, 3))
	fmt.Println(-2 == divide(7, -3))
	fmt.Println(math.MinInt32+1 == divide(math.MaxInt32, -1))
	fmt.Println(math.MaxInt32 == divide(math.MinInt32, -1))
	fmt.Println(1 == divide(1, 1))
	fmt.Println(math.MinInt32 == divide(math.MinInt32, 1))
	fmt.Println(715827882 == divide(2147483647, 3))
}
