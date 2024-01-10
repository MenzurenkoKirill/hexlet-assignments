package exercise;

import io.javalin.Javalin;
import java.util.List;

import io.javalin.http.Handler;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import java.util.Collections;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var userList = USERS;
            var page = new UsersPage(userList);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });
        app.get("/users/{id}", ctx -> {
           var id = ctx.pathParamAsClass("id", Long.class).get();
           User user = null;
           for (var person : USERS) {
               if (id.equals(person.getId())) {
                   user = person;
                   break;
               }
           }
           if (user == null) {
               throw new NotFoundResponse("User not found");
           }
           var page = new UserPage(user);
           ctx.render("users/show.jte", Collections.singletonMap("page", page));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
