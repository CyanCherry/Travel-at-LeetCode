package main

import (
	"reflect"
	"sort"
)

const START = 0
const END = 1

func merge(intervals [][]int) [][]int {
	if len(intervals) == 0 {
		return intervals
	}
	// sort intervals based on their start
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][START] < intervals[j][START]
	})
	// integrate intervals
	results := make([][]int, 0)
	result := intervals[0]
	for i := 1; i < len(intervals); i++ {
		interval := intervals[i]
		if result[END] < interval[START] {
			results = append(results, result)
			result = interval
		} else if result[END] < interval[END] {
			result[END] = interval[END]
		}
	}
	results = append(results, result)
	return results
}

func main() {
	println(reflect.DeepEqual([][]int{{1, 6}, {8, 10}, {15, 18}}, merge([][]int{{1, 3}, {2, 6}, {8, 10}, {15, 18}})))
	println(reflect.DeepEqual([][]int{{1, 5}}, merge([][]int{{1, 4}, {4, 5}})))
	println(reflect.DeepEqual([][]int{{1, 4}}, merge([][]int{{1, 4}, {2, 3}})))
	println(reflect.DeepEqual([][]int{}, merge([][]int{})))
}
