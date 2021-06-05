package main

import "fmt"

type Soldiers struct {
	ID int
	HP int
}

func (s *Soldiers) fight(ID int) {
	if s.ID == ID {
		s.HP++
	} else {
		s.HP--
	}
	if s.HP == 0 {
		s.ID = ID
		s.HP = 1
	}
}

func majorityElement(nums []int) int {
	if len(nums) == 0 {
		return 0
	}
	soldier := Soldiers{
		ID: nums[0],
		HP: 1,
	}
	for _, num := range nums {
		soldier.fight(num)
	}
	return soldier.ID
}

func main() {
	fmt.Println(3 == majorityElement([]int{3, 2, 3}))
	fmt.Println(2 == majorityElement([]int{2, 2, 1, 1, 1, 2, 2}))
}
