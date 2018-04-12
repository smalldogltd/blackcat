package uk.co.smalldogltd.blackcat.rle;

/**
 * Interface to define decoding of a run length encoded string
 */
public interface Decoder {

    /**
     * "Decode" a run-length encoded string, replacing patterns of the form {[character];[occurrences]} with the specified character
     * repeated the specified number of times
     * e.g. the encoded string "W{O;6}WWW" will decode to  "WOOOOOOWWW"
     * @param encodedText the encoded text
     * @return the expanded/decoded version of the run-length encoded text
     */
    String decode(String encodedText);
}
