<!-- BEGIN -->
@import exercise.dto.users.UserPage
@param UserPage page

<!doctype html>
<html lang="en">
    <head>
            <meta charset="utf-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
                  rel="stylesheet"
                  integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                  crossorigin="anonymous">
            <title>Страница пользователя</title>
        </head>
    <body>
        <main>
            <div>
                <h1>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
                <h2>ID: ${page.getUser().getEmail()} </h2>
            </div>
        </main>
    </body>
</html>
<!-- END -->
