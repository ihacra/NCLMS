<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/manage_taglib.jsp" %>
<html>
<head>
    <title>第三方库</title>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#btnSave").click(function () {
                $("#inputForm").submit();
            })
        })
    </script>
</head>
<body>
<div class="top">
    <span class="title">第三方库${empty library.id ? '添加' : '修改'}</span>
    <div style="float:right">
        <input id="btnSave" class="btn" type="button" value="保存">&nbsp;&nbsp;
        <input id="btnCancel" class="btn" type="button" value="返回" onclick="history.go(-1)">
    </div>
</div>
<form:form id="inputForm" modelAttribute="library" action="${ctx}/library/save">
    <form:hidden path="id"/>
    <input id="createDate" type="hidden" value="${fns:formatDate(library.createDate)}"/>
    <table>
        <tr>
            <th>名称</th>
            <td><form:input path="name" maxlength="20"/></td>
        </tr>
        <tr>
            <th>版本号</th>
            <td><form:input path="version" maxlength="20"/></td>
        </tr>
        <tr>
            <th>官网链接</th>
            <td><form:input path="url" maxlength="500"/></td>
        </tr>
        <tr>
            <th>备注</th>
            <td><form:input path="remarks" maxlength="100"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
