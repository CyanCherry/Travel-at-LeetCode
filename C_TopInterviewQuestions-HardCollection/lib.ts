export namespace MyArrays {
  export function equals(a1: unknown[], a2: unknown[]) {
    return a1.length === a2.length &&
      a1.every((v, i) => v == a2[i])
  }
}

