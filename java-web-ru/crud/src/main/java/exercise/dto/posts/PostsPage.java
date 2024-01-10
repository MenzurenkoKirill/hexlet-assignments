package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;


// BEGIN
@AllArgsConstructor
@Getter
public class PostsPage {
    private List<Post> posts;
    private Integer numberPage;
    public Integer nextPage() {
        return this.getNumberPage() + 1;
    }
    public Integer previousPage() {
        return this.getNumberPage() - 1;
    }
}
// END


