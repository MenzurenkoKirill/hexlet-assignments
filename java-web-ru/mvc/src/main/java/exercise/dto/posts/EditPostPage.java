package exercise.dto.posts;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import io.javalin.validation.ValidationError;
import lombok.Getter;

// BEGIN
@Getter
public class EditPostPage {
    private String name;
    private String body;
    private Map<String, List<ValidationError<Object>>> errors;
    public EditPostPage(String name, String body, Map<String, List<ValidationError<Object>>> errors) {
        this.name = name;
        this.body = body;
        this.errors = errors;
    }

    public EditPostPage(String name, String body) {
        this.name = name;
        this.body = body;
    }
}
// END
