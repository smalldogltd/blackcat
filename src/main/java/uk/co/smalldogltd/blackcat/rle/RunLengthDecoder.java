package uk.co.smalldogltd.blackcat.rle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunLengthDecoder implements Decoder {

    /**
     * "Decode" a run-length encoded string, replacing patterns of the form {[character];[occurrences]} with the specified character
     * repeated the specified number of times
     * e.g. the encoded string "W{O;6}WWW" will decode to  "WOOOOOOWWW"
     *
     * @param encodedText the encoded text
     * @return the expanded/decoded version of the run-length encoded text
     */
    @Override
    public String decode(String encodedText) {
        StringBuffer plainText = new StringBuffer();
        // match on open brace followed by any character that isn't a semi-colon (as that's our next special char)
        // then semi-colon as the delimiter between the character and number of reps, followed by number of reps
        Pattern pattern = Pattern.compile("([^\\{]+)?\\{([^\\;])\\;([0-9]+)\\}([^\\{]+)?");
        Matcher matcher = pattern.matcher(encodedText);
        String unencodedText = "";
        while (matcher.find()) {
            appendUnencodedText(plainText, matcher.group(1));
            int number = Integer.parseInt(matcher.group(3));
            while (number-- != 0) {
                plainText.append(matcher.group(2));
            }
            appendUnencodedText(plainText, matcher.group(4));
        }
        // if the plaintext buffer has anything in it, then we matched on the pattern
        // so return the buffer
        if (plainText.length()>0) {
            return plainText.toString();
        // otherwise if buffer was empty, there was nothing to decode, so return the input string
        } else {
            return encodedText;
        }
    }

    private void appendUnencodedText(StringBuffer plainText, String unencodedText) {
        if (unencodedText != null) {
            plainText.append(unencodedText);
        }
    }
}
