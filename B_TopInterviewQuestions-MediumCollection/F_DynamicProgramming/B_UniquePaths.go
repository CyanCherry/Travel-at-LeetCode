package main

func uniquePaths(m int, n int) int {
	dp := make([]int, n)
	for i := 0; i < n; i++ {
		dp[i] = 1
	}
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			dp[j] = dp[j-1] + dp[j]
		}
	}
	return dp[len(dp)-1]
}

func main() {
	println(3 == uniquePaths(3, 2))
	println(28 == uniquePaths(3, 7))
}
