package ru.ivmiit.servlets;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.ivmiit.db.dao.UsersDao;
import ru.ivmiit.db.dao.UsersDaoJdbcImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Регина on 10.04.2018.
 */

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UsersDao usersDao;

    private Connection connection;

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
            String dbUrl = properties.getProperty("db.url");
            String dbUsername = properties.getProperty("db.username");
            String dbPassword = properties.getProperty("db.password");
            String driverClassName = properties.getProperty("db.driverClassName");
            Class.forName(driverClassName);
            dataSource.setUsername(dbUsername);
            dataSource.setPassword(dbPassword);
            dataSource.setUrl(dbUrl);
            dataSource.setDriverClassName(driverClassName);

            usersDao = new UsersDaoJdbcImpl(dataSource);

            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch(IOException e)
        {
            throw new IllegalStateException(e);
        } catch (SQLException e)
        {
            throw new IllegalStateException(e);
        } catch (ClassNotFoundException e)
        {
            throw new IllegalStateException(e);
        }

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("last_name");
        String password = req.getParameter("password");
        //теперь нужно посмотреть, есть ли такой польз в бд
        //дальше смотри с 1 час 24 минуты (создание сессии)
        if (usersDao.IsExist(login, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", login);
            resp.sendRedirect(req.getContextPath() + "/home");
        } else resp.sendRedirect(req.getContextPath() + "/login");
    }
}
