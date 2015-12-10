package com.robmarano;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class javaJourneyTest {
    private Runner runner = new Runner();

    @Before
    public void setUp() {
        runner = new Runner();
    }

    @Test
    public void toString_ShouldReturnString() {
        String fromRunner = runner.toString();
        assertEquals(fromRunner, runner.toString());
    }
}
