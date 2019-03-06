<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/manage_taglib.jsp" %>
<html>
<head>
    <title>菜单添加</title>
</head>
<body>
    <form:form modelAttribute="sysMenu" action="${ctx}/sysmenu/save" method="post">
        <form:hidden path="id"/>
        <table>
            <thead>
            <tr>
                <th>parentId</th>
                <th>parentIds</th>
                <th>name</th>
                <th>sort</th>
                <th>isShow</th>
                <th>href</th>
                <th>remarks</th>
                <th>icon</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        <label for="parent.id"></label>
                        <input id="parent.id" name="parent.id" type="text">
                    </td>
                    <td>
                        <input id="parentIds" name="parentIds" type="text">
                    </td>
                    <td>
                        <input id="name" name="name" type="text">
                    </td>
                    <td>
                        <input id="sort" name="sort" type="number">
                    </td>
                    <td>
                        <input id="isShow" name="isShow" type="text">
                    </td>
                    <td>
                        <input id="href" name="href" type="text">
                    </td>
                    <td>
                        <input id="remarks" name="remarks" type="text">
                    </td>
                    <td>
                        <input id="icon" name="icon" type="text">
                    </td>
                </tr>
            </tbody>
        </table>
        <input id="submit" type="submit" value="提交">
    </form:form>
</body>
</html>
