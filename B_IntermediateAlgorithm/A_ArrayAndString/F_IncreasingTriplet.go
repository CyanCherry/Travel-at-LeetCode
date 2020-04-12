package main

func increasingTriplet(nums []int) bool {
	if len(nums) < 3 {
		return false
	}
	var num1, num2 int
	for index := 0; index < len(nums)-1; index++ {
		currentNum := nums[index]
		nextNum := nums[index+1]

		if currentNum < nextNum {
			if num1 == num2 {
				num1, num2 = currentNum, nextNum
			} else if num2 < nextNum {
				return true
			} else if num1 > currentNum {
				num1, num2 = currentNum, nextNum
			} else if num2 > currentNum {
				num2 = currentNum
			}
		} else if num1 != num2 && num2 < currentNum {
			return true
		}
	}
	return false
}

func main() {
	println(increasingTriplet([]int{1, 2, 3, 4, 5}) == true)
	println(increasingTriplet([]int{5, 4, 3, 2, 1}) == false)
	println(increasingTriplet([]int{5, 1, 5, 5, 2, 5, 4}) == true)
	println(increasingTriplet([]int{2, 1, 5, 0, 3}) == false)
}
