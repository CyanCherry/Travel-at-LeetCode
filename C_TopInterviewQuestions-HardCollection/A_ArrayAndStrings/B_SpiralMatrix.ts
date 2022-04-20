import { MyArrays } from "../lib.ts"

function spiralOrder(matrix: number[][]): number[] {
    if ((matrix.length == 0)) {
        return []
    }
    const height = matrix.length
    const width = matrix[0].length
    for (let i = 1; i < matrix.length; i++) {
        if (matrix[i].length != width) {
            return []
        }
    }
    const layer = Math.floor((height < width ? height : width) / 2)
    const result: number[] = []
    for (let l = 0; l < layer; l++) {
        const rowEnd = width - l - 1
        const columnEnd = height - l - 1
        for (let i = l; i < rowEnd; i++) {
            result.push(matrix[l][i])
        }
        for (let i = l; i < columnEnd; i++) {
            result.push(matrix[i][rowEnd])
        }
        for (let i = rowEnd; i > l; i--) {
            result.push(matrix[columnEnd][i])
        }
        for (let i = columnEnd; i > l; i--) {
            result.push(matrix[i][l])
        }
    }
    if (height < width && height % 2 != 0) {
        for (let i = layer; i < width - layer; i++) {
            result.push(matrix[layer][i])
        }
    } else if (width % 2 != 0) {
        for (let i = layer; i < height - layer; i++) {
            result.push(matrix[i][layer])
        }
    }
    return result
}


console.log(MyArrays.equals(spiralOrder([
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9],
]), [1, 2, 3, 6, 9, 8, 7, 4, 5]))

console.log(MyArrays.equals(spiralOrder([
    [1, 2, 3, 4],
    [5, 6, 7, 8],
    [9, 10, 11, 12],
]), [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]))

console.log(MyArrays.equals(spiralOrder([
    [1],
]), [1]))

console.log(MyArrays.equals(spiralOrder([
    [2, 3],
]), [2, 3]))

console.log(MyArrays.equals(spiralOrder([
    [2, 5],
    [8, 4],
    [0, -1],
]), [2, 5, 4, -1, 0, 8]))

console.log(MyArrays.equals(spiralOrder([
    [2, 5, 4],
    [8, 0, -1],
]), [2, 5, 4, -1, 0, 8]))

console.log(MyArrays.equals(spiralOrder([
    [1, 2, 3, 4, 5, 6],
    [7, 8, 9, 10, 11, 12],
    [13, 14, 15, 16, 17, 18],
    [19, 20, 21, 22, 23, 24],
    [25, 26, 27, 28, 29, 30],
]), [1, 2, 3, 4, 5, 6, 12, 18, 24, 30, 29, 28, 27, 26, 25, 19, 13, 7, 8, 9, 10, 11, 17, 23, 22, 21, 20, 14, 15, 16]))
