<!--% @taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%-->;
<%@ taglib prefix="c" uri="jakarta.tags.core" %>


<html>
<head>
    <title>List Student</title>
</head>
<body>
<h1>List Student</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>des</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="s" items="${sinhVien}">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.description}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
