<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>Danh sách Sinh Viên</title>
</head>
<body>
<h1>Danh sách Sinh Viên</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Mô tả</th>
        <th>pass</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="sinhVien" items="${getsv}">
        <tr>
                <td>${sinhVien.svid}</td>
            <td>${sinhVien.svname}</td>
            <td>${sinhVien.svphone}</td>
            <td>${sinhVien.svpass}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>