function canFinish(numCourses: number, prerequisites: number[][]): boolean {
    const prerequisiteSet = new Set(prerequisites)
    const inCount = new Array(numCourses).fill(0)
    for (let i = 0; i < prerequisites.length; i++) {
        if (prerequisites[i].length !== 2) {
            return false
        }
        const [to, from] = prerequisites[i]
        if (from < numCourses && to < numCourses && from != to) {
            inCount[to]++
        } else {
            return false
        }
    }
    while (prerequisiteSet.size) {
        let isProgressed = false
        prerequisiteSet.forEach((p) => {
            const [to, from] = p
            if (inCount[from] == 0) {
                inCount[to]--
                prerequisiteSet.delete(p)
                isProgressed = true
            }
        })
        if (!isProgressed) {
            return false
        }
    }
    return true
}

console.log(true === canFinish(2, [[1, 0]]))
console.log(false === canFinish(2, [[1, 0], [0, 1]]))
