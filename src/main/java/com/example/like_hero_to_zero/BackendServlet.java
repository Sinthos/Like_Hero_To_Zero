package com.example.like_hero_to_zero;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "backendServlet", value = "/backend")
public class BackendServlet extends HttpServlet {
    private CO2WerteDAO co2WerteDAO;

    public BackendServlet() {
        this.co2WerteDAO = new CO2WerteDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String filter = request.getParameter("filter");
        List<CO2Werte> co2WerteList;

        if (filter != null && !filter.isEmpty()) {
            co2WerteList = co2WerteDAO.findByCountry(filter);
        } else {
            co2WerteList = co2WerteDAO.readAll();
        }

        request.setAttribute("co2WerteList", co2WerteList);
        request.getRequestDispatcher("backend.jsp").forward(request, response);
    }
}