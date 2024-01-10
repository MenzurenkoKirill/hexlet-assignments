package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).getOrDefault(null);
        var post = PostRepository.find(id).orElseThrow(() -> new NotFoundResponse("Page not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
    public static void index(Context ctx) {
        var repository = PostRepository.getEntities();
        var numberPage = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var start = (numberPage - 1) * 5;
        var end = numberPage * 5;
        var posts = new ArrayList<>(repository.subList(Math.max(0, start), Math.min(end, repository.size())));
        var page = new PostsPage(posts, numberPage);
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }
    // END
}
