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
        <th>action</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="s" items="${product}">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.description}</td>
            <td><a href="/delete/${s.id}"></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="Category.jsp">back to category</a>
</body>
</html>
