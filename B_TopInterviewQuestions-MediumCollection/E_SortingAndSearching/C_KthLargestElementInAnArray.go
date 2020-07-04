package main

import (
    "math/rand"
    "time"
)

func findKthLargest(nums []int, k int) int {
    quickSort(nums, 0, len(nums), k)
    return nums[k-1]
}

func quickSort(nums []int, start, end, k int) {
    if start > k || end < k || end-start < 2 {
        return
    }
    if end-start == 2 {
        next := start + 1
        if nums[start] < nums[next] {
            nums[start], nums[next] = nums[next], nums[start]
        }
        return
    }
    pivot := start + rand.Intn(end-start)
    rand.Seed(time.Now().UnixNano())
    pv := nums[pivot]
    nums[pivot], nums[start] = nums[start], nums[pivot]
    i, j := start, end-1
    for {
        for i < j && nums[j] <= pv {
            j--
        }
        for i < j && nums[i] >= pv {
            i++
        }
        if i >= j {
            break
        }
        nums[i], nums[j] = nums[j], nums[i]
    }
    nums[start], nums[i] = nums[i], nums[start]
    quickSort(nums, start, i, k)
    quickSort(nums, i+1, end, k)
}

func main() {
    println(findKthLargest([]int{3, 2, 1, 5, 6, 4}, 2) == 5)
    println(findKthLargest([]int{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4) == 4)
    println(findKthLargest([]int{-1, 2, 0}, 2) == 0)
}
