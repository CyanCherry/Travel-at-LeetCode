struct Solution {}

impl Solution {
    // ^\d+( *[\+\-*/] *\d+)$
    pub fn calculate(s: String) -> i32 {
        let mut result = 0i32;
        let mut memory = 0i32;
        let mut number = 0i32;

        // save the first number to memory
        let mut operator = '+';

        let calc = |result: &mut i32, memory: &mut i32, number: &i32, operator: &char| {
            match operator {
                '+' => {
                    *result += *memory;
                    *memory = *number;
                }
                '-' => {
                    *result = *result + *memory;
                    *memory = -*number;
                }
                '*' => {
                    *memory = *memory * *number;
                }
                '/' => {
                    *memory = *memory / *number;
                }
                _ => {
                    panic!()
                }
            }
        };

        for c in s.chars() {
            match c {
                '0'..='9' => {
                    number = number * 10 + c as i32 - 48;
                }
                ' ' => {}
                _ => {
                    calc(&mut result, &mut memory, &number, &operator);
                    number = 0;
                    operator = c;
                }
            }
        }

        // calc the last operator
        calc(&mut result, &mut memory, &number, &operator);
        // maybe there is still some memory, remember it
        return result + memory;
    }
}

fn main() {
    println!("{}", 7 == Solution::calculate(String::from("3+2*2")));
    println!("{}", 1 == Solution::calculate(String::from(" 3/2 ")));
    println!("{}", 5 == Solution::calculate(String::from(" 3+5 / 2 ")));
    println!("{}", 18 == Solution::calculate(String::from(" 18")));
    println!("{}", 18 == Solution::calculate(String::from(" 33-15")));
}
