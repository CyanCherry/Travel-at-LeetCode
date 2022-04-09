function firstMissingPositive(nums: number[]): number {
  const exist_flags = new Array(nums.length + 1).fill(false)
  let first_missing_positive = 1
  find: for (let i = 0; i < nums.length; i++) {
    const num = nums[i]
    if (0 < num && num <= nums.length) {
      exist_flags[num] = true
      while (exist_flags[first_missing_positive]) {
        first_missing_positive += 1
        if (first_missing_positive == exist_flags.length) {
          break find
        }
      }
    }
  }
  return first_missing_positive
}


console.log(3 == firstMissingPositive([1, 2, 0]))
console.log(2 == firstMissingPositive([3, 4, -1, 1]))
console.log(1 == firstMissingPositive([7, 8, 9, 11, 12]))
console.log(1 == firstMissingPositive([2]))
console.log(2 == firstMissingPositive([1]))
