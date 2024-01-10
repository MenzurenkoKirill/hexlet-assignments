<!-- BEGIN -->
@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <form action="/users" method="get">
        <input type="search" name="term" value="${page.getTerm()}" />
        <input type="submit" value="Поиск" />
    </form>
    @if(page.getUsers().isEmpty())
        <p>Не найдено ни одного пользователя</p>
    @else
        @for(var user : page.getUsers())
            <div>
                <h3>${user.getFirstName()} ${user.getLastName()}</h3>
            </div>
        @endfor
    @endif
`
)
<!-- END -->
