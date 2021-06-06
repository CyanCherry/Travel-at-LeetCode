package main

import (
	"fmt"
)

func leastInterval(tasks []byte, n int) int {
	m := make([]int, 26, 26)
	maxCount := 0
	maxCountCount := 0
	for _, task := range tasks {
		i := task - 'A'
		m[i]++
		if m[i] == maxCount {
			maxCountCount++
		}
		if m[i] > maxCount {
			maxCount = m[i]
			maxCountCount = 1
		}
	}
	duration := (maxCount-1)*(n+1) + maxCountCount
	if duration > len(tasks) {
		return duration
	} else {
		return len(tasks)
	}
}

func main() {
	fmt.Println(8 == leastInterval([]byte{'A', 'A', 'A', 'B', 'B', 'B'}, 2))
	fmt.Println(6 == leastInterval([]byte{'A', 'A', 'A', 'B', 'B', 'B'}, 0))
	fmt.Println(16 == leastInterval([]byte{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2))
}
