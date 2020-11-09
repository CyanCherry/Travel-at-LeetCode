package main

import (
	"fmt"
	"math/rand"
)

type RandomizedSet struct {
	slice []int
	index map[int]int
}

func Constructor() RandomizedSet {
	return RandomizedSet{
		index: map[int]int{},
		slice: []int{},
	}
}

func (i *RandomizedSet) Insert(val int) bool {
	if _, ok := i.index[val]; ok {
		return false
	}
	i.index[val] = len(i.slice)
	i.slice = append(i.slice, val)

	return true
}

func (i *RandomizedSet) Remove(val int) bool {
	if _, ok := i.index[val]; !ok {
		return false
	}
	index := i.index[val]
	end := len(i.slice) - 1
	move := i.slice[end]

	delete(i.index, val)
	i.slice = i.slice[:end]

	if index != end {
		i.index[move] = index
		i.slice[index] = move
	}
	return true
}

func (i *RandomizedSet) GetRandom() int {
	return i.slice[rand.Intn(len(i.slice))]
}

func main() {
	obj := Constructor()
	fmt.Println(true == obj.Insert(1))
	fmt.Println(false == obj.Remove(2))
	fmt.Println(true == obj.Insert(2))
	fmt.Println(2 == obj.GetRandom())
	fmt.Println(true == obj.Remove(1))
	fmt.Println(false == obj.Insert(2))
	fmt.Println(2 == obj.GetRandom())

	obj = Constructor()
	fmt.Println(true == obj.Insert(0))
	fmt.Println(true == obj.Insert(1))
	fmt.Println(true == obj.Remove(0))
	fmt.Println(true == obj.Insert(2))
	fmt.Println(true == obj.Remove(1))
	fmt.Println(2 == obj.GetRandom())
}
