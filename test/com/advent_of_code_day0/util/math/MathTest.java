package com.advent_of_code_day0.util.math;

import static org.junit.Assert.*;

import org.junit.Test;

import com.advent_of_code.day0.util.math.MathUtil;

public class MathTest {

	@Test
	public void test() {
		assertEquals(36, MathUtil.lcm(12, 18));
		assertEquals(11, MathUtil.gcd(55, 121));
	}

}
