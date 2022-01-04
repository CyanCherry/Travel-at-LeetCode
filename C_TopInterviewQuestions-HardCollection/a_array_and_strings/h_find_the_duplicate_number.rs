struct Solution {}

impl Solution {
    pub fn find_duplicate(nums: Vec<i32>) -> i32 {
        if nums.len() < 2 {
            return 0;
        }
        let mut slow = nums[0];
        let mut fast = nums[slow as usize];
        loop {
            if slow == fast {
                break;
            }
            slow = nums[slow as usize];
            fast = nums[nums[fast as usize] as usize];
        }
        let mut result = 0;
        loop {
            if slow == result {
                return result;
            }
            slow = nums[slow as usize];
            result = nums[result as usize];
        }
    }
}

pub fn test() {
    println!("find_duplicate");
    println!("{}", 2 == Solution::find_duplicate(vec![1, 3, 4, 2, 2]));
    println!("{}", 3 == Solution::find_duplicate(vec![3, 1, 3, 4, 2]));
    println!("{}", 3 == Solution::find_duplicate(vec![3, 1, 3, 2]));
    println!("{}", 1 == Solution::find_duplicate(vec![1, 1]));
    println!("{}", 2 == Solution::find_duplicate(vec![2, 2, 2, 2, 2]));
    println!("{}", 17 == Solution::find_duplicate(vec![18, 13, 14, 17, 9, 19, 7, 17, 4, 6, 17, 5, 11, 10, 2, 15, 8, 12, 16, 17]));
}
