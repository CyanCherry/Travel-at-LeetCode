package main

import (
	"reflect"
)

func sortColors(nums []int) {
	whiteStart, whiteEnd := 0, len(nums)-1
	for index := whiteStart; index <= whiteEnd; {
		if nums[index] == 0 {
			nums[index], nums[whiteStart] = nums[whiteStart], nums[index]
			whiteStart++
			index++
		} else if nums[index] == 2 {
			nums[index], nums[whiteEnd] = nums[whiteEnd], 2
			whiteEnd--
		} else if nums[index] == 1 {
			index++
		}
	}
}

func main() {
	// test case 0
	nums := []int{2, 0, 2, 1, 1, 0}
	sortColors(nums)
	println(reflect.DeepEqual(
		[]int{0, 0, 1, 1, 2, 2},
		nums,
	))

	// test case 1
	nums = []int{1, 2, 0}
	sortColors(nums)
	println(reflect.DeepEqual(
		[]int{0, 1, 2},
		nums,
	))

	// test case 2
	nums = []int{0}
	sortColors(nums)
	println(reflect.DeepEqual(
		[]int{0},
		nums,
	))

	// test case 3
	nums = []int{0, 1}
	sortColors(nums)
	println(reflect.DeepEqual(
		[]int{0, 1},
		nums,
	))
}
