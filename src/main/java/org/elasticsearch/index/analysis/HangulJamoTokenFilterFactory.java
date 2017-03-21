package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.parser.HangulJamoParserType;

/**
 * Created by changoh on 17. 3. 20.
 */
public class HangulJamoTokenFilterFactory extends AbstractTokenFilterFactory {
    private final String PARAM_PARSER_TYPE = "parserType";
    private HangulJamoParserType parserType;

    public HangulJamoTokenFilterFactory(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
        String parserType = settings.get(PARAM_PARSER_TYPE, HangulJamoParserType.JAMO.name()).toUpperCase();
        this.parserType = HangulJamoParserType.getParserTypeByString(parserType);
    }

    public TokenStream create(TokenStream tokenStream) {
        return new HangulJamoTokenFilter(tokenStream, parserType);
    }
}
