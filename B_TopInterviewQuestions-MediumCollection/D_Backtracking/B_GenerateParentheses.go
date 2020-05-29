package main

import "reflect"

func generateParenthesis(n int) []string {
    if n < 0 {
        return []string{}
    }
    var results []string
    var try func(result string, unpaired int)
    try = func(result string, unpaired int) {
        if len(result) == n*2 {
            results = append(results, result)
            return
        }
        if len(result)+unpaired < n*2 {
            try(result+"(", unpaired+1)
        }
        if unpaired > 0 {
            try(result+")", unpaired-1)
        }
    }
    try("", 0)
    return results
}

func main() {
    println(reflect.DeepEqual(
        []string{
            "()",
        },
        generateParenthesis(1),
    ))
    println(reflect.DeepEqual(
        []string{
            "(())",
            "()()",
        },
        generateParenthesis(2),
    ))
    println(reflect.DeepEqual(
        []string{
            "((()))",
            "(()())",
            "(())()",
            "()(())",
            "()()()",
        },
        generateParenthesis(3),
    ))
}
