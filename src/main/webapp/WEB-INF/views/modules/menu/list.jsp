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
                <th>sort</th>
                <th>isShow</th>
                <th>href</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="sysMenu" varStatus="vs">
                <tr>
                    <td>${sysMenu.id}</td>
                    <td>${sysMenu.name}</td>
                    <td>${sysMenu.sort}</td>
                    <td>${sysMenu.isShow}</td>
                    <td>${sysMenu.href}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
