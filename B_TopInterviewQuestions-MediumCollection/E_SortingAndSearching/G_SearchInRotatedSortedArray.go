package main

func search(nums []int, target int) int {
	result := -1
	var try func(start, end int)
	// search on [start, end)
	try = func(start, end int) {
		if end-start < 5 {
			for i := start; i < end; i++ {
				if nums[i] == target {
					result = i
				}
			}
			return
		}
		middle := (start + end) / 2
		if nums[start] < nums[end-1] {
			if target >= nums[start] && target <= nums[middle] {
				try(start, middle)
			}
			if target >= nums[middle] && target <= nums[end-1] {
				try(middle, end)
			}
		} else if nums[middle] > nums[start] {
			if target >= nums[start] && target <= nums[middle] {
				try(start, middle)
			}
			if target >= nums[middle] || target <= nums[end-1] {
				try(middle, end)
			}
		} else {
			if target >= nums[start] || target <= nums[middle] {
				try(start, middle)
			}
			if target >= nums[middle] && target <= nums[end-1] {
				try(middle, end)
			}
		}
	}
	try(0, len(nums))
	return result
}

func main() {
	println(4 == search([]int{4, 5, 6, 7, 0, 1, 2}, 0))
	println(-1 == search([]int{4, 5, 6, 7, 0, 1, 2}, 3))
	println(-1 == search([]int{1}, 0))
	println(3 == search([]int{7, 8, 1, 2, 3, 4, 5, 6}, 2))
	println(0 == search([]int{9, 1, 2, 3, 4, 5, 6, 7, 8}, 9))
}
