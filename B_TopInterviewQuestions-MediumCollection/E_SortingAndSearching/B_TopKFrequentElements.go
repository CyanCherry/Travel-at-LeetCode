package main

import (
	"reflect"
)

type numCounter struct {
	Num   int
	Count int
}

type MaxCountHeap struct {
	data []numCounter
}

func (h *MaxCountHeap) insert(nc numCounter) {
	h.data = append(h.data, nc)
	ncIndex := len(h.data) - 1
	parent := func(index int) int {
		return (index - 1) / 2
	}
	parentIndex := parent(ncIndex)
	for h.data[ncIndex].Count > h.data[parentIndex].Count {
		h.data[ncIndex], h.data[parentIndex] = h.data[parentIndex], h.data[ncIndex]
		ncIndex = parentIndex
		parentIndex = parent(ncIndex)
	}
}

func (h *MaxCountHeap) remove() numCounter {
	nc := h.data[0]
	// set root as the last node, then shift down it.
	h.data[0] = h.data[len(h.data)-1]
	h.data = h.data[:len(h.data)-1]
	cur := 0
	left := cur*2 + 1
	right := cur*2 + 2
	for left < len(h.data) {
		if right < len(h.data) {
			// switch current with the bigger one
			var big int
			if h.data[left].Count < h.data[right].Count {
				big = right
			} else {
				big = left
			}
			if h.data[cur].Count < h.data[big].Count {
				h.data[cur], h.data[big] = h.data[big], h.data[cur]
				cur = big
			} else {
				break
			}
		} else {
			if h.data[cur].Count < h.data[left].Count {
				h.data[cur], h.data[left] = h.data[left], h.data[cur]
				cur = left
			} else {
				break
			}
		}
		left = cur*2 + 1
		right = cur*2 + 2
	}
	return nc
}

func (h *MaxCountHeap) getNums(count int) []int {
	r := make([]int, count)
	for i := 0; i < count; i++ {
		r[i] = h.remove().Num
	}
	return r
}

func topKFrequent(nums []int, k int) []int {
	counter := map[int]int{}
	for _, num := range nums {
		counter[num]++
	}
	heap := MaxCountHeap{make([]numCounter, 0, len(counter))}
	for k, v := range counter {
		heap.insert(numCounter{
			Num:   k,
			Count: v,
		})
	}
	return heap.getNums(k)
}

func main() {
	println(reflect.DeepEqual(
		topKFrequent([]int{1, 1, 1, 2, 2, 3}, 2),
		[]int{1, 2},
	))
	println(reflect.DeepEqual(
		topKFrequent([]int{1}, 1),
		[]int{1},
	))
	println(reflect.DeepEqual(
		topKFrequent([]int{4, 1, -1, 2, -1, 2, 3}, 2),
		[]int{-1, 2},
	))
	println(reflect.DeepEqual(
		topKFrequent([]int{5, -3, 9, 1, 7, 7, 9, 10, 2, 2, 10, 10, 3, -1, 3, 7, -9, -1, 3, 3}, 3),
		[]int{3, 7, 10},
	))
}
