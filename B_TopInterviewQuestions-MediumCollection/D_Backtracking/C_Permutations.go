package main

import (
    "reflect"
)

func permute(nums []int) [][]int {
    cache := make([][]int, len(nums)+1)
    resultsLen := 1
    for index, _ := range nums {
        resultsLen *= index + 1
        cache[index] = make([]int, index)
    }
    cache[len(nums)] = nums
    results := make([][]int, 0, resultsLen)
    var try func(remain int, result []int)
    try = func(remain int, result []int) {
        if remain == 0 {
            results = append(results, result)
            return
        }
        for index := 0; index < remain; index++ {
            for numIndex := 0; numIndex < index; numIndex++ {
                cache[remain-1][numIndex] = cache[remain][numIndex]
            }
            for numIndex := index + 1; numIndex < remain; numIndex++ {
                cache[remain-1][numIndex-1] = cache[remain][numIndex]
            }
            try(remain-1, append(result, cache[remain][index]))
        }
    }
    try(len(nums), make([]int, 0, len(nums)-1))
    return results
}

func main() {
    println(reflect.DeepEqual(
        permute([]int{1, 2, 3}),
        [][]int{
            {1, 2, 3},
            {1, 3, 2},
            {2, 1, 3},
            {2, 3, 1},
            {3, 1, 2},
            {3, 2, 1},
        },
    ))
}
