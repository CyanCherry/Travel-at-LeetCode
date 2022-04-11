// ^\d+( *[\+\-*/] *\d+)$
function calculate(s: string): number {
    let result = 0
    let memory = 0
    let number = 0

    // at the very beginning, just save the first number to memory
    let operator = "+"
    const calc = () => {
        if (operator == "+") {
            result += memory
            memory = number
        } else if (operator == "-") {
            result = result + memory
            memory = -number
        } else if (operator == "*") {
            memory = memory * number
        } else if (operator == "/") {
            // bigint has performance issue
            // so calc with number and ignore the fractional part
            memory = ~~(memory / number)
        } else {
            throw new Error("unexpected rune")
        }
    }

    for (const c of s) {
        if (c >= "0" && c <= "9") {
            number = number * 10 + Number(c)
        } else if (c != " ") {
            calc()
            number = 0
            operator = c
        }
    }

    // since there is no operator after the last number
    // calc the last time manually
    calc()

    // maybe there is still some memory, remember it
    return result + memory
}

console.log(7 == calculate("3+2*2"))
console.log(1 == calculate(" 3/2 "))
console.log(5 == calculate(" 3+5 / 2 "))
console.log(18 == calculate(" 18"))
console.log(18 == calculate(" 33-15"))
console.log(13 == calculate("14-3/2"))
