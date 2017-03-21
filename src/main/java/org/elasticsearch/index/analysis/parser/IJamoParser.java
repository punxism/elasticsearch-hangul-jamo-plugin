package org.elasticsearch.index.analysis.parser;

/**
 * Created by changoh on 17. 3. 20.
 */
public interface IJamoParser {
    char UNICODE_SYLLABLES_START_CODEPOINT = 0xAC00; //(가)

    int COUNT_IN_UNICODE = 11_172;
    int COUNT_JUNGSUNG_IN_UNICODE = 21;
    int COUNT_JONGSUNG_IN_UNICODE = 28;

    int JAMO_SPLIT_VALUE = COUNT_JONGSUNG_IN_UNICODE * COUNT_JUNGSUNG_IN_UNICODE;

    CharSequence parse(String token);
}
