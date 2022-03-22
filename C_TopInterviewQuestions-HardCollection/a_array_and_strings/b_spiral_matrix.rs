struct Solution {}

impl Solution {
    fn spiral_order_layer(matrix: &Vec<Vec<i32>>, result: &mut Vec<i32>, layer: i32) {
        for i in layer..matrix[layer as usize].len() as i32 - layer - 1 {
            result.push(matrix[layer as usize][i as usize] as i32)
        }
        for i in layer..matrix.len() as i32 - layer - 1 {
            result.push(matrix[i as usize][(matrix[i as usize].len() as i32 - 1 - layer) as usize] as i32)
        }
        for i in (layer + 1..matrix[layer as usize].len() as i32 - layer).rev() {
            result.push(matrix[matrix.len() - 1 - layer as usize][i as usize] as i32)
        }
        for i in (layer + 1..matrix.len() as i32 - layer).rev() {
            result.push(matrix[i as usize][layer as usize] as i32)
        }
    }

    pub fn spiral_order(matrix: Vec<Vec<i32>>) -> Vec<i32> {
        if matrix.len() == 0 {
            return vec![];
        }
        let height = matrix.len();
        let width = matrix[0].len();
        for i in 1..matrix.len() {
            if matrix[i].len() != width {
                return vec![];
            }
        }
        let layer = if height < width { height / 2 } else { width / 2 };

        let mut result: Vec<i32> = Vec::new();

        for l in 0..layer {
            Solution::spiral_order_layer(&matrix, &mut result, l as i32);
        }
        if height < width && height % 2 != 0 {
            for i in layer..matrix[layer].len() - layer {
                result.push(matrix[layer as usize][i])
            }
        } else if width % 2 != 0 {
            for i in layer..matrix.len() - layer {
                result.push(matrix[i][layer as usize])
            }
        }
        return result;
    }
}

fn main() {
    println!("{}", Solution::spiral_order(vec![
        vec![1, 2, 3],
        vec![4, 5, 6],
        vec![7, 8, 9],
    ]) == vec![1, 2, 3, 6, 9, 8, 7, 4, 5]);
    println!("{}", Solution::spiral_order(vec![
        vec![1, 2, 3, 4],
        vec![5, 6, 7, 8],
        vec![9, 10, 11, 12],
    ]) == vec![1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]);
    println!("{}", Solution::spiral_order(vec![
        vec![1],
    ]) == vec![1]);
    println!("{}", Solution::spiral_order(vec![
        vec![2, 3],
    ]) == vec![2, 3]);
    println!("{}", Solution::spiral_order(vec![
        vec![2, 5],
        vec![8, 4],
        vec![0, -1],
    ]) == vec![2, 5, 4, -1, 0, 8]);
    println!("{}", Solution::spiral_order(vec![
        vec![2, 5, 4],
        vec![8, 0, -1],
    ]) == vec![2, 5, 4, -1, 0, 8]);
    println!("{}", Solution::spiral_order(vec![
        vec![1, 2, 3, 4, 5, 6],
        vec![7, 8, 9, 10, 11, 12],
        vec![13, 14, 15, 16, 17, 18],
        vec![19, 20, 21, 22, 23, 24],
        vec![25, 26, 27, 28, 29, 30],
    ]) == vec![1, 2, 3, 4, 5, 6, 12, 18, 24, 30, 29, 28, 27, 26, 25, 19, 13, 7, 8, 9, 10, 11, 17, 23, 22, 21, 20, 14, 15, 16]);
}
