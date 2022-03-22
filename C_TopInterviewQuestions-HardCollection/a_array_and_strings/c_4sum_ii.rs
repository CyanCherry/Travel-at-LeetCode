use std::collections::HashMap;

struct Solution {}

impl Solution {
    pub fn four_sum_count(nums1: Vec<i32>, nums2: Vec<i32>, nums3: Vec<i32>, nums4: Vec<i32>) -> i32 {
        let mut result = 0;
        let mut map = HashMap::new();
        for i in 0..nums1.len() {
            for j in 0..nums2.len() {
                let sum = nums1[i] + nums2[j];
                let count = map.entry(sum).or_insert(0);
                *count += 1
            }
        }
        for k in 0..nums3.len() {
            for l in 0..nums4.len() {
                let sum = nums3[k] + nums4[l];
                let count = map.get(&-sum);
                result += count.unwrap_or(&0)
            }
        }
        return result;
    }
}

fn main() {
    println!("{}", Solution::four_sum_count(
        vec![1, 2],
        vec![-2, -1],
        vec![-1, 2],
        vec![0, 2],
    ) == 2);
    println!("{}", Solution::four_sum_count(
        vec![0],
        vec![0],
        vec![0],
        vec![0],
    ) == 1);
    println!("{}", Solution::four_sum_count(
        vec![-1, 1, 1, 1, -1],
        vec![0, -1, -1, 0, 1],
        vec![-1, -1, 1, -1, -1],
        vec![0, 1, 0, -1, -1],
    ) == 132);
}
