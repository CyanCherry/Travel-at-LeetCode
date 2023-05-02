import { MyArrays } from "../lib.ts"

type TrieNode = { word: string | null, tree: Trie }

class Trie {
    children: Map<string, TrieNode>

    constructor() {
        this.children = new Map()
    }

    addString(s: string) {
        if (s.length === 0) {
            return
        }
        let node = this.children.get(s[0])
        if (!node) {
            node = {
                tree: new Trie(),
                word: null,
            }
            this.children.set(s[0], node)
        }
        for (let i = 1; i < s.length; i++) {
            const tree: Trie = node!.tree!
            const char = s[i]
            if (!(tree.children.has(char))) {
                tree.children.set(char, {
                    tree: new Trie(),
                    word: null,
                })
            }
            node = tree.children.get(char)
        }
        node!.word = s
    }

    static fromStrings(ss: string[]) {
        const tree = new Trie()
        ss.forEach(s => {
            tree.addString(s)
        })
        return tree
    }
}

function findWords(board: string[][], words: string[]): string[] {
    const dicTree = Trie.fromStrings(words)
    const result: string[] = []

    function search(node: TrieNode | undefined, r: number, c: number) {
        if (node === undefined) {
            return
        }
        if (node.word !== null) {
            // each word should be unique among the results
            result.push(node.word)
            node.word = null
        }
        const tmp = board[r][c]
        board[r][c] = ""
        if (board[r + 1] && board[r + 1][c]) {
            search(node.tree.children.get(board[r + 1][c]), r + 1, c)
        }
        if (board[r - 1] && board[r - 1][c]) {
            search(node.tree.children.get(board[r - 1][c]), r - 1, c)
        }
        if (board[r] && board[r][c + 1]) {
            search(node.tree.children.get(board[r][c + 1]), r, c + 1)
        }
        if (board[r] && board[r][c - 1]) {
            search(node.tree.children.get(board[r][c - 1]), r, c - 1)
        }
        board[r][c] = tmp

        // remove accessed nodes to accelerate iterate
        node.tree.children.forEach((child, char) => {
            if (child.word === null && child.tree.children.size === 0) {
                node.tree.children.delete(char)
            }
        })
    }

    for (let r = 0; r < board.length; r++) {
        for (let c = 0; c < board[r].length; c++) {
            const char = board[r][c]
            search(dicTree.children.get(char), r, c)
        }
    }
    return result
}

console.log(MyArrays.equals(
    ["eat", "oath"],
    findWords([
        ["o", "a", "a", "n"],
        ["e", "t", "a", "e"],
        ["i", "h", "k", "r"],
        ["i", "f", "l", "v"],
    ], ["oath", "pea", "eat", "rain"]).sort(),
))
console.log(MyArrays.equals(
    [],
    findWords([
        ["a", "b"],
        ["c", "d"],
    ], ["abcb"]),
))
console.log(MyArrays.equals(
    ["oa", "oaa"],
    findWords([
        ["o", "a", "b", "n"], ["o", "t", "a", "e"], ["a", "h", "k", "r"], ["a", "f", "l", "v"],
    ], ["oa", "oaa"]),
))
console.log(MyArrays.equals(
    [],
    findWords([
        ["a", "a"],
    ], ["aaa"]),
))
console.log(MyArrays.equals(
    [],
    findWords([
        ["a", "a"],
        ["a", "a"],
    ], ["aaaaa"]),
))

