class Node {
    val: number
    next: Node | null
    random: Node | null

    constructor(val?: number, next?: Node, random?: Node) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
        this.random = (random === undefined ? null : random)
    }

    static listFrom(...data: [number, number | null][]): Node {
        const nodes = data.map(([value]) => {
            return new Node(value)
        })
        data.forEach(([, random], index) => {
            if (index >= nodes.length) {
                throw new Error("index out of range")
            }
            if (random != null) {
                nodes[index].random = nodes[random]
            }
        })
        for (let i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1]
        }
        return nodes[0]
    }
}

function copyRandomList(head: Node | null): Node | null {
    if (head == null) {
        return null
    }
    const map = new Map<Node, Node>()
    const result = new Node(head.val)
    map.set(head, result)
    let current = head.next
    let resultCurrent = result
    while (current != null) {
        const node = new Node(current.val)
        resultCurrent.next = node
        resultCurrent = node
        map.set(current, node)
        current = current.next
    }
    current = head
    resultCurrent = result
    while (current != null) {
        if (current.random) {
            resultCurrent.random = map.get(current.random) ?? null
        }
        current = current.next
        resultCurrent = resultCurrent.next!
    }
    return result
}

console.log(copyRandomList(Node.listFrom([7, null], [13, 0], [11, 4], [10, 2], [1, 0])))
