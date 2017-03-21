package org.elasticsearch.plugin.analysis.hangul;

import org.elasticsearch.index.analysis.HangulJamoTokenFilterFactory;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.Collections;
import java.util.Map;

/**
 * Created by changoh on 17. 3. 20.
 */
public class HangulJamoPlugin extends Plugin implements AnalysisPlugin {

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        return Collections.singletonMap("hangul_jamo", HangulJamoTokenFilterFactory::new);
    }
}
