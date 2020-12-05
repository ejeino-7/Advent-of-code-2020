package com.advent_of_code.day0.util.math;

public class MathUtil {

	public static long lcm(long n1, long n2) {
		if(n1 * n2 == 0) { // if either == 0
			return 0;
		}
		n1 = Math.abs(n1);
		n2 = Math.abs(n2);
		long high = Math.max(n1, n2);
		long low = Math.min(n1, n2);
		long lcm = high;
		while(lcm % low != 0) {
			lcm += high;
		}
		return lcm;
	}
	
	
	public static long gcd(long n1, long n2) {
		n1 = Math.abs(n1);
		n2 = Math.abs(n2);
		long gcd = -1;
		for(int i = 1; i <= n1 && i <= n2; i++) {
			if(n1 % i == 0 && n2 % i == 0) {
				gcd = i;
			}
		}
		return gcd;
	}
	
	
}
