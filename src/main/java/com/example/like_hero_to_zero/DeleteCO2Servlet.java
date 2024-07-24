package com.example.like_hero_to_zero;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteCO2Servlet", value = "/delete-co2")
public class DeleteCO2Servlet extends HttpServlet {
    private CO2WerteDAO co2WerteDAO;

    public DeleteCO2Servlet() {
        this.co2WerteDAO = new CO2WerteDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        co2WerteDAO.delete(id);
        response.sendRedirect("backend");
    }
}