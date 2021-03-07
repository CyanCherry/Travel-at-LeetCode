package main

import "fmt"

func myPow(x float64, n int) float64 {
	if n < 0 {
		return 1.0 / myPow(x, -n)
	}
	result := 1.0
	weight := x
	for n > 0 {
		if n&1 != 0 {
			result *= weight
		}
		weight = weight * weight
		n >>= 1
	}
	return result
}

func main() {
	fmt.Println(1024.00000 == myPow(2.00000, 10))
	fmt.Println(9.261000000000001 == myPow(2.10000, 3))
	fmt.Println(0.25000 == myPow(2.00000, -2))
}
