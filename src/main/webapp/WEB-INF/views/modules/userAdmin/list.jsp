<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>用户管理</title>
    <style type="text/css">
        td span {
            font-size: 14px;
            line-height: 24px;
        }
        td a {
            color: #ea6f5a;
        }
        td a:hover {
            text-decoration: none;
        }
    </style>
    <script type="text/javascript">
        $(document).ready(function() {
            var userId = "${sessionScope.userid}";
            if (userId === "") {
                $.confirm({
                    body: '用户管理需进行用户登录，是否前往登录？',
                    backdrop: true,
                    bgcolor: 'none',
                    okHide: function(){
                        $(location).attr('href', '${ctx}/login/login');
                    },
                    cancelHide: function(){
                        $(location).attr('href', '${ctx}/admin/index/index');
                    }
                });
            }
        });
        function checkDel(url) {
            $.confirm({
                body: '是否确认删除该用户信息？',
                backdrop: true,
                bgcolor: 'none',
                okHide: function(){
                    $(location).attr('href', url);
                },
                cancelHide: function(){

                }
            });
        }
    </script>
</head>
<body>
<div style="width: 50%; margin-left: 25%">
    <sys:message content="${message}" hide="true" align="center"/>
</div>
<h1 style="margin: 10px 0">用户管理(${fn:length(userAdminList)})</h1>
<table class="sui-table table-bordered list2">
    <thead>
    <tr>
        <th style="text-align: center;width: 5%">序号</th>
        <th style="text-align: center;width: 18%">名称</th>
        <th style="text-align: center;width: 21%">密码</th>
        <th style="text-align: center;width: 21%">性别</th>
        <th style="text-align: center;width: 24%">出生日期</th>
        <th style="text-align: center;width: 24%">联系方式</th>
        <th style="text-align: center;width: 24%">居住地址</th>
        <th style="text-align: center;width: 11%">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userAdminList}" var="user" varStatus="vs">
        <tr>
            <td style="text-align: center">${vs.count}</td>
            <td style="text-align: center">${user.name}</td>
            <td style="text-align: center">${user.password}</td>
            <td style="text-align: center">${user.gender}</td>
            <td style="text-align: center">${user.birth}</td>
            <td style="text-align: center">${user.mobile}</td>
            <td style="text-align: center">${user.address}</td>
            <td style="text-align: center">
                <a href="${ctx}/admin/user/view?id=${user.id}">查看</a>&nbsp;
                <a href="${ctx}/admin/user/edit?id=${user.id}">修改</a>&nbsp;
                <a style="cursor: pointer" onclick="checkDel('${ctx}/admin/user/delete?id=${user.id}');">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
