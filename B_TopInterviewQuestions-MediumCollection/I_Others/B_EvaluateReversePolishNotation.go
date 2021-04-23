package main

import (
	"fmt"
	"strconv"
)

func evalRPN(tokens []string) int {
	stack := make([]int, 0, len(tokens)/4)
	for _, token := range tokens {
		if token == "+" {
			sl := len(stack)
			if sl < 2 {
				panic("no operated number")
			}
			left, right := stack[sl-2], stack[sl-1]
			stack = stack[:sl-2]
			stack = append(stack, left+right)
		} else if token == "-" {
			sl := len(stack)
			if sl < 2 {
				panic("no operated number")
			}
			left, right := stack[sl-2], stack[sl-1]
			stack = stack[:sl-2]
			stack = append(stack, left-right)
		} else if token == "*" {
			sl := len(stack)
			if sl < 2 {
				panic("no operated number")
			}
			left, right := stack[sl-2], stack[sl-1]
			stack = stack[:sl-2]
			stack = append(stack, left*right)
		} else if token == "/" {
			sl := len(stack)
			if sl < 2 {
				panic("no operated number")
			}
			left, right := stack[sl-2], stack[sl-1]
			stack = stack[:sl-2]
			stack = append(stack, left/right)
		} else {
			num, err := strconv.Atoi(token)
			if err != nil {
				panic("invalid number token")
			}
			stack = append(stack, int(num))
		}
	}
	if len(stack) != 1 {
		fmt.Println(stack)
		panic("no result")
	} else {
		return stack[0]
	}
}

func main() {
	fmt.Println(9 == evalRPN([]string{"2", "1", "+", "3", "*"}))
	fmt.Println(6 == evalRPN([]string{"4", "13", "5", "/", "+"}))
	fmt.Println(22 == evalRPN([]string{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}))
}
