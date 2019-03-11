<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/default_taglib.jsp" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
    <a href="${path}${fns:getManagePath()}/sysmenu/list">menu</a>
    <a href="${path}${fns:getManagePath()}/sysmenu/form">form</a>
</body>
</html>
