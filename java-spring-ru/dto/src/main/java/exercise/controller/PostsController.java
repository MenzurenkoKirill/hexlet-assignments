package exercise.controller;

import exercise.exception.ResourceNotFoundException;
import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CommentRepository commentRepository;
    private CommentDTO commentToDTO(Comment comment) {
        var commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setBody(comment.getBody());
        return commentDTO;
    }
    private PostDTO toDTO(Post post) {
        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setBody(post.getBody());
        dto.setTitle(post.getTitle());
        List<Comment> comments = commentRepository.findByPostId(post.getId());
        var commentsDTO = comments.stream().map(this::commentToDTO).toList();
        dto.setComments(commentsDTO);
        return dto;
    }
    @GetMapping("")
    public List<PostDTO> index() {
        var allPosts = postRepository.findAll();
        var result = allPosts.stream()
                .map(this::toDTO)
                .toList();
        return result;
    }
    @GetMapping("/{id}")
    public PostDTO show(@PathVariable long id) {
        var maybePost = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Post with id %s not found", id)));
        return toDTO(maybePost);
    }

}
// END
