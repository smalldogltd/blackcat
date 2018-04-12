package uk.co.smalldogltd.blackcat.rle;

import java.util.Arrays;

/**
 * Simple implementation of the Encoder interface to encode character sequences where required - each repeated sequence of characters longer than 5
 * will be consecutively encoded as {[character];[occurrences]} e.g. the string "WOOOOOOWWW" will encode to "W{O;6}WWW"
 * @author Paul Davis
 * @version 0.1
 */
public class RunLengthEncoder implements Encoder {

    private  static final char[] SPECIAL_CHARS = new char[]{';','{', '}'};

    private static final int RLE_THRESHOLD = 5;

    private boolean enforceSpecialChars;

    /**
     * Flag to indicate if we should reject strings that match any of the special delimiter characters used when encoding
     * ('{', '}', or ';')
     * @param enforceSpecialChars
     */
    public void setEnforceSpecialChars(boolean enforceSpecialChars) {
        this.enforceSpecialChars= enforceSpecialChars;
    }


    /**
     * Run length encode the given string, returning the string with each repeated sequence of characters longer than 5
     * consecutively encoded as {[character];[occurrences]} e.g. the string "WOOOOOOWWW" will encode to "W{O;6}WWW"
     *
     * @param plainText the input string
     * @return the input string encoded as described
     */
    @Override
    public String encode(String plainText) {
        StringBuffer encodedText = new StringBuffer();
        for (int i = 0; i < plainText.length(); i++) {
            int runLength = 1;
            // track the current character
            char currentChar = plainText.charAt(i);
            // if the enforce special chars flag is set, then check against the special chars
            // and error if we find one
            if (enforceSpecialChars && Arrays.binarySearch(SPECIAL_CHARS, currentChar)>=0) {
                throw new IllegalArgumentException("PlainText contains illegal character " + currentChar);
            }
            // if the next character matches the current character then increment the character counter
            // and the current runlength
            while (i+1 < plainText.length() && currentChar == plainText.charAt(i+1)) {
                runLength++;
                i++;
            }

            // once the next character doesn't match the current character we have completed this block of matching
            // characters so now we can check if the run length is greater than the threshold required to encode
            if (runLength >=RLE_THRESHOLD) {
                encodedText.append("{");
                encodedText.append(currentChar);
                encodedText.append(";");
                encodedText.append(runLength);
                encodedText.append("}");
            } else if (runLength == 1) {
                // where the next character doesn't match, just append the current character
                encodedText.append(currentChar);
            }
            // otherwise we have more a sequence of more than one matching characters but not enough to warrant encoding
            // so squirt in a block of the current character
            else {
                char[] chars = new char[runLength];
                Arrays.fill(chars, currentChar);
                encodedText.append(chars);
            }
        }
        return encodedText.toString();
    }
}
