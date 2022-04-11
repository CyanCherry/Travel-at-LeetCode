function longestConsecutive(nums: number[]): number {
    let max_len = 0
    const from_to = new Map<number, number>()
    const to_from = new Map<number, number>()
    for (const num of nums) {
        if (from_to.has(num) || to_from.has(num)) {
            continue
        }
        const right = from_to.get(num + 1)
        const left = to_from.get(num - 1)
        if (right != undefined) {
            if (left != undefined) {
                from_to.delete(num + 1)
                from_to.set(left, right)
                to_from.delete(num - 1)
                to_from.set(right, left)
                max_len = Math.max(max_len, right - left + 1)
            } else {
                from_to.delete(num + 1)
                from_to.set(num, right)
                to_from.set(right, num)
                max_len = Math.max(max_len, right - num + 1)
            }
        } else {
            if (left != undefined) {
                from_to.set(left, num)
                to_from.delete(num - 1)
                to_from.set(num, left)
                max_len = Math.max(max_len, num - left + 1)
            } else {
                from_to.set(num, num)
                to_from.set(num, num)
                max_len = Math.max(max_len, 1)
            }
        }
    }
    return max_len
}

console.log(4 == longestConsecutive([100, 4, 200, 1, 3, 2]))
console.log(9 == longestConsecutive([0, 3, 7, 2, 5, 8, 4, 6, 0, 1]))
console.log(4 == longestConsecutive([-7, -1, 3, -9, -4, 7, -3, 2, 4, 9, 4, -9, 8, -7, 5, -1, -7]))
