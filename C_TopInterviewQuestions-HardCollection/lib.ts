export namespace MyArrays {
    function defaultCmp<T>(a: T, b: T): boolean {
        return a == b
    }

    export function equals<T>(a1: T[], a2: T[], cmp?: (a: T, b: T) => boolean) {
        return a1.length == a2.length &&
            a1.every((v, i) => (cmp ?? defaultCmp)(v, a2[i]))
    }

    export function matrixEquals<T>(m1: T[][], m2: T[][], cmp?: (a: T, b: T) => boolean) {
        return m1.length == m2.length &&
            m1.every((a, i) => m2[i].every((v, j) => (cmp ?? defaultCmp)(v, a[j])))
    }
}

