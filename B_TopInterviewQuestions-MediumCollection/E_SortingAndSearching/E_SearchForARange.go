package main

import (
	"reflect"
)

func searchRange(nums []int, target int) []int {
	NotFound := []int{-1, -1}
	if len(nums) == 0 || nums[0] > target || nums[len(nums)-1] < target {
		return NotFound
	}
	var search func(start, end int) []int
	search = func(start, end int) []int {
		if start == end {
			return NotFound
		}
		middle := (start + end) / 2
		if nums[middle] < target {
			return search(middle+1, end)
		} else if nums[middle] > target {
			return search(start, middle)
		} else {
			i, j := middle, middle
			for i >= 1 && nums[i-1] == target {
				i--
			}
			for j+1 < len(nums) && nums[j+1] == target {
				j++
			}
			return []int{i, j}
		}
	}
	return search(0, len(nums))
}

func main() {
	println(reflect.DeepEqual([]int{3, 4}, searchRange([]int{5, 7, 7, 8, 8, 10}, 8)))
	println(reflect.DeepEqual([]int{-1, -1}, searchRange([]int{5, 7, 7, 8, 8, 10}, 6)))
	println(reflect.DeepEqual([]int{-1, -1}, searchRange([]int{}, 1)))
	println(reflect.DeepEqual([]int{0, 0}, searchRange([]int{1}, 1)))
	println(reflect.DeepEqual([]int{0, 1}, searchRange([]int{1, 1}, 1)))
}
