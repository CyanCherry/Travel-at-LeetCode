import { MyArrays } from "../lib.ts"

class RangeMap<V> {
    private readonly size: number
    private readonly map: Map<number, V>

    constructor(size: number) {
        this.size = size
        this.map = new Map()
    }

    private toValue(from: number, to: number) {
        return from * this.size + to
    }

    set(from: number, to: number, value: V) {
        return this.map.set(this.toValue(from, to), value)
    }

    get(from: number, to: number) {
        return this.map.get(this.toValue(from, to))
    }
}

function partition(s: string): string[][] {
    const rm: RangeMap<boolean> = new RangeMap(s.length)

    function isPalindrome(from: number, to: number): boolean {
        // regard each empty string as palindrome
        if (from >= to) {
            return true
        }
        let is = rm.get(from, to)
        if (typeof is === "boolean") {
            return is
        }
        if (s[from] !== s[to - 1]) {
            rm.set(from, to, false)
            return false
        }
        is = isPalindrome(from + 1, to - 1)
        rm.set(from, to, is)
        return is
    }

    function search(result: string[], from: number) {
        if (from < s.length) {
            for (let to = from + 1; to <= s.length; to++) {
                if (isPalindrome(from, to)) {
                    result.push(s.substring(from, to))
                    search(result, to)
                    result.pop()
                }
            }
        } else {
            results.push([...result])
        }
    }

    const results: string[][] = []
    search([], 0)
    return results
}

console.log(MyArrays.equals(
    [["a", "a", "b"], ["aa", "b"]],
    partition("aab"),
))
console.log(MyArrays.equals(
    [["a"]],
    partition("a"),
))
