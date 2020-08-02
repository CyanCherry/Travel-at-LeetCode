package main

import (
	"reflect"
	"sort"
)

func threeSum(nums []int) [][]int {
	var results [][]int
	sort.Ints(nums)
	for index := 0; index < len(nums)-2; index++ {
		if index != 0 && nums[index] == nums[index-1] {
			continue
		}
		target := -nums[index]
		secondIndex, thirdIndex := index+1, len(nums)-1
		for secondIndex < thirdIndex {
			if secondIndex != index+1 && nums[secondIndex] == nums[secondIndex-1] {
				secondIndex++
				continue
			}
			if thirdIndex != len(nums)-1 && nums[thirdIndex] == nums[thirdIndex+1] {
				thirdIndex--
				continue
			}
			if nums[secondIndex]+nums[thirdIndex] == target {
				results = append(results, []int{nums[index], nums[secondIndex], nums[thirdIndex]})
				secondIndex++
				thirdIndex--
			} else if nums[secondIndex]+nums[thirdIndex] < target {
				secondIndex++
			} else if nums[secondIndex]+nums[thirdIndex] > target {
				thirdIndex--
			}
		}
	}
	return results
}

func main() {
	println(reflect.DeepEqual(threeSum([]int{-1, 0, 1, 2, -1, -4}), [][]int{{-1, -1, 2}, {-1, 0, 1}}))
	println(reflect.DeepEqual(threeSum([]int{0, 0, 0}), [][]int{{0, 0, 0}}))
	println(reflect.DeepEqual(threeSum([]int{0, 0, 0, 0}), [][]int{{0, 0, 0}}))
}
