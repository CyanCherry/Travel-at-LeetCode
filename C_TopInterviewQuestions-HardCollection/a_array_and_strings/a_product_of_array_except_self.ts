import { MyArrays } from "../lib.ts"

function productExceptSelf(nums: number[]): number[] {
    const results = new Array(nums.length).fill(1)
    for (let i = 1; i < results.length; i++) {
        results[i] *= results[i - 1] * nums[i - 1]
    }
    let tmp = 1
    for (let i = results.length - 1; i > -1; i--) {
        results[i] *= tmp
        tmp *= nums[i]
    }
    return results
}

console.log(MyArrays.equals([24, 12, 8, 6], productExceptSelf([1, 2, 3, 4])))

