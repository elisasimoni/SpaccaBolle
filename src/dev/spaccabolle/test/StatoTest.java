package dev.spaccabolle.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dev.spaccabolle.stati.Stato;

class StatoTest {
	Stato stato = null;

	@Test
	void testSetStateAndGetState() {
		Stato.setState(stato);
		assertEquals(stato, Stato.getState());
	}

}
