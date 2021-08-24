package dev.spaccabolle.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dev.spaccabolle.score.Score;

class ScoreTest {
	Score score = new Score(0,0,0,0);
	
	@Test
	void testAddPoint() {
		score.addPoint(370, 5);
		assertEquals(3, score.number1);
		assertEquals(7, score.number1);
		assertEquals(3, score.number2);
		assertEquals(2, score.number3);
	}

	@Test
	void testPower() {
		//int score = score.power(2, 2);
		//assertEquals(4, score);
	}

}
