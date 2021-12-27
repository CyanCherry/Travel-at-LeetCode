struct Solution {}

impl Solution {
    // for live cells
    // if they have 2 or 3 live neighbors, they stay alive
    // if they have less than 2 live neighbors, they die
    // if they have more than 3 live neighbors, they also die
    // for dead cells
    // if they have exactly 3 live neighbors, they become alive
    pub fn game_of_life(board: &mut Vec<Vec<i32>>) {
        let height = board.len();
        if height == 0 {
            return;
        }
        let width = board[0].len();
        if width == 0 {
            return;
        }
        for i in 0..height {
            if board[i].len() != width {
                return;
            }
        }

        if height == 1 {
            let row = &board[0];
            let mut row_tmp = board[0].clone();
            row_tmp[0] = 0;
            row_tmp[width - 1] = 0;
            for i in 1..row_tmp.len() - 1 {
                if row[i] == 1 && !(row[i - 1] == 1 && row[i + 1] == 1) {
                    row_tmp[i] = 0
                }
            }
            board[0] = row_tmp;
            return;
        }

        let mut previous_row = board[0].clone();
        for i in 0..previous_row.len() {
            let mut live_neighbor_count = board[1][i];
            if i > 0 {
                live_neighbor_count += board[0][i - 1];
                live_neighbor_count += board[1][i - 1];
            }
            if i < width - 1 {
                live_neighbor_count += board[0][i + 1];
                live_neighbor_count += board[1][i + 1];
            }
            if previous_row[i] == 0 && live_neighbor_count == 3 {
                previous_row[i] = 1;
            }
            if previous_row[i] == 1 && (live_neighbor_count > 3 || live_neighbor_count < 2) {
                previous_row[i] = 0;
            }
        }

        for r in 1..board.len() - 1 {
            let mut row_tmp = board[r].clone();
            for c in 0..row_tmp.len() {
                let mut live_neighbor_count = board[r - 1][c] + board[r + 1][c];
                if c > 0 {
                    live_neighbor_count += board[r][c - 1];
                    live_neighbor_count += board[r - 1][c - 1];
                    live_neighbor_count += board[r + 1][c - 1];
                }
                if c < width - 1 {
                    live_neighbor_count += board[r][c + 1];
                    live_neighbor_count += board[r - 1][c + 1];
                    live_neighbor_count += board[r + 1][c + 1];
                }
                if row_tmp[c] == 0 && live_neighbor_count == 3 {
                    row_tmp[c] = 1;
                }
                if row_tmp[c] == 1 && (live_neighbor_count > 3 || live_neighbor_count < 2) {
                    row_tmp[c] = 0;
                }
            }
            board[r - 1] = previous_row;
            previous_row = row_tmp;
        }
        let mut last_row = board[height - 1].clone();
        for i in 0..width {
            let mut live_neighbor_count = board[height - 2][i];
            if i > 0 {
                live_neighbor_count += board[height - 1][i - 1];
                live_neighbor_count += board[height - 2][i - 1];
            }
            if i < width - 1 {
                live_neighbor_count += board[height - 1][i + 1];
                live_neighbor_count += board[height - 2][i + 1];
            }
            if last_row[i] == 0 && live_neighbor_count == 3 {
                last_row[i] = 1;
            }
            if last_row[i] == 1 && (live_neighbor_count > 3 || live_neighbor_count < 2) {
                last_row[i] = 0;
            }
        }
        board[height - 2] = previous_row;
        board[height - 1] = last_row;
    }
}

pub fn test() {
    let mut board = vec![
        vec![0, 1, 0],
        vec![0, 0, 1],
        vec![1, 1, 1],
        vec![0, 0, 0],
    ];
    Solution::game_of_life(&mut board);
    println!("{}", board == vec![
        vec![0, 0, 0],
        vec![1, 0, 1],
        vec![0, 1, 1],
        vec![0, 1, 0],
    ]);

    let mut board = vec![
        vec![1, 1],
        vec![1, 0],
    ];
    Solution::game_of_life(&mut board);
    println!("{}", board == vec![
        vec![1, 1],
        vec![1, 1],
    ]);

    let mut board = vec![
        vec![0],
    ];
    Solution::game_of_life(&mut board);
    println!("{}", board == vec![
        vec![0],
    ]);
}
