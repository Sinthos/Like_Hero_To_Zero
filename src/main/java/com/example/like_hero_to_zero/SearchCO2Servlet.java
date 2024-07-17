package com.example.like_hero_to_zero;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "searchCO2Servlet", value = "/search-co2")
public class SearchCO2Servlet extends HttpServlet {
    private CO2WerteDAO co2WerteDAO;

    public SearchCO2Servlet() {
        this.co2WerteDAO = new CO2WerteDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("country");
        List<CO2Werte> co2WerteList = co2WerteDAO.findByCountry(country);

        request.setAttribute("co2WerteList", co2WerteList);
        request.getRequestDispatcher("/search-result.jsp").forward(request, response);
    }
}