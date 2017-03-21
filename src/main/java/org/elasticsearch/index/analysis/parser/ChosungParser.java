package org.elasticsearch.index.analysis.parser;

/**
 * Created by changoh on 17. 3. 21.
 */
public class ChosungParser extends AbstractJamoParser {
    @Override
    protected void processWhenKorean(StringBuilder meaningfulChars, char chosung, char jungsung, char jongsung) {
        meaningfulChars.append(chosung);
    }

    @Override
    protected void processWhenNotKorean(StringBuilder meaningfulChars, char eachToken) {
        meaningfulChars.append(eachToken);
    }
}
