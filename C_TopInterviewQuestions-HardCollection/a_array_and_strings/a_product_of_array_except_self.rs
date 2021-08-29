struct Solution {}

impl Solution {
    pub fn product_except_self(nums: Vec<i32>) -> Vec<i32> {
        let mut prods = nums.clone();
        for i in 1..nums.len() {
            prods[i] *= prods[i - 1]
        }
        let mut results = vec![0; nums.len()];
        let mut rev_prod: i32 = 1;
        for (i, num) in nums[1..].iter().enumerate().rev() {
            results[i + 1] = prods[i] * rev_prod;
            rev_prod *= num
        }
        results[0] = rev_prod;
        return results;
    }
}

pub fn test() {
    println!("{}", [24, 12, 8, 6].to_vec() == Solution::product_except_self([1, 2, 3, 4].to_vec()))
}
