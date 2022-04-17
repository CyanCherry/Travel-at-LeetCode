export class ListNode extends Object {
    val: number
    next: ListNode | null

    constructor(val?: number, next?: ListNode | null) {
        super()
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }

    toString(): string {
        if (this === null) {
            return "null"
        } else {
            let s = String(this.val)
            let next = this.next
            while (next != null) {
                s += " => "
                s += String(next.val)
                next = next.next
            }
            return s
        }
    }

    listEquals(node: ListNode | null): boolean {
        if (node == null) {
            return false
        }
        let me = this.next
        let it = node.next
        while (me != null && it != null) {
            if (me.val != it.val) {
                return false
            }
            me = me.next
            it = it.next
        }
        return me == null && it == null
    }

    static listFrom(...nums: number[]) {
        if (nums.length == 0) {
            throw new Error("empty element")
        }
        const head = new ListNode(nums[0], null)
        let node = head
        for (let i = 1; i < nums.length; i++) {
            const next = new ListNode(nums[i], null)
            node.next = next
            node = next
        }
        return head
    }
}
