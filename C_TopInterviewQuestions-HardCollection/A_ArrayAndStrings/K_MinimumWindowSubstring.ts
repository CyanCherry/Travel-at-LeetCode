function minWindow(s: string, t: string): string {
    let start = 0
    let end = 0
    const target: Record<string, number> = {}
    for (const rune of t) {
        target[rune] ??= 0
        target[rune]++
    }
    let targetCount = Object.keys(target).length
    const situation: Record<string, number> = {}
    while (end < s.length) {
        const rune = s[end]
        if (target[rune]) {
            situation[rune] ??= 0
            situation[rune]++
            if (situation[rune] == target[rune]) {
                targetCount--
            }
        }
        end++
        if (targetCount == 0) {
            break
        }
    }
    if (targetCount != 0) {
        return ""
    }

    function moveStart() {
        while (true) {
            const rune = s[start]
            if (!situation[rune]) {
                start++
            } else if (situation[rune] > target[rune]) {
                start++
                situation[rune]--
            } else if (situation[rune] == target[rune]) {
                if (end - start < resultEnd - resultStart) {
                    resultEnd = end
                    resultStart = start
                }
                break
            }
        }
    }

    let resultStart = start
    let resultEnd = end
    moveStart()
    while (end < s.length) {
        const rune = s[end]
        end++
        if (situation[rune]) {
            situation[rune]++
            if (rune == s[start]) {
                moveStart()
            }
        }
    }
    return s.substring(resultStart, resultEnd)
}

console.log("BANC" == minWindow("ADOBECODEBANC", "ABC"))
console.log("a" == minWindow("a", "a"))
console.log("" == minWindow("a", "aa"))
console.log("" == minWindow("", "aa"))
