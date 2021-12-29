use std::collections::HashMap;

struct Solution {}

impl Solution {
    pub fn longest_consecutive(nums: Vec<i32>) -> i32 {
        let mut max_len = 0;
        let mut from_to = HashMap::new();
        let mut to_from = HashMap::new();
        for num in nums {
            if from_to.contains_key(&num) || to_from.contains_key(&num) {
                continue;
            }
            let mut right: Option<i32> = None;
            let mut left: Option<i32> = None;
            from_to.entry(num + 1).and_modify(|v| { right = Some(*v) });
            to_from.entry(num - 1).and_modify(|v| { left = Some(*v) });
            match right {
                Some(r) => {
                    match left {
                        Some(l) => {
                            from_to.remove(&(num + 1));
                            from_to.insert(l, r);
                            to_from.remove(&(num - 1));
                            to_from.insert(r, l);
                            max_len = max_len.max(r - l + 1);
                        }
                        None => {
                            from_to.remove(&(num + 1));
                            from_to.insert(num, r);
                            to_from.insert(r, num);
                            max_len = max_len.max(r - num + 1);
                        }
                    }
                }
                None => {
                    match left {
                        Some(l) => {
                            from_to.insert(l, num);
                            to_from.remove(&(num - 1));
                            to_from.insert(num, l);
                            max_len = max_len.max(num - l + 1);
                        }
                        None => {
                            from_to.insert(num, num);
                            to_from.insert(num, num);
                            max_len = max_len.max(1);
                        }
                    }
                }
            }
        }
        return max_len;
    }
}

pub fn test() {
    println!("longest_consecutive_sequence");
    println!("{}", 4 == Solution::longest_consecutive(vec![100, 4, 200, 1, 3, 2]));
    println!("{}", 9 == Solution::longest_consecutive(vec![0, 3, 7, 2, 5, 8, 4, 6, 0, 1]));
    println!("{}", 4 == Solution::longest_consecutive(vec![-7, -1, 3, -9, -4, 7, -3, 2, 4, 9, 4, -9, 8, -7, 5, -1, -7]));
}
