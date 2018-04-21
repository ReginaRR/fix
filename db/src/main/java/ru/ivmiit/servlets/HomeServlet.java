package ru.ivmiit.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Регина on 10.04.2018.+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    //страничка пользователя
    //тут можно исп куки (второе видео 1 час 4 мин)
    //и еще лист продуктов (третье видео 1 час 40 мин)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/jsp/home.jsp");
        dispatcher.forward(req, resp);
    }
}
