<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>用户登录</title>
    <%@ include file="/WEB-INF/views/include/head.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {
            $(".btn-login").click(function () {
                $("#inputForm").submit();
            })
        })
    </script>
</head>
<body>
    <div style="width: 400px; margin: 0 auto">
        <sys:message content="${message}" hide="true" align="center"/>
    </div>
    <div class="h1-title">
        <a href="${ctx}/index/index">全国连锁物流管理系统</a>
    </div>
    <form:form id="inputForm" modelAttribute="user" action="${ctx}/login/validate" method="post" cssClass="sui-validate login">
        <label>账号</label>
        <form:input path="name" data-rules="required" cssStyle="margin-bottom: 20px"/>
        <label>密码</label>
        <form:password path="password" data-rules="required"/>
        <a class="btn-login">登录</a>
        <a class="btn-register" href="${ctx}/register/register">注册</a>
    </form:form>
    <div class="bottom-info">Copyright © 2019-2019 NCLMS - Powered By Hacra
        <a href="https://github.com/ihacra/nclms">Graduation project</a>
    </div>
</body>
</html>
