<!-- BEGIN -->
@import exercise.dto.users.UsersPage
@param UsersPage page

<!doctype html>
<html lang="eng">
    <head>
        <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
                      rel="stylesheet"
                      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                      crossorigin="anonymous">
                <title>Список пользователей</title>
    </head>
    <body>
        @if (page.getUsers().isEmpty())
            <p>Пока не добавлено ни одного пользователя</p>
        @else
            @for(var user : page.getUsers())
                <div>
                    <h2><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></h2>
                </div>
            @endfor
        @endif
    </body>
</html>
<!-- END -->
