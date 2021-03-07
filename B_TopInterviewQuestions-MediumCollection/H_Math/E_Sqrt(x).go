package main

import (
	"fmt"
)

func mySqrt(x int) int {
	r := 0.0
	if x <= 0 {
		return int(r)
	}
	xf := float64(x)
	x0 := xf
	for {
		r = (x0 + xf/x0) / 2.0
		if x0-r < 1 {
			return int(r)
		}
		x0 = r
	}
}

func main() {
	fmt.Println(2 == mySqrt(4))
	fmt.Println(2 == mySqrt(8))
}
