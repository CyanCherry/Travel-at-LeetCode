struct Solution {}

impl Solution {
    pub fn max_area(height: Vec<i32>) -> i32 {
        if height.len() < 2 {
            return 0;
        }
        let mut max_area = 0;
        let mut left_index = 0;
        let mut right_index = height.len() - 1;
        while left_index < right_index {
            let left_height = height[left_index];
            let right_height = height[right_index];
            let area = (right_index - left_index) as i32 * std::cmp::min(left_height, right_height);
            if area > max_area {
                max_area = area;
            }
            if left_height < right_height {
                left_index += 1;
            } else {
                right_index -= 1;
            }
        }
        return max_area;
    }
}

fn main() {
    println!("{}", Solution::max_area(vec![1, 1]) == 1);
    println!("{}", Solution::max_area(vec![4, 3, 2, 1, 4]) == 16);
    println!("{}", Solution::max_area(vec![1, 2, 1]) == 2);
}
