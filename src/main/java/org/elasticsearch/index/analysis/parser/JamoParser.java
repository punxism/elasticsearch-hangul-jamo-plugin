package org.elasticsearch.index.analysis.parser;

/**
 * Created by changoh on 17. 3. 21.
 */
public class JamoParser extends AbstractJamoParser {
    private final char CHAEUM_POINT = 0x0000;

    @Override
    protected void processWhenKorean(StringBuilder meaningfulChars, char chosung, char jungsung, char jongsung) {
        meaningfulChars.append(chosung).append(jungsung);

        if(jongsung != CHAEUM_POINT) {
            meaningfulChars.append(jongsung);
        }
    }

    @Override
    protected void processWhenNotKorean(StringBuilder meaningfulChars, char eachToken) {
        if(Character.isLetterOrDigit(eachToken)) {
            meaningfulChars.append(eachToken);
        }
    }
}
