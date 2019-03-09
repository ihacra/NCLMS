<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/manage_taglib.jsp" %>
<html>
<head>
    <title>第三方库</title>
</head>
<body>
<div class="title">
    <h1>项目中使用到的第三方库</h1>
</div>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>version</th>
        <th>url</th>
    </tr>
    <c:forEach items="${list}" var="library" varStatus="vs">
        <tr>
            <td>${library.id}</td>
            <td>${library.name}</td>
            <td>${library.version}</td>
            <td>${library.url}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
