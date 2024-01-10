<!-- BEGIN -->
@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
page = page,
content = @`
    @if(page.getPosts().isEmpty())
        <p>Пока не добавлено ни одного поста</p>
    @else
        @for(var post : page.getPosts())
            <div>
                <h2><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></h2>
                <p>${post.getBody()}</p>
            </div>
        @endfor
    @endif
`
)
<!-- END -->
