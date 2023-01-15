package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
class Tag {
    protected String tagName;
    protected Map<String, String> tagAttributes;
    Tag(String tagName, Map<String, String> tagAttributes) {
        this.tagName = tagName;
        this.tagAttributes = tagAttributes;
    }
    @Override
    public String toString() {
        return "<" + tagName + this.enumerationKeysAndValuesOfMap(tagAttributes) + ">";
    }
    private String enumerationKeysAndValuesOfMap(Map<String, String> tagAttributes) {
        StringBuilder txt = new StringBuilder();
        for (Map.Entry entry : tagAttributes.entrySet()) {
            txt.append(" ");
            txt.append(entry.getKey() + "=" + "\"" + entry.getValue() + "\"");
        }
        String result = txt.toString();
        result.trim();
        return result;
    }
}
// END
