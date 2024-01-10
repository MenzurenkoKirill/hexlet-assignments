<!-- BEGIN -->
@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
content = @`
    @if(page.getPosts().isEmpty())
        <p>Пока не добавлено ни одного поста</p>
    @else
        <ul>
            @for(var post : page.getPosts())
                <li><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></li>
            @endfor
        </ul>
    @endif
    <div>
        <a href="${NamedRoutes.postsPath()}?page=${page.previous()}">Предыдущая страница</a>
        <a href="${NamedRoutes.postsPath()}?page=${page.next()}">Следующая страница</a>
    </div>
`
)
<!-- END -->
