package main

func findPeakElement(nums []int) int {
	if len(nums) == 1 {
		return 0
	}
	if nums[0] > nums[1] {
		return 0
	}
	if nums[len(nums)-1] > nums[len(nums)-2] {
		return len(nums) - 1
	}
	abs := func(num int) int {
		if num < 0 {
			return -num
		}
		return num
	}
	var result int
	var try func(start, end int)
	try = func(start, end int) {
		if end-start < 16 {
			for i := start; i < end; i++ {
				if nums[i] > nums[i-1] && nums[i] > nums[i+1] {
					result = i
					return
				}
			}
			return
		}
		middle := (start + end) / 2
		mv := nums[middle]
		if mv > nums[middle-1] && mv > nums[middle+1] {
			result = middle
			return
		}
		if abs(mv-nums[start]) < middle-start-1 {
			try(start, middle)
		} else if abs(nums[end-1]-mv) < end-middle-1 {
			try(middle+1, end)
		} else {
			try(start, middle)
			try(middle+1, end)
		}
	}
	try(1, len(nums)-1)
	return result
}

func main() {
	println(2 == findPeakElement([]int{1, 2, 3, 1}))
	println(3 == findPeakElement([]int{1, 2, 3, 4, 1}))
	println(2 == findPeakElement([]int{1, 2, 5, 4, 3, 2, 1}))
	result := findPeakElement([]int{1, 2, 1, 3, 5, 6, 4})
	println(result == 1 || result == 5)
}
