import { ListNode } from "./ListNode.ts"

class Heap<T> {
    readonly #data: T[]
    readonly #betterFn: (parent: T, elem: T) => boolean

    constructor(betterFn: (parent: T, elem: T) => boolean) {
        this.#data = []
        this.#betterFn = betterFn
    }

    add(elem: T) {
        this.#data.push(elem)
        let index = this.#data.length - 1
        while (index > 0) {
            const parentIndex = ~~((index + 1) / 2) - 1
            const parent = this.#data[parentIndex]
            if (this.#betterFn(elem, parent)) {
                [this.#data[index], this.#data[parentIndex]] = [this.#data[parentIndex], this.#data[index]]
                index = parentIndex
            } else {
                break
            }
        }
    }

    peak(): T | null {
        return this.#data[0] ?? null
    }

    mutatePeak(target: T) {
        this.#data[0] = target
        let index = 0
        while (true) {
            const rightIndex = (index + 1) * 2
            const leftIndex = rightIndex - 1
            if (leftIndex < this.#data.length) {
                let betterIndex = leftIndex
                let better = this.#data[leftIndex]
                if (rightIndex < this.#data.length) {
                    const right = this.#data[rightIndex]
                    if (this.#betterFn(right, better)) {
                        betterIndex = rightIndex
                        better = right
                    }
                }
                if (this.#betterFn(better, this.#data[index])) {
                    [this.#data[index], this.#data[betterIndex]] = [this.#data[betterIndex], this.#data[index]]
                    index = betterIndex
                } else {
                    break
                }
            } else {
                break
            }
        }
    }

    pop(): T | null {
        const peak = this.peak()
        const last = this.#data[this.#data.length - 1]
        this.#data.pop()
        if (this.#data.length) {
            this.mutatePeak(last)
        }
        return peak
    }
}

function mergeKLists(lists: Array<ListNode | null>): ListNode | null {
    const heap = new Heap<ListNode>((parent, elem) => {
        return parent.val < elem.val
    })
    for (const list of lists) {
        if (list != null) {
            heap.add(list)
        }
    }

    let current = heap.peak()
    if (current == null) {
        return null
    }
    const head = current
    while (current != null) {
        if (current.next != null) {
            heap.mutatePeak(current.next)
        } else {
            heap.pop()
        }
        current.next = heap.peak()
        current = heap.peak()
    }
    return head
}

console.log(
    ListNode.listFrom(1, 1, 2, 3, 4, 4, 5, 6).listEquals(
        mergeKLists([
            ListNode.listFrom(1, 4, 5),
            ListNode.listFrom(1, 3, 4),
            ListNode.listFrom(2, 6),
        ])
    )
)
