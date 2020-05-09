package main

func numIslands(grid [][]byte) int {
    var count int
    var hideIsland func(rowIndex, index int)
    hideIsland = func(rowIndex, index int) {
        grid[rowIndex][index] = '0'
        if rowIndex+1 < len(grid) && grid[rowIndex+1][index] != '0' {
            hideIsland(rowIndex+1, index)
        }
        if rowIndex > 0 && grid[rowIndex-1][index] != '0' {
            hideIsland(rowIndex-1, index)
        }
        if index+1 < len(grid[rowIndex]) && grid[rowIndex][index+1] != '0' {
            hideIsland(rowIndex, index+1)
        }
        if index > 0 && grid[rowIndex][index-1] != '0' {
            hideIsland(rowIndex, index-1)
        }
    }
    for rowIndex, row := range grid {
        for index, num := range row {
            if num != '0' {
                hideIsland(rowIndex, index)
                count++
            }
        }
    }
    return count
}

func main() {
    println(1 == numIslands(
        [][]byte{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
        },
    ))
    println(3 == numIslands(
        [][]byte{
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'},
        },
    ))
    println(1 == numIslands(
        [][]byte{
            {'1', '1', '1'},
            {'0', '1', '0'},
            {'1', '1', '1'},
        },
    ))
    println(1 == numIslands(
        [][]byte{
            {'1', '0', '1', '1', '1'},
            {'1', '0', '1', '0', '1'},
            {'1', '1', '1', '0', '1'},
        },
    ))
}
