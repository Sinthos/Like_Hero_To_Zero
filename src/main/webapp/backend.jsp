<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Backend - CO2-Werte Verwaltung</title>
</head>
<body>
    <h1>CO2-Werte Verwaltung</h1>
    <form method="get" action="backend">
        <input type="text" name="filter" placeholder="Land filtern..." />
        <input type="submit" value="Filtern" />
    </form>
    <br />
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Land</th>
                <th>Jahr</th>
                <th>CO2 Emissionen</th>
                <th>Aktionen</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="entry" items="${co2WerteList}">
                <tr>
                    <td>${entry.id}</td>
                    <td>${entry.country}</td>
                    <td>${entry.year}</td>
                    <td>${entry.co2Emissions}</td>
                    <td>
                        <form action="edit-co2" method="get" style="display:inline;">
                            <input type="hidden" name="id" value="${entry.id}" />
                            <input type="submit" value="Bearbeiten" />
                        </form>
                        <form action="delete-co2" method="post" style="display:inline;">
                            <input type="hidden" name="id" value="${entry.id}" />
                            <input type="submit" value="Löschen" />
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br />
    <h2>Neuen Eintrag hinzufügen</h2>
    <form action="add-co2" method="post">
        <label for="country">Land:</label>
        <input type="text" id="country" name="country" required />
        <br />
        <label for="year">Jahr:</label>
        <input type="number" id="year" name="year" required />
        <br />
        <label for="co2Emissions">CO2 Emissionen:</label>
        <input type="number" step="0.01" id="co2Emissions" name="co2Emissions" required />
        <br />
        <input type="submit" value="Hinzufügen" />
    </form>
    <br />
    <form action="logout" method="get">
        <input type="submit" value="Logout">
    </form>
</body>
</html>