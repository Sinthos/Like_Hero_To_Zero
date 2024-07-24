package com.example.like_hero_to_zero;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addCO2Servlet", value = "/add-co2")
public class AddCO2Servlet extends HttpServlet {
    private CO2WerteDAO co2WerteDAO;

    public AddCO2Servlet() {
        this.co2WerteDAO = new CO2WerteDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("country");
        int year = Integer.parseInt(request.getParameter("year"));
        double co2Emissions = Double.parseDouble(request.getParameter("co2Emissions"));

        CO2Werte co2Werte = new CO2Werte();
        co2Werte.setCountry(country);
        co2Werte.setYear(year);
        co2Werte.setCo2Emissions(co2Emissions);

        co2WerteDAO.create(co2Werte);
        response.sendRedirect("backend");
    }
}