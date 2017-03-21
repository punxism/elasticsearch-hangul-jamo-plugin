import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.HangulJamoTokenFilterFactory;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.plugin.analysis.hangul.HangulJamoPlugin;
import org.elasticsearch.test.ESTestCase;

import java.io.IOException;

/**
 * Created by changoh on 17. 3. 21.
 */
public class HangulJamoAnalysisTests extends ESTestCase {

    public void testDefaultHangulJamoAnalysis() throws IOException {
        Settings settings = Settings.builder().build();
        TestAnalysis analysis = createTestAnalysis(new Index("test", "_na"), settings, new HangulJamoPlugin());

        TokenFilterFactory filterFactory = analysis.tokenFilter.get("hangul_jamo");
        assertTrue(filterFactory instanceof HangulJamoTokenFilterFactory);
    }

}
