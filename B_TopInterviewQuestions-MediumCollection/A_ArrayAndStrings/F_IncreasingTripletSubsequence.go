package main

func increasingTriplet(nums []int) bool {
    var min, intermediate int
    for index := 0; index < len(nums)-1; index++ {
        currentNum := nums[index]
        nextNum := nums[index+1]
        if currentNum < nextNum {
            if min == intermediate {
                min, intermediate = currentNum, nextNum
            } else if intermediate < nextNum {
                return true
            } else if min > currentNum {
                min, intermediate = currentNum, nextNum
            } else if intermediate > currentNum {
                intermediate = currentNum
            }
        } else if min != intermediate && intermediate < currentNum {
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
    println(increasingTriplet([]int{2, 1, 5, 0, 4, 6}) == true)
}
