<!-- BEGIN -->
@import gg.jte.Content
@import exercise.dto.BasePage

@param Content content
@param BasePage page = null

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Домашняя работа</title>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<body>
@if(page != null && page.getFlash() != null)
    <div class="alert alert-success" role="alert">
        <p>${page.getFlash()}</p>
    </div>
@endif
${content}
</body>
</html>
<!-- END -->
