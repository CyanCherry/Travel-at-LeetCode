import { MyArrays } from "../lib.ts"

// reference: https://www.enjoyalgorithms.com/blog/binary-indexed-tree/
// trim number from the low bit, to make the number to be power of 2
// for example, divide 9 into 8, 1, to avoid counting from 1 to 8,
// since that, when updating number smaller than 8, 8 has to be updated
class BinaryIndexedTree {
    private readonly data: number[]

    constructor(cap: number) {
        this.data = new Array(cap).fill(0)
    }

    static lowBit(num: number) {
        return num & -num
    }

    update(num: number, count?: number) {
        if (num <= 0) {
            throw new Error(`updating NEGATIVE or ZERO: ${num}`)
        }
        count ??= 1
        while (num < this.data.length) {
            this.data[num] += count
            num += BinaryIndexedTree.lowBit(num)
        }
    }

    getSum(to: number, from?: number) {
        let sum = 0
        while (to > 0) {
            sum += this.data[to]
            to -= BinaryIndexedTree.lowBit(to)
        }
        if (from) {
            sum -= this.getSum(from - 1)
        }
        return sum
    }
}

function countSmaller(nums: number[]): number[] {
    let min = Infinity
    let max = -Infinity
    nums.forEach(num => {
        min = Math.min(num, min)
        max = Math.max(num, max)
    })
    const bias = 1 - min
    const bit = new BinaryIndexedTree(max - min + 2)
    const result = new Array(nums.length)
    for (let i = nums.length - 1; i > -1; i--) {
        const num = nums[i] + bias
        bit.update(num)
        result[i] = bit.getSum(num - 1)
    }
    return result
}

console.log(MyArrays.equals(
    [9, 8, 7, 6, 5, 4, 3, 2, 1, 0],
    countSmaller([9, 8, 7, 6, 5, 4, 3, 2, 1, 0])),
)
console.log(MyArrays.equals(
    [2, 1, 1, 0],
    countSmaller([5, 2, 6, 1])),
)
console.log(MyArrays.equals(
    [0],
    countSmaller([-1])),
)
console.log(MyArrays.equals(
    [2, 0, 0],
    countSmaller([65535, -1, -1])),
)
console.log(MyArrays.equals(
    [0, 0, 1, 1, 0],
    countSmaller([1, 2, 7, 8, 5])),
)
