// for live cells {
// if they have 2 or 3 live neighbors, they stay alive
// if they have less than 2 live neighbors, they die
// if they have more than 3 live neighbors, they also die
// for dead cells {
// if they have exactly 3 live neighbors, they become alive
import { MyArrays } from "../lib.ts"

function gameOfLife(board: number[][]): void {
    const height = board.length
    if (height == 0) {
        return
    }
    const width = board[0].length
    if (width == 0) {
        return
    }
    for (let i = 0; i < height; i++) {
        if (board[i].length != width) {
            return
        }
    }

    if (height == 1) {
        const row = board[0]
        const row_tmp = [...board[0]]
        row_tmp[0] = 0
        row_tmp[width - 1] = 0
        for (let i = 1; i < row_tmp.length - 1; i++) {
            if (row[i] == 1 && !(row[i - 1] == 1 && row[i + 1] == 1)) {
                row_tmp[i] = 0
            }
        }
        board[0] = row_tmp
        return
    }

    let previous_row = [...board[0]]
    for (let i = 0; i < previous_row.length; i++) {
        let live_neighbor_count = board[1][i]
        if (i > 0) {
            live_neighbor_count += board[0][i - 1]
            live_neighbor_count += board[1][i - 1]
        }
        if (i < width - 1) {
            live_neighbor_count += board[0][i + 1]
            live_neighbor_count += board[1][i + 1]
        }
        if (previous_row[i] == 0 && live_neighbor_count == 3) {
            previous_row[i] = 1
        }
        if (previous_row[i] == 1 && (live_neighbor_count > 3 || live_neighbor_count < 2)) {
            previous_row[i] = 0
        }
    }

    for (let r = 1; r < board.length - 1; r++) {
        const row_tmp = [...board[r]]
        for (let c = 0; c < row_tmp.length; c++) {
            let live_neighbor_count = board[r - 1][c] + board[r + 1][c]
            if (c > 0) {
                live_neighbor_count += board[r][c - 1]
                live_neighbor_count += board[r - 1][c - 1]
                live_neighbor_count += board[r + 1][c - 1]
            }
            if (c < width - 1) {
                live_neighbor_count += board[r][c + 1]
                live_neighbor_count += board[r - 1][c + 1]
                live_neighbor_count += board[r + 1][c + 1]
            }
            if (row_tmp[c] == 0 && live_neighbor_count == 3) {
                row_tmp[c] = 1
            }
            if (row_tmp[c] == 1 && (live_neighbor_count > 3 || live_neighbor_count < 2)) {
                row_tmp[c] = 0
            }
        }
        board[r - 1] = previous_row
        previous_row = row_tmp
    }
    const last_row = [...board[height - 1]]
    for (let i = 0; i < width; i++) {
        let live_neighbor_count = board[height - 2][i]
        if (i > 0) {
            live_neighbor_count += board[height - 1][i - 1]
            live_neighbor_count += board[height - 2][i - 1]
        }
        if (i < width - 1) {
            live_neighbor_count += board[height - 1][i + 1]
            live_neighbor_count += board[height - 2][i + 1]
        }
        if (last_row[i] == 0 && live_neighbor_count == 3) {
            last_row[i] = 1
        }
        if (last_row[i] == 1 && (live_neighbor_count > 3 || live_neighbor_count < 2)) {
            last_row[i] = 0
        }
    }
    board[height - 2] = previous_row
    board[height - 1] = last_row
}

const board1 = [
    [0, 1, 0],
    [0, 0, 1],
    [1, 1, 1],
    [0, 0, 0],
]
gameOfLife(board1)
console.log(MyArrays.equals(board1, [
    [0, 0, 0],
    [1, 0, 1],
    [0, 1, 1],
    [0, 1, 0],
]))

const board2 = [
    [1, 1],
    [1, 0],
]
gameOfLife(board2)
console.log(MyArrays.equals(board2, [
    [1, 1],
    [1, 1],
]))

const board3 = [
    [0],
]
gameOfLife(board3)
console.log(MyArrays.equals(board3, [
    [0],
]))
