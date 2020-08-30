package main

func canJump(nums []int) bool {
	end := nums[0]
	for i := 1; i < len(nums); i++ {
		if end < i {
			return false
		}
		currentEnd := i + nums[i]
		if end < currentEnd {
			end = currentEnd
		}
		if end >= len(nums)-1 {
			return true
		}
	}
	return end >= len(nums)-1
}

func main() {
	println(true == canJump([]int{2, 3, 1, 1, 4}))
	println(false == canJump([]int{3, 2, 1, 0, 4}))
}
