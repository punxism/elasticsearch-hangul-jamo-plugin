package org.elasticsearch.plugin.analysis.hangul;

import org.elasticsearch.index.analysis.HangulChosungFilterFactory;
import org.elasticsearch.index.analysis.HangulJamoTokenFilterFactory;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by changoh on 17. 3. 20.
 */
public class HangulJamoPlugin extends Plugin implements AnalysisPlugin {

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> extra = new HashMap<>();
        extra.put("hangul_jamo", HangulJamoTokenFilterFactory::new);
        extra.put("hangul_chosung", HangulChosungFilterFactory::new);
        return extra;
    }
}
