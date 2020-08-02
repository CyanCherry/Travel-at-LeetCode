package main

import "reflect"

func setZeroes(matrix [][]int) {
	if len(matrix) == 0 {
		return
	}
	rowLen := len(matrix[0])
	if rowLen == 0 {
		return
	}
	for _, row := range matrix {
		if len(row) != rowLen {
			return
		}
	}

	firstRowFlag := matrix[0][0] == 0
	firstColFlag := matrix[0][0] == 0
	for index := 1; !firstRowFlag && index < rowLen; index++ {
		if matrix[0][index] == 0 {
			firstRowFlag = true
		}
	}
	for index := 1; !firstColFlag && index < len(matrix); index++ {
		if matrix[index][0] == 0 {
			firstColFlag = true
		}
	}
	for colIndex := 1; colIndex < len(matrix); colIndex++ {
		for rowIndex := 1; rowIndex < rowLen; rowIndex++ {
			if matrix[colIndex][rowIndex] == 0 {
				matrix[0][rowIndex] = 0
				matrix[colIndex][0] = 0
			}
		}
	}
	for colIndex := 1; colIndex < len(matrix); colIndex++ {
		for rowIndex := 1; rowIndex < rowLen; rowIndex++ {
			if matrix[colIndex][0] == 0 || matrix[0][rowIndex] == 0 {
				matrix[colIndex][rowIndex] = 0
			}
		}
	}
	if firstRowFlag {
		for index, _ := range matrix[0] {
			matrix[0][index] = 0
		}
	}
	if firstColFlag {
		for _, row := range matrix {
			row[0] = 0
		}
	}
}

func main() {
	test := [][]int{
		{1, 1, 1},
		{1, 0, 1},
		{1, 1, 1},
	}
	setZeroes(test)
	println(reflect.DeepEqual(test, [][]int{
		{1, 0, 1},
		{0, 0, 0},
		{1, 0, 1},
	}))
	test = [][]int{
		{0, 1, 2, 0},
		{3, 4, 5, 2},
		{1, 3, 1, 5},
	}
	setZeroes(test)
	println(reflect.DeepEqual(test, [][]int{
		{0, 0, 0, 0},
		{0, 4, 5, 0},
		{0, 3, 1, 0},
	}))
}
