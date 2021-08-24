package dev.spaccabolle.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dev.spaccabolle.entity.Score;

class ScoreTest {
	Score score = new Score(0,0,0,0);
	
	@Test
	void testAddPoint() {
		score.addPoint(3725);
		assertEquals(3, score.number);
		assertEquals(7, score.number1);
		assertEquals(2, score.number2);
		assertEquals(5, score.number3);
	}

	@Test
	void testPower() {
		int score = Score.power(2, 2);
		assertEquals(4, score);
	}

}
