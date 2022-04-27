function findCircleNum(isConnected: number[][]): number {
    if (isConnected.length == 0) {
        return 0
    }
    for (let i = 0; i < isConnected.length; i++) {
        if (isConnected[i].length != isConnected.length) {
            return 0
        }
    }

    const labels = new Array(isConnected.length).fill(0)
    let groupIndex = 0
    for (let i = 0; i < isConnected.length; i++) {
        if (labels[i] !== 0) {
            continue
        }
        groupIndex++
        const connectedNodes = []
        for (let j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] && labels[j] === 0) {
                labels[j] = groupIndex
                connectedNodes.push(j)
            }
        }
        while (connectedNodes.length) {
            const node = connectedNodes.pop()!
            for (let j = 0; j < isConnected.length; j++) {
                if (isConnected[node][j] && labels[j] === 0) {
                    labels[j] = groupIndex
                    connectedNodes.push(j)
                }
            }
        }
    }
    return new Set(labels).size
}

console.log(2 === findCircleNum([
    [1, 1, 0],
    [1, 1, 0],
    [0, 0, 1],
]))
console.log(3 === findCircleNum([
    [1, 0, 0],
    [0, 1, 0],
    [0, 0, 1],
]))
console.log(1 === findCircleNum([
    [1, 0, 0, 1],
    [0, 1, 1, 0],
    [0, 1, 1, 1],
    [1, 0, 1, 1],
]))
