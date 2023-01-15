package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    private String attributeBody;
    private List<Tag> tags;
    PairedTag (String tagName, Map<String, String> tagAttributes, String attributeBody, List<Tag> tags) {
        super(tagName, tagAttributes);
        this.attributeBody = attributeBody;
        this.tags = tags;
    }
    @Override
    public String toString() {
        String result = super.toString();
        for (var ch: tags) {
            result +=ch.toString();
        }
        result += attributeBody + "</" + tagName + ">";
        return result;
    }
}
// END
