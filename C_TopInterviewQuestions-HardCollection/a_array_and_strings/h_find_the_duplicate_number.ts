function findDuplicate(nums: number[]): number {
    if (nums.length < 2) {
        return nums[0] ?? 0
    }
    let slow = nums[0]
    let fast = nums[slow]

    // slow & fast will be at the next of the duplicate number
    while (slow != fast) {
        slow = nums[slow]
        fast = nums[nums[fast]]
    }

    // since the duplicate number's next is the same node instead of itself
    // the result should start exactly one step ahead of slow
    let result = 0
    while (slow != result) {
        result = nums[result]
        slow = nums[slow]
    }
    return result
}

console.log(2 == findDuplicate([1, 3, 4, 2, 2]))
console.log(3 == findDuplicate([3, 1, 3, 4, 2]))
console.log(3 == findDuplicate([3, 1, 3, 2]))
console.log(1 == findDuplicate([1, 1]))
console.log(2 == findDuplicate([2, 2, 2, 2, 2]))
console.log(17 == findDuplicate([18, 13, 14, 17, 9, 19, 7, 17, 4, 6, 17, 5, 11, 10, 2, 15, 8, 12, 16, 17]))
