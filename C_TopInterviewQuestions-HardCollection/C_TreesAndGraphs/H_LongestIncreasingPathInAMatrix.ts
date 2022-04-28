function longestIncreasingPath(matrix: number[][]): number {
    const result = new Array(matrix.length)
    for (let i = 0; i < matrix.length; i++) {
        result[i] = new Array(matrix[i].length).fill(0)
    }

    function search(r: number, c: number) {
        if (result[r][c] == 0) {
            const current = matrix[r][c]
            let max = 0
            if (r > 0 && matrix[r - 1][c] > current) {
                max = Math.max(max, search(r - 1, c))
            }
            if (r + 1 < matrix.length && matrix[r + 1][c] > current) {
                max = Math.max(max, search(r + 1, c))
            }
            if (matrix[r][c - 1] > current) {
                max = Math.max(max, search(r, c - 1))
            }
            if (matrix[r][c + 1] > current) {
                max = Math.max(max, search(r, c + 1))
            }
            result[r][c] = max + 1
        }
        return result[r][c]
    }

    let globalMax = 0
    for (let i = 0; i < matrix.length; i++) {
        const row = matrix[i]
        for (let j = 0; j < row.length; j++) {
            const max = search(i, j)
            if (max > globalMax) {
                globalMax = max
            }
        }
    }
    return globalMax
}

console.log(4 === longestIncreasingPath([
    [9, 9, 4],
    [6, 6, 8],
    [2, 1, 1],
]))

console.log(4 === longestIncreasingPath([
    [3, 4, 5],
    [3, 2, 6],
    [2, 2, 1],
]))

console.log(1 === longestIncreasingPath([
    [1],
]))
