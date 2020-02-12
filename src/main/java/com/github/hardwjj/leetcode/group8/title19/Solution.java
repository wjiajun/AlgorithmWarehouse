package com.github.hardwjj.leetcode.group8.title19;

/**
 * 题：动态规划 0-1 背包：322. 找零钱的最少硬币数 DFS（力扣）
 * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。 
 *
 * 示例 1:
 *  输入: amount = 5, coins = [1, 2, 5]
 *  输出: 4
 *  解释: 有四种方式可以凑成总金额:
 *  5=5
 *  5=2+2+1
 *  5=2+1+1+1
 *  5=1+1+1+1+1
 *
 * 示例 2:
 *  输入: amount = 3, coins = [2]
 *  输出: 0
 *  解释: 只用面额2的硬币不能凑成总金额3。
 *  示例 3:
 *  输入: amount = 10, coins = [10]
 *  输出: 1
 *
 */
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // 初始化哨兵
        // 可以直接从前往后，因为在枚举一个硬币时不受上一个硬币或当前硬币的影响
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}