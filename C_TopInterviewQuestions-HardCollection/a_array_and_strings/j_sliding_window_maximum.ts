import { MyArrays } from "../lib.ts"

class BHeap<T> {
    #data: { value: T, count: number }[]
    #map: Map<T, number>
    readonly #betterFn: (parent: T, elem: T) => boolean // (parent, elem) : bool

    constructor(betterFn: (parent: T, elem: T) => boolean) {
        this.#data = []
        this.#map = new Map<T, number>()
        this.#betterFn = betterFn
    }

    #swap(valueA: T, valueB: T) {
        const indexA = this.#map.get(valueA)
        const indexB = this.#map.get(valueB)
        if (indexA != undefined && indexB != undefined) {
            [this.#data[indexA], this.#data[indexB]] = [this.#data[indexB], this.#data[indexA]]
            this.#map.set(valueA, indexB)
            this.#map.set(valueB, indexA)
        } else {
            console.error("invalid swapping")
        }
    }

    #tidyUp(index: number) {
        while (true) {
            if (index == 0) {
                return
            }
            const elem = this.#data[index].value
            const parentIndex = ~~((index + 1) / 2) - 1
            const parent = this.#data[parentIndex].value
            if (this.#betterFn(elem, parent)) {
                this.#swap(elem, parent)
                index = parentIndex
            } else {
                return
            }
        }
    }

    #tidyDown(index: number) {
        while (true) {
            const leftIndex = (index + 1) * 2 - 1
            if (leftIndex >= this.#data.length) {
                return
            }
            const left = this.#data[leftIndex].value
            const elem = this.#data[index].value
            let better = left
            let betterIndex = leftIndex
            const rightIndex = leftIndex + 1
            if (rightIndex < this.#data.length) {
                const right = this.#data[rightIndex].value
                if (this.#betterFn(right, better)) {
                    better = right
                    betterIndex = rightIndex
                }
            }
            if (this.#betterFn(better, elem)) {
                this.#swap(better, elem)
                index = betterIndex
            } else {
                return
            }
        }
    }

    // add a element
    add(elem: T) {
        const index = this.#map.get(elem)
        if (index != undefined) {
            this.#data[index].count++
        } else {
            this.#map.set(elem, this.#data.length)
            this.#data.push({ value: elem, count: 1 })
            this.#tidyUp(this.#data.length - 1)
        }
    }

    // remove a element
    remove(elem: T) {
        const index = this.#map.get(elem)
        if (index != undefined) {
            const node = this.#data[index]
            if (node.count > 1) {
                node.count--
            } else {
                const lastIndex = this.#data.length - 1
                let lastElem: T
                if (index != lastIndex) {
                    lastElem = this.#data[this.#data.length - 1].value
                    this.#swap(elem, lastElem)
                }
                this.#data.pop()
                this.#map.delete(elem)
                if (index != lastIndex) {
                    this.#tidyUp(index)
                    this.#tidyDown(this.#map.get(lastElem!)!)
                }
            }
        }
    }

    // return the best element determined by the betterFn, or undefined
    peak(): T | undefined {
        return this.#data[0]?.value
    }
}

function maxSlidingWindow(nums: number[], k: number): number[] {
    if (k > nums.length || k < 0) {
        throw new Error("invalid window size")
    }
    const heap = new BHeap<number>((parent, elem) => parent > elem)
    const result: number[] = []
    for (let i = 0; i < k; i++) {
        heap.add(nums[i])
    }
    const peak = heap.peak()
    // peak may be 0
    if (peak != undefined) {
        result.push(peak)
    }
    for (let i = k; i < nums.length; i++) {
        heap.add(nums[i])
        heap.remove(nums[i - k])
        const peak = heap.peak()
        if (peak != undefined) {
            result.push(peak)
        }
    }
    return result
}

console.log(MyArrays.equals(
    [3, 3, 5, 5, 6, 7],
    maxSlidingWindow([1, 3, -1, -3, 5, 3, 6, 7], 3))
)

console.log(MyArrays.equals(
    [4, 7],
    maxSlidingWindow([2, 4, 7], 2))
)

console.log(MyArrays.equals(
    [1, -1],
    maxSlidingWindow([1, -1], 1))
)

console.log(MyArrays.equals(
    [2, 3, 3, 2],
    maxSlidingWindow([1, 2, 3, 2, 1], 2))
)

console.log(MyArrays.equals(
    [6, 5, 4, 4, 5, 6],
    maxSlidingWindow([6, 5, 4, 3, 4, 5, 6], 2))
)
