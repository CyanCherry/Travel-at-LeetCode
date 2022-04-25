function isRungNeighbor(a: string, b: string): boolean {
    if (a.length !== b.length) {
        return false
    }
    let isRungNeighbor = false
    for (let i = 0; i < a.length; i++) {
        if (a[i] !== b[i]) {
            if (!isRungNeighbor) {
                isRungNeighbor = true
            } else {
                return false
            }
        }
    }
    return isRungNeighbor
}

function ladderLength(beginWord: string, endWord: string, wordList: string[]): number {
    const wordSet = new Set<string>(wordList)
    if (!wordSet.delete(endWord)) {
        return 0
    }
    let beginSet = new Set<string>([beginWord])
    let endSet = new Set<string>([endWord])
    let stepCount = 2
    while (beginSet.size && endSet.size) {
        for (const begin of beginSet.keys()) {
            for (const end of endSet.keys()) {
                if (isRungNeighbor(begin, end)) {
                    return stepCount
                }
            }
        }
        const smallSet = beginSet.size < endSet.size ? beginSet : endSet
        const newSmallSet = new Set<string>()
        smallSet.forEach(small => {
            wordSet.forEach(word => {
                if (isRungNeighbor(small, word)) {
                    wordSet.delete(word)
                    newSmallSet.add(word)
                }
            })
        })
        if (beginSet.size < endSet.size) {
            beginSet = newSmallSet
        } else {
            endSet = newSmallSet
        }
        stepCount++
    }
    return 0
}

console.log(5 == ladderLength("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]))
console.log(0 == ladderLength("hit", "cog", ["hot", "dot", "dog", "lot", "log"]))
console.log(0 == ladderLength("a", "z", ["b"]))
