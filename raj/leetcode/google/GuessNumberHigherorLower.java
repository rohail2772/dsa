package com.raj.leetcode.google;

/**
 * 
 * @author Raj
 *
 *         We are playing the Guess Game. The game is as follows:
 * 
 *         I pick a number from 1 to n. You have to guess which number I picked.
 * 
 *         Every time you guess wrong, I'll tell you whether the number is
 *         higher or lower.
 * 
 *         You call a pre-defined API guess(int num) which returns 3 possible
 *         results (-1, 1, or 0):
 * 
 *         -1 : My number is lower 1 : My number is higher 0 : Congrats! You got
 *         it! Example: n = 10, I pick 6.
 * 
 *         Return 6.
 */
public class GuessNumberHigherorLower {

	// Time :O(logn), Space: O(1)
	public int guessNumber(int n) {
		int i = 1, j = n;
		while (i <= j) {
			int mid = (i + (j - i) / 2);
			int res = guess(mid);
		//	System.out.println(mid + ":" + res);
			if (res > 0) {
				i = mid + 1;
			} else if (res < 0) {
				j = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	private int guess(int num) {
		int final_res = 3;
		return final_res > num ? 1 : final_res < num ? -1 : 0;
	}

	public static void main(String[] args) {
		GuessNumberHigherorLower obj = new GuessNumberHigherorLower();
		int result = -1;
		result = obj.guessNumber(10);
		System.out.println(result);

	}

}
