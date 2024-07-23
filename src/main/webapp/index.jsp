<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Like Hero to Zero</title>
</head>
<body>
    <h1>CO2-Emissionen-Dashboard</h1>
    <form method="get" action="search-co2">
        <label for="country">CO2-Emissionen nach Land suchen:</label>
        <input type="text" id="country" name="country" placeholder="Land eingeben" required>
        <input type="submit" value="Suchen">
    </form>
    <br>
    <form action="login.jsp">
        <input type="submit" value="Login">
    </form>
</body>
</html>