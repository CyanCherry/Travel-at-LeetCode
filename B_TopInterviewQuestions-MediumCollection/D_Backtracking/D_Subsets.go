package main

import (
	"math"
	"reflect"
)

func subsets(nums []int) [][]int {
	var results [][]int
	for subIndex := 0; subIndex < int(math.Pow(2, float64(len(nums)))); subIndex++ {
		result := make([]int, 0)
		for index, num := range nums {
			if 1<<index&subIndex != 0 {
				result = append(result, num)
			}
		}
		results = append(results, result)
	}
	return results
}

func main() {
	println(reflect.DeepEqual(
		[][]int{
			{},
			{1},
			{2},
			{1, 2},
			{3},
			{1, 3},
			{2, 3},
			{1, 2, 3},
		},
		subsets([]int{1, 2, 3}),
	))
}
