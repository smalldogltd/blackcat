package uk.co.smalldogltd.blackcat.rle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestRunLengthDecoder {

    private RunLengthDecoder decoder;

    @Before
    public void setUp() {
        decoder = new RunLengthDecoder();
    }

    @Test
    public void testDecoding() {

        // test the standard case
        String plainText = decoder.decode(RLETestConstants.BOOM_ENC);
        assertEquals(RLETestConstants.BOOM_PLAIN, plainText);

        plainText = decoder.decode(RLETestConstants.BOOM_ENC_MATCH_BOUNDARIES);
        assertEquals(RLETestConstants.BOOM_PLAIN_MATCH_BOUNDARIES, plainText);

        plainText = decoder.decode(RLETestConstants.BOOM_NO_MATCH);
        assertEquals(RLETestConstants.BOOM_NO_MATCH, plainText);

        // test we handle numbers as expected
        plainText= decoder.decode(RLETestConstants.NUMERIC_ENC);
        assertEquals(RLETestConstants.NUMERIC_PLAIN, plainText);
    }

}
