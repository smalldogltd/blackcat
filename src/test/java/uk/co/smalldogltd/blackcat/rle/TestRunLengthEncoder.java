package uk.co.smalldogltd.blackcat.rle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestRunLengthEncoder {

    private RunLengthEncoder encoder;

    @Before
    public void setUp() {
        encoder = new RunLengthEncoder();
    }

    @Test
    public void testEncoding() {

        // test the standard case
        String encText = encoder.encode(RLETestConstants.BOOM_PLAIN);
        assertEquals(RLETestConstants.BOOM_ENC, encText);

        encText = encoder.encode(RLETestConstants.BOOM_PLAIN_MATCH_BOUNDARIES);
        assertEquals(RLETestConstants.BOOM_ENC_MATCH_BOUNDARIES, encText);

        // test we handle the case where there is no encoding required
        encText = encoder.encode(RLETestConstants.BOOM_NO_MATCH);
        assertEquals(RLETestConstants.BOOM_NO_MATCH, encText);

        // test we handle numbers as expected
        encText = encoder.encode(RLETestConstants.NUMERIC_PLAIN);
        assertEquals(RLETestConstants.NUMERIC_ENC, encText);
    }

    @Test
    public void testSpecialChars() {

        String encText;
        // test that we error if the text to be encoded includes any of the 3 special
        // characters used to delimit the RLE
        try {
            encoder.setEnforceSpecialChars(true);
            encText = encoder.encode("aa{a;aaaaaa");
            fail("Encoder should have spotted illegal characters");
        } catch (IllegalArgumentException e) {
            // no-op, expected
        }

        // now test that we don't if enforcement is set to be lax
        encoder.setEnforceSpecialChars(false);
        encText = encoder.encode(RLETestConstants.SPECIAL_CHARS);
        assertEquals(RLETestConstants.LAX_SPECIAL_CHARS_RESULT, encText);
    }

}
