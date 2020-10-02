package main

import (
	"sort"
)

func coinChange(coins []int, amount int) int {
	if amount == 0 {
		return 0
	}
	if len(coins) == 0 {
		return -1
	}
	sort.Slice(coins, func(i, j int) bool {
		return coins[i] > coins[j]
	})
	count := 0

	var try func(currentAmount, currentCount, coinIndex int)
	try = func(currentAmount, currentCount, coinIndex int) {
		if currentAmount == amount {
			if count == 0 || currentCount < count {
				count = currentCount
			}
		} else if currentAmount < amount {
			for i := coinIndex; i < len(coins); i++ {
				if count == 0 || coins[i]*(count-currentCount) > amount-currentAmount {
					try(currentAmount+coins[i], currentCount+1, i)
				}
			}
		}
	}
	try(0, 0, 0)
	if count == 0 {
		return -1
	}
	return count
}

func main() {
	println(3 == coinChange([]int{1, 2, 5}, 11))
	println(-1 == coinChange([]int{2}, 3))
	println(20 == coinChange([]int{186, 419, 83, 408}, 6249))
	println(20 == coinChange([]int{1, 2, 5}, 100))
}
