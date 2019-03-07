<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/manage_taglib.jsp" %>
<html>
<head>
    <title>菜单查看列表</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>version</th>
        <th>url</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="library" varStatus="vs">
        <tr>
            <td>${library.id}</td>
            <td>${library.name}</td>
            <td>${library.version}</td>
            <td>${library.url}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
