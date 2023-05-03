package main

import "fmt"

func isValid(s string) bool {
	stack := make([]byte, 0, len(s))
	for i := 0; i < len(s); i++ {
		stack = append(stack, s[i])
		l := len(stack)
		if l > 2 && stack[l-3] == 'a' && stack[l-2] == 'b' && stack[l-1] == 'c' {
			stack = stack[:len(stack)-3]
		}
	}
	return len(stack) == 0
}

func main() {
	fmt.Println(isValid("aabcbc") == true)
	fmt.Println(isValid("abcabcababcc") == true)
	fmt.Println(isValid("abccba") == false)
}
