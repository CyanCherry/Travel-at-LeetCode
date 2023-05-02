package main

import (
	"fmt"
)

func maximalSquare(matrix [][]byte) int {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return 0
	}
	height, width := len(matrix), len(matrix[0])
	for _, row := range matrix {
		if len(row) != width {
			return 0
		}
	}

	m := make([][]int, height)
	for i := range m {
		m[i] = make([]int, width)
	}

	result := 0
	for i := 0; i < height; i++ {
		switch matrix[i][0] {
		case '0':
			m[i][0] = 0
		case '1':
			m[i][0] = 1
			result = 1
		default:
			return 0
		}
	}
	for i := 0; i < width; i++ {
		switch matrix[0][i] {
		case '0':
			m[0][i] = 0
		case '1':
			m[0][i] = 1
			result = 1
		default:
			return 0
		}
	}
	for r := 1; r < height; r++ {
		for c := 1; c < width; c++ {
			if matrix[r][c] == '0' {
				m[r][c] = 0
				continue
			}
			curr := m[r-1][c]
			if m[r][c-1] < curr {
				curr = m[r][c-1]
			}
			if m[r-1][c-1] < curr {
				curr = m[r-1][c-1]
			}
			curr++
			m[r][c] = curr
			currSqrt := curr * curr
			if currSqrt > result {
				result = currSqrt
			}
		}
	}
	return result
}

func main() {
	fmt.Println(4 == maximalSquare([][]byte{
		{'1', '0', '1', '0', '0'},
		{'1', '0', '1', '1', '1'},
		{'1', '1', '1', '1', '1'},
		{'1', '0', '0', '1', '0'},
	}))
	fmt.Println(1 == maximalSquare([][]byte{
		{'0', '1'},
		{'1', '0'},
	}))
	fmt.Println(0 == maximalSquare([][]byte{
		{'0'},
	}))
	fmt.Println(1 == maximalSquare([][]byte{
		{'1'},
	}))
	fmt.Println(1 == maximalSquare([][]byte{
		{'0', '1'},
		{'0', '1'},
	}))
	fmt.Println(9 == maximalSquare([][]byte{
		{'0', '0', '0', '1'},
		{'1', '1', '0', '1'},
		{'1', '1', '1', '1'},
		{'0', '1', '1', '1'},
		{'0', '1', '1', '1'},
	}))
	fmt.Println(16 == maximalSquare([][]byte{
		{'1', '1', '1', '1', '1', '1', '1', '1'},
		{'1', '1', '1', '1', '1', '1', '1', '0'},
		{'1', '1', '1', '1', '1', '1', '1', '0'},
		{'1', '1', '1', '1', '1', '0', '0', '0'},
		{'0', '1', '1', '1', '1', '0', '0', '0'},
	}))
}
