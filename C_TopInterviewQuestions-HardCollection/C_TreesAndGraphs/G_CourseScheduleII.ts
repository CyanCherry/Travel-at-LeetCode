import { MyArrays } from "../lib.ts"

function findOrder(numCourses: number, prerequisites: number[][]): number[] {
    const prerequisiteSet = new Set(prerequisites)
    const inCount = new Array(numCourses).fill(0)
    for (let i = 0; i < prerequisites.length; i++) {
        if (prerequisites[i].length !== 2) {
            return []
        }
        const [to, from] = prerequisites[i]
        if (from < numCourses && to < numCourses && from != to) {
            inCount[to]++
        } else {
            return []
        }
    }
    const schedule: number[] = []
    inCount.forEach((ic, i) => {
        if (ic == 0) {
            schedule.push(i)
        }
    })
    while (prerequisiteSet.size) {
        let isProgressed = false
        prerequisiteSet.forEach((p) => {
            const [to, from] = p
            if (inCount[from] == 0) {
                inCount[to]--
                if (inCount[to] == 0) {
                    schedule.push(to)
                }
                prerequisiteSet.delete(p)
                isProgressed = true
            }
        })
        if (!isProgressed) {
            return []
        }
    }
    return schedule
}

console.log(MyArrays.equals([0, 1], findOrder(2, [[1, 0]])))
console.log(MyArrays.equals([0, 1, 2, 3], findOrder(4, [[1, 0], [2, 0], [3, 1], [3, 2]])))
