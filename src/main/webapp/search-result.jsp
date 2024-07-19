<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Suchergebnisse</title>
</head>
<body>
    <h1>CO2-Emissionen nach Land</h1>
    <c:if test="${not empty co2WerteList}">
        <table border="1">
            <thead>
                <tr>
                    <th>Land</th>
                    <th>CO2-Emissionen</th>
                    <th>Jahr</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="entry" items="${co2WerteList}">
                    <tr>
                        <td><c:out value="${entry.country}"/></td>
                        <td><c:out value="${entry.co2Emissions}"/></td> <!-- Hier sicherstellen, dass der richtige Eigenschaftsname verwendet wird -->
                        <td><c:out value="${entry.year}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty co2WerteList}">
        <p>Keine Ergebnisse gefunden.</p>
    </c:if>
    <br/>
    <a href="index.jsp">Zurück zur Startseite</a>
</body>
</html>