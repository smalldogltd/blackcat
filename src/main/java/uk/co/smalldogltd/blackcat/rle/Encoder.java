package uk.co.smalldogltd.blackcat.rle;

/**
 * Interface to define run length encoding of a given text string
 */
public interface Encoder {

    /**
     * Run length encode the given string, returning the string with each repeated sequence of characters longer than 5
     * consecutively encoded as {[character];[occurrences]} e.g. the string "WOOOOOOWWW" will encode to "W{O;6}WWW"
     * @param plainText the input string
     * @return the input string encoded as described
     */
    String encode(String plainText);

}