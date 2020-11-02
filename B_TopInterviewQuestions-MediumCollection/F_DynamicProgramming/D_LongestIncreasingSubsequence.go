package main

import "fmt"

func lengthOfLIS(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	sequence := make([]int, 0, len(nums)/3)
	sequence = append(sequence, nums[0])

	for i := 1; i < len(nums); i++ {
		num := nums[i]
		last := sequence[len(sequence)-1]
		if num > last {
			sequence = append(sequence, num)
		} else {
			start, end := 0, len(sequence)
			for start < end {
				middle := (start + end) / 2
				if num > sequence[middle] {
					start = middle + 1
				} else {
					end = middle
				}
			}
			if num < sequence[start] {
				sequence[start] = num
			}
		}
	}
	return len(sequence)
}

func main() {
	fmt.Println(4 == lengthOfLIS([]int{10, 9, 2, 5, 3, 7, 101, 18}))
	fmt.Println(6 == lengthOfLIS([]int{1, 3, 6, 7, 9, 4, 10, 5, 6}))
	fmt.Println(6 == lengthOfLIS([]int{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12}))
	fmt.Println(3 == lengthOfLIS([]int{10, 9, 2, 5, 3, 4}))
}
