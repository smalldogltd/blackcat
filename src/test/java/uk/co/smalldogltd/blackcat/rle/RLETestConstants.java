package uk.co.smalldogltd.blackcat.rle;

public interface RLETestConstants {

    static final String BOOM_NO_MATCH = "Boom!!";

    static final String BOOM_PLAIN = "KaBBBBBBBooOOOOOOOOOOOOmmMMMMM!!";

    static final String BOOM_ENC = "Ka{B;7}oo{O;12}mm{M;5}!!";

    static final String BOOM_PLAIN_MATCH_BOUNDARIES = "BBBBBBBooOOOOOOOOOOOOmmMMMMM!!!!!";

    static final String BOOM_ENC_MATCH_BOUNDARIES = "{B;7}oo{O;12}mm{M;5}{!;5}";

    static final String NUMERIC_PLAIN = "1111112211";

    static final String NUMERIC_ENC = "{1;6}2211";

    static final String SPECIAL_CHARS = "aa{a;aaaaaa";
    static final String LAX_SPECIAL_CHARS_RESULT = "aa{a;{a;6}";

}
