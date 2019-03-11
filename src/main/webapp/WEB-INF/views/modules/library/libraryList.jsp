<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/manage_taglib.jsp" %>
<html>
<head>
    <title>第三方库</title>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#btnModify").click(function () {
                if ($(this).val() === "编辑") {
                    $(this).val("返回");
                    $(".none").show();
                } else {
                    $(this).val("编辑");
                    $(".none").hide();
                }
            })
        })
    </script>
</head>
<body>
<div class="top">
    <span class="title">第三方库列表</span>
    <div style="float:right">
        <a href="${ctx}/library/form" class="btn">添加</a>&nbsp;&nbsp;
        <input id="btnModify" class="btn" type="button" value="编辑">
    </div>
</div>
<table>
    <thead>
    <tr>
        <th>序号</th>
        <th>名称</th>
        <th>版本号</th>
        <th>官网链接</th>
        <th>备注</th>
        <th class="none">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${libraryList}" var="library" varStatus="vs">
        <tr>
            <td>${vs.count}</td>
            <td>${library.name}</td>
            <td>${library.version}</td>
            <td>${library.url}</td>
            <td>${library.remarks}</td>
            <td class="none">
                <a class="btn2" href="${ctx}/library/form?id=${library.id}">修改</a>
                <a class="btn2" href="${ctx}/library/delete?id=${library.id}">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
