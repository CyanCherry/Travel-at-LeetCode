package main

func exist(board [][]byte, word string) bool {
	var tryFrom func(rowIndex, index int, word string) bool
	var result bool
	tryFrom = func(rowIndex, index int, word string) bool {
		if len(word) == 0 {
			return true
		}
		var letter byte
		if rowIndex+1 < len(board) {
			letter = board[rowIndex+1][index]
			if letter == word[0] {
				board[rowIndex+1][index] = 0
				result = tryFrom(rowIndex+1, index, word[1:])
				board[rowIndex+1][index] = letter
				if result {
					return true
				}
			}
		}
		if rowIndex > 0 {
			letter = board[rowIndex-1][index]
			if letter == word[0] {
				board[rowIndex-1][index] = 0
				result = tryFrom(rowIndex-1, index, word[1:])
				board[rowIndex-1][index] = letter
				if result {
					return true
				}
			}
		}
		if index+1 < len(board[rowIndex]) {
			letter = board[rowIndex][index+1]
			if letter == word[0] {
				board[rowIndex][index+1] = 0
				result = tryFrom(rowIndex, index+1, word[1:])
				board[rowIndex][index+1] = letter
				if result {
					return true
				}
			}
		}
		if index > 0 {
			letter = board[rowIndex][index-1]
			if letter == word[0] {
				board[rowIndex][index-1] = 0
				result = tryFrom(rowIndex, index-1, word[1:])
				board[rowIndex][index-1] = letter
				if result {
					return true
				}
			}
		}
		return false
	}
	for rowIndex, row := range board {
		for index, letter := range row {
			if letter == word[0] {
				board[rowIndex][index] = 0
				result = tryFrom(rowIndex, index, word[1:])
				board[rowIndex][index] = letter
				if result {
					return true
				}
			}
		}
	}
	return false
}

func main() {
	board := [][]byte{
		{'A', 'B', 'C', 'E'},
		{'S', 'F', 'C', 'S'},
		{'A', 'D', 'E', 'E'},
	}
	println(true == exist(board, "ABCCED"))
	println(true == exist(board, "SEE"))
	println(false == exist(board, "ABCB"))
}
