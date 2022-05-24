export namespace MyArrays {
    function defaultCmp<T>(a: T, b: T): boolean {
        if (Array.isArray(a) && Array.isArray(b)) {
            return equals(a, b)
        }
        return a == b
    }

    export function equals<T>(a1: T[], a2: T[], cmp?: (a: T, b: T) => boolean) {
        return a1.length === a2.length &&
            a1.every((v, i) => (cmp ?? defaultCmp)(v, a2[i]))
    }
}

