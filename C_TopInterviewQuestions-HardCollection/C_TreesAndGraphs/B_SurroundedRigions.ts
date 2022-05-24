import { MyArrays } from "../lib.ts"

function solve(board: string[][]): void {
    const height = board.length
    if (height == 0) {
        return
    }
    const width = board[0].length
    for (let i = 1; i < height; i++) {
        if (board[i].length != width) {
            return
        }
    }

    const rLast = height - 1
    const cLast = width - 1
    const phantom = new Array(height)
    for (let i = 0; i < height; i++) {
        phantom[i] = new Array(width).fill("X")
    }

    function rust(r: number, c: number) {
        if (board[r][c] == "O" && phantom[r][c] == "X") {
            phantom[r][c] = "O"
            if (r > 0) {
                rust(r - 1, c)
            }
            if (c > 0) {
                rust(r, c - 1)
            }
            if (r < rLast) {
                rust(r + 1, c)
            }
            if (c < cLast) {
                rust(r, c + 1)
            }
        }
    }

    for (let i = 0; i < width; i++) {
        rust(0, i)
        rust(rLast, i)
    }
    for (let i = 1; i < rLast; i++) {
        rust(i, 0)
        rust(i, cLast)
    }

    phantom.forEach((_, index) => {
        board[index] = phantom[index]
    })
}

const test1 = [
    ["X", "X", "X", "X"],
    ["X", "O", "O", "X"],
    ["X", "X", "O", "X"],
    ["X", "O", "X", "X"],
]
solve(test1)
console.log(MyArrays.equals(test1, [
    ["X", "X", "X", "X"],
    ["X", "X", "X", "X"],
    ["X", "X", "X", "X"],
    ["X", "O", "X", "X"],
]))

const test2 = [["X"]]
solve(test2)
console.log(MyArrays.equals(test2, [["X"]]))

const test3 = [
    ["X", "O", "X", "O", "X", "O"],
    ["O", "X", "O", "X", "O", "X"],
    ["X", "O", "X", "O", "X", "O"],
    ["O", "X", "O", "X", "O", "X"],
]
solve(test3)
console.log(MyArrays.equals(test3, [
    ["X", "O", "X", "O", "X", "O"],
    ["O", "X", "X", "X", "X", "X"],
    ["X", "X", "X", "X", "X", "O"],
    ["O", "X", "O", "X", "O", "X"],
]))
