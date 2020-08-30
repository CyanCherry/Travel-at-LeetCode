package main

func searchMatrix(matrix [][]int, target int) bool {
	if len(matrix) == 0 {
		return false
	}
	if len(matrix[0]) == 0 {
		return false
	}
	if target < matrix[0][0] || target > matrix[len(matrix)-1][len(matrix[len(matrix)-1])-1] {
		return false
	}
	// [ start, end )
	rowStart, rowEnd := 0, len(matrix)
	columnStart, columnEnd := 0, len(matrix[0])
	cut := true
	for cut {
		cut = false
		for matrix[rowStart][columnStart] > target {
			rowStart++
			cut = true
		}
		for matrix[rowEnd-1][columnEnd-1] < target {
			rowEnd--
			cut = true
		}
		for matrix[rowEnd-1][columnStart] < target {
			columnStart++
			cut = true
		}
		for matrix[rowStart][columnEnd-1] > target {
			columnEnd--
			cut = true
		}
		if rowEnd-rowStart < 1 || columnEnd-columnStart < 1 {
			return false
		}
	}
	for r := rowStart; r < rowEnd; r++ {
		for c := columnStart; c < columnEnd; c++ {
			if matrix[r][c] == target {
				return true
			}
		}
	}
	return false
}

func main() {
	println(true == searchMatrix(
		[][]int{
			{1, 4, 7, 11, 15},
			{2, 5, 8, 12, 19},
			{3, 6, 9, 16, 22},
			{10, 13, 14, 17, 24},
			{18, 21, 23, 26, 30},
		},
		5,
	))
	println(false == searchMatrix(
		[][]int{
			{1, 4, 7, 11, 15},
			{2, 5, 8, 12, 19},
			{3, 6, 9, 16, 22},
			{10, 13, 14, 17, 24},
			{18, 21, 23, 26, 30},
		},
		20,
	))
	println(false == searchMatrix([][]int{{}}, 0))
	println(false == searchMatrix([][]int{{-5}}, -2))
	println(false == searchMatrix([][]int{{-1, 3}}, 1))
}
