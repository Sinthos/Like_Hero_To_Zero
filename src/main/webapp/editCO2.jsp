<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>CO2-Wert Bearbeiten</title>
</head>
<body>
    <h1>CO2-Wert Bearbeiten</h1>
    <form action="edit-co2" method="post">
        <input type="hidden" name="id" value="${co2Werte.id}" />
        <label for="country">Land:</label>
        <input type="text" id="country" name="country" value="${co2Werte.country}" required />
        <br />
        <label for="year">Jahr:</label>
        <input type="number" id="year" name="year" value="${co2Werte.year}" required />
        <br />
        <label for="co2Emissions">CO2 Emissionen:</label>
        <input type="number" step="0.01" id="co2Emissions" name="co2Emissions" value="${co2Werte.co2Emissions}" required />
        <br />
        <input type="submit" value="Speichern" />
    </form>
</body>
</html>