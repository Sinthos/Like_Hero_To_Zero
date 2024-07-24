package com.example.like_hero_to_zero;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editCO2Servlet", value = "/edit-co2")
public class EditCO2Servlet extends HttpServlet {
    private CO2WerteDAO co2WerteDAO;

    public EditCO2Servlet() {
        this.co2WerteDAO = new CO2WerteDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        CO2Werte co2Werte = co2WerteDAO.read(id);
        request.setAttribute("co2Werte", co2Werte);
        request.getRequestDispatcher("editCO2.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String country = request.getParameter("country");
        int year = Integer.parseInt(request.getParameter("year"));
        double co2Emissions = Double.parseDouble(request.getParameter("co2Emissions"));

        CO2Werte co2Werte = co2WerteDAO.read(id);
        co2Werte.setCountry(country);
        co2Werte.setYear(year);
        co2Werte.setCo2Emissions(co2Emissions);

        co2WerteDAO.update(co2Werte);
        response.sendRedirect("backend");
    }
}