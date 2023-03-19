package exercise.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.lang3.ArrayUtils;

import exercise.TemplateEngineUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;



public class ArticlesServlet extends HttpServlet {

    private String getId(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            return null;
        }
        String[] pathParts = pathInfo.split("/");
        return ArrayUtils.get(pathParts, 1, null);
    }

    private String getAction(HttpServletRequest request) {
        String pathInfo = request.getPathInfo();
        if (pathInfo == null) {
            return "list";
        }
        String[] pathParts = pathInfo.split("/");
        return ArrayUtils.get(pathParts, 2, getId(request));
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
                throws IOException, ServletException {

        String action = getAction(request);

        switch (action) {
            case "list":
                showArticles(request, response);
                break;
            default:
                showArticle(request, response);
                break;
        }
    }

    private void showArticles(HttpServletRequest request,
                          HttpServletResponse response)
                throws IOException, ServletException {

        ServletContext context = request.getServletContext();
        Connection connection = (Connection) context.getAttribute("dbConnection");
        // BEGIN
        String textPage = request.getParameter("page");
        int page;
        int numberOfArticles;
        int articlesPerPage = 10;
        if (textPage==null) {
            page = 1;
        } else {
            page = Integer.parseInt(textPage);
        }

        try {
            String query0 = "SELECT COUNT(*) FROM articles;";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query0);
            result.next();
            numberOfArticles = result.getInt("count(*)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (page <= 0 || page > numberOfArticles / articlesPerPage + 1) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        List<Map<String, String>> articles = new ArrayList<>();
        String query  = "SELECT id, title, body FROM articles ORDER BY id LIMIT ? OFFSET ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, articlesPerPage);
            statement.setInt(2, articlesPerPage * (page - 1));
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                articles.add(Map.of(
                        "id", result.getString("id"),
                        "title", result.getString("title"),
                        "body", result.getString("body")
                ));
            }
        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        request.setAttribute("articles", articles);
        request.setAttribute("page", page);
        // END
        TemplateEngineUtil.render("articles/index.html", request, response);
    }

    private void showArticle(HttpServletRequest request,
                         HttpServletResponse response)
                 throws IOException, ServletException {

        ServletContext context = request.getServletContext();
        Connection connection = (Connection) context.getAttribute("dbConnection");
        // BEGIN
        
        // END
        TemplateEngineUtil.render("articles/show.html", request, response);
    }
}
