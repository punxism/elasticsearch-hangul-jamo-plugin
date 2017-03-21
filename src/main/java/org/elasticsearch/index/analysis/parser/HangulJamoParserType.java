package org.elasticsearch.index.analysis.parser;

import java.util.HashMap;
import java.util.Map;

public enum HangulJamoParserType {
    JAMO {
        @Override
        public IJamoParser getParser() {
            return new JamoParser();
        }
    },
    CHOSUNG {
        @Override
        public IJamoParser getParser() {
            return new ChosungParser();
        }
    };

    private static Map<String, HangulJamoParserType> stringToEumMap = new HashMap<>(HangulJamoParserType.values().length);

    static {
        for (HangulJamoParserType type : HangulJamoParserType.values()) {
            stringToEumMap.put(type.toString(), type);
        }
    }

    public static HangulJamoParserType getParserTypeByString(String parserType) {
        if (stringToEumMap.containsKey(parserType)) {
            return stringToEumMap.get(parserType);
        }

        throw new IllegalArgumentException("parserType(" +parserType+") is not found");
    }

    public abstract IJamoParser getParser();
}
