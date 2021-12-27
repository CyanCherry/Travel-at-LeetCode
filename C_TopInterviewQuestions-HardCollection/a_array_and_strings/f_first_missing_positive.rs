struct Solution {}

impl Solution {
    pub fn first_missing_positive(nums: Vec<i32>) -> i32 {
        let mut exist_flags = vec![false; nums.len() + 1];
        let mut first_missing_positive: i32 = 1;
        'find: for i in 0..nums.len() {
            let num = nums[i];
            if 0 < num && num <= nums.len() as i32 {
                exist_flags[num as usize] = true;
                while exist_flags[first_missing_positive as usize] {
                    first_missing_positive += 1;
                    if first_missing_positive == exist_flags.len() as i32 {
                        break 'find;
                    }
                }
            }
        }
        return first_missing_positive;
    }
}

pub fn test() {
    println!("{}", 3 == Solution::first_missing_positive(vec![1, 2, 0]));
    println!("{}", 2 == Solution::first_missing_positive(vec![3, 4, -1, 1]));
    println!("{}", 1 == Solution::first_missing_positive(vec![7, 8, 9, 11, 12]));
    println!("{}", 1 == Solution::first_missing_positive(vec![2]));
    println!("{}", 2 == Solution::first_missing_positive(vec![1]));
}
