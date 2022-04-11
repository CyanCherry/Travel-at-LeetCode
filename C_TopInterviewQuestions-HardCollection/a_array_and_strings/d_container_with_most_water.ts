function maxArea(height: number[]): number {
    if (height.length < 2) {
        return 0
    }
    let max_area = 0
    let left_index = 0
    let right_index = height.length - 1
    while (left_index < right_index) {
        const left_height = height[left_index]
        const right_height = height[right_index]
        const area = (right_index - left_index) * Math.min(left_height, right_height)
        if (area > max_area) {
            max_area = area
        }
        if (left_height < right_height) {
            left_index += 1
        } else {
            right_index -= 1
        }
    }
    return max_area
}


console.log(maxArea([1, 1]) == 1)
console.log(maxArea([4, 3, 2, 1, 4]) == 16)
console.log(maxArea([1, 2, 1]) == 2)

